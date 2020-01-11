package com.bloom_filter;

import java.util.BitSet;

/**
 * @创建人 sgwang
 * @name BlackFilter
 * @user 91119
 * @创建时间 2019/10/23
 * @描述
 */
public class BlackFilter {

    private static final int DEFAULT_SIZE = 2 << 24;

    // 为质数，减少碰撞，原因：
    private static final int seeds[] = new int[]{3, 5, 7, 9, 11, 13, 17, 19};
    private static HashFun[] hashAr = new HashFun[8];

    static {
        for (int i = 0; i < seeds.length; i++) {
            hashAr[i] = new HashFun(seeds[i]);
        }
    }

    //  hash方法结果记录到bitSet
    private BitSet bitSet = new BitSet(DEFAULT_SIZE);

    // 将String经过Hash,结果放入bitSet
    public void add(String content) {
        for (HashFun h : hashAr) {
            bitSet.set(h.getHash(content));
        }
    }

    public boolean contains(String content) {
        boolean have = true;
        for (HashFun hash : hashAr) {
            have &= bitSet.get(hash.getHash(content));
        }
        return have;
    }

    public static void main(String[] args) {
        String email = "xiaozhuanfeng@126.com";
        BlackFilter bloomDemo = new BlackFilter();
        System.out.println(email + "是否在列表中： " + bloomDemo.contains(email));

        bloomDemo.add(email);
        System.out.println(email + "是否在列表中： " + bloomDemo.contains(email));

        email = "xiaozhuanfeng@163.com";
        System.out.println(email + "是否在列表中： " + bloomDemo.contains(email));
    }

    private static class HashFun {
        private int seed = 0;

        public HashFun(int seed) {
            this.seed = seed;
        }

        public int getHash(String string) {
            int val = 0;
            for (int i = 0; i < string.length(); i++) {
                //与质数相乘+Assic码
                val = val * seed + string.charAt(i);
            }

            //长度为（2的次幂-1），减少碰撞
            //注意：&& 和&的区别（&& 第一表达式flase,第二表达式就不执行了，所以如果类似  val &= function()要注意）
            return val & (DEFAULT_SIZE - 1);
        }
    }

}
