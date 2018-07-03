package com.sky.code.oom;

/** 
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
*/
public class HeapOOM{
    
    static class OOMObject{

    }

    public static void main(String[] args){
        List<OOMObject> List=new ArrayList<OOMObject>();

        while(true){
            list.add(new OOMObject());
        }
    }
}