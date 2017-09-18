package com.nastuki.blog;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Nastuki on 2017/9/12.
 */
public class code2 {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = bf.readLine().split(" ");

        int s = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);

        System.out.print(s % 10 == 9 ? s - 1 : s + 1);
    }

    @Test
    public void test() {
        int a = 12;
        int b = 8;
        System.out.println("a:" + a + "  b:" + b);
        a = a ^ b;
        System.out.println("a:" + a + "  b:" + b);
        b = a ^ b;
        System.out.println("a:" + a + "  b:" + b);
        a = a ^ b;
        System.out.println("a:" + a + "  b:" + b);
    }
}
