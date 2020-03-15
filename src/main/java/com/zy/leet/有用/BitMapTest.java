package com.zy.leet.有用;

import sun.security.util.BitArray;

/**
 * 数据量大的场景，难以做查重，排序，数据量过大会占用较大内存
 * 常用处理方式:BitMap(位图法)和布隆过滤
 *
 *
 * 例如:10亿个正整数，给定一个数值，如何快速排定是否存在于这些数字中
 *     位图法的思想类似于hash寻址,首先初始化一个int数组，每个元素对应32比特位，将10亿读入
 *     内存，对int中的元素比特位进行标记，如果存在，标记为一，标记完即可判定某个元素是否在
 *     10亿个正整数中，时间复杂度为O(1)
 *
 *     寻址
 *     比如元素 119，如何确定其对应的数组比特位 index ？
 *     1）确定数组 index：119/32 = 3.7，也就是第 4 个数组元素，a[3] 的位置。
 *     2）确定比特位 index：119%32 = 23，第23个比特位。
 *     3）将比特位设置为1。
 *
 * 优点：实现简单。适合数据量比较大的场景。
 * 缺点：占用内存。
 * */
public class BitMapTest {

    private int[] bigArray;

    public BitMapTest(long size){
        //计算确实申请多大多的数组
        bigArray = new int[(int) (size/32 +1)];
    }

    public void set1(int num){
        //确定数组 index
        int arrayIndex = num >> 5;
        //确定 bit index
        int bitIndex = num & 31;
        //设置0
        bigArray[arrayIndex] |= 1 << bitIndex;
    }

    public void set0(int num){
        //确定数组
        int arrayIndex = num >>5;
        //确定bit index
        int bitIndex = num & 31;
        //设置0
        bigArray[arrayIndex] &= ~(1 << bitIndex);
        System.out.println(get32BitBinString(bigArray[arrayIndex]));
    }

    public boolean isExist(int num){
        //确定数组 index
        int arrayIndex = num >>5;
        //确定bit index
        int bitIndex = num & 31;
        //判断是否存在
        return (bigArray[arrayIndex] & ((1 << bitIndex))) !=0 ? true : false ;
    }

    /**
     * 将整型数字转换为二进制字符串，一共32位，不舍弃前面的0
     * */
    private static String get32BitBinString(int number){
        StringBuilder sBuilder = new StringBuilder();
        for (int i=0;i<32;i++){
            sBuilder.append(number &1);
            number = number >>>1;
        }
        return sBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        int[] arrays = new int[] {1,2,35,78,334,335,555,577};
        BitMapTest bitMapTest =new BitMapTest(577 -1);
        for (int i : arrays){
            bitMapTest.set1(i);
        }
        System.out.println(bitMapTest.isExist(35));
    }
}
