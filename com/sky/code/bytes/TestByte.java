package com.sky.code.bytes;

import java.io.UnsupportedEncodingException;

public class TestByte {
    public static void main(String[] args){
        byte[] bytes=new byte[]{'a'};
        System.out.println(bytes.length);

        try {
            bytes="abc一".getBytes("UTF-16");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(bytes.length);

        char a='a';
        for(byte b : charToByte(a)){
            System.out.println(b);
        }

    }


    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }
}
