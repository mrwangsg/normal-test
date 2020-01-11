package com.bloom_filter;

import java.util.BitSet;

/**
 * @创建人 sgwang
 * @name BitSetDemo
 * @user 91119
 * @创建时间 2019/10/23
 * @描述
 */
public class BitSetDemo {

    public static void main(String[] args) {
        printSizeOfBitSet();
        primeNumber();
    }

    public static void printSizeOfBitSet() {
        BitSet bitSet = new BitSet();
        System.out.println(bitSet.size());
    }

    public static void primeNumber() {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet sieve = new BitSet(n + 1);
        int count = 0;
        for (int i = 2; i <= n; i++) {
            sieve.set(i);
        }
        int finalBit = (int) Math.sqrt(n);

        for (int i = 2; i < finalBit; i++) {
            if (sieve.get(i)) {
                for (int j = 2 * i; j < n; j += i) {
                    sieve.clear(j);
                }
            }
        }
        int counter = 0;
        for (int i = 1; i < n; i++) {
            if (sieve.get(i)) {
                count++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " ms");
    }

}
