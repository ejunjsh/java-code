package com.sky.code.mysql;

import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DbCas {

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.5.129:3306/test";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "example";

    static AtomicInteger counter=new AtomicInteger(0);

    public static void consumer(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            conn.setAutoCommit(false);

            Statement statement=conn.createStatement();


            while (true){

                String sql="select version from tx where id=1 and num<>0";
                ResultSet rs=statement.executeQuery(sql);

                if (rs.next()) {
                    int version = rs.getInt("version");

                    rs.close();

                    sql="update tx set num=num-1,version=version+1 where id=1 and version=" + version;

                    int record = statement.executeUpdate(sql);

                    if (record == 1) {
                        counter.getAndIncrement();
                    }

                    conn.commit();
                }
                else {
                    break;
                }
            }

            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try {
            Class.forName(JDBC_DRIVER);

            Thread[] threads=new Thread[10];

            for(int i=0;i<10;i++){
                Thread thread=new Thread(() -> consumer());
                thread.start();
                threads[i]=thread;
            }

            for(int i=0;i<10;i++){
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.printf("finally update %d records",counter.get());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
