package com.sky.code.algorithm;


public class BinarySearch {

    public static int binarySearch(Integer[] srcArray, int des) {
        //定义初始最小、最大索引
        int low = 0;
        int high = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while ((low <= high) && (low <= srcArray.length - 1)
                && (high <= srcArray.length - 1)) {
            //计算出中间索引值
            int middle = (high + low)/2 ;
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                //判断上限
            } else {
                low = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }

    public static void main(String[] args){
        Integer[] integers={1,2,3,4,59,111,333,1111,3333,44444};

        System.out.println(binarySearch(integers,1111));
    }
}
