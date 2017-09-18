package com.nastuki.blog;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Nastuki on 2017/9/12.
 */
public class code1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrays;
        int num,temp,j,g;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            num = Integer.parseInt(br.readLine());
            arrays = br.readLine().split(" ");
            if (num != arrays.length) {
                break;
            }
            j = 0;
            g = Integer.parseInt(arrays[0]);
            for (int i = 1; i < arrays.length; i++) {
                temp = Integer.parseInt(arrays[i]);
                if (g > temp ) {
                    g = temp;
                    j = i;
                }
            }
            System.out.println(j + 1);
        }
        return;
    }
}
