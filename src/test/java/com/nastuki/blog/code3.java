package com.nastuki.blog;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Nastuki on 2017/9/14.
 */
public class code3 {

    static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long n;
        while ((n = sc.nextInt()) <= 1000000000 && n >= 0) {
            System.out.println(n == 0 ? 0 : getSum(n));
        }
        return;
    }

    static long getSum(long s) {
        if (map.get(s) != null) {
            return map.get(s);
        }
        if (s / 2 + s / 3 + s / 4 <= s) {
            return s;
        }
        long sum = getSum(s / 2) + getSum(s / 3) + getSum(s / 4);
        map.put(s, sum);
        return sum;
    }
}
