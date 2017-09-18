package com.nastuki.blog;

import org.junit.Test;

import java.util.Random;

/**
 * Created by Nastuki on 2017/9/14.
 */
public class heap {


    public static void main(String[] args) {
        int n = 20;

        int[] heapMap = new int[n + 1];
        Random random = new Random();
        for (int i = 1; i <= n; i++) {
            insert(heapMap, i, random.nextInt(20));
        }
        for (int i : heapMap) {
            System.out.print(i + " ");
        }
        int k = 1;
        int count = n;
        while (count / 2 > 0) {
            k++;
            count = count / 2;
        }
        System.out.println();
        String s;
        for (int i = 1; i < heapMap.length; i = i * 2) {
            s = "";
            for (int g = k; g > 0; g--) {
                s += "    ";
            }
            for (int j = i; j <= i * 2 - 1 && j <= n; j++) {
                System.out.print(s + heapMap[j] + " ");
            }
            k--;
            System.out.println();
        }
    }

    //2,3,9
    static void insert(int[] heapMap, int count, int num) {
        heapMap[count] = num;
        while (count > 1 && heapMap[count] > heapMap[count / 2]) {
            heapMap[count] = heapMap[count] + heapMap[count / 2];
            heapMap[count / 2] = heapMap[count] - heapMap[count / 2];
            heapMap[count] = heapMap[count] - heapMap[count / 2];
            count = count / 2;
        }
    }

    @Test
    public void test1(){
        int n = 20;

        int[] heapMap = new int[n + 1];
        Random random = new Random();
        for (int i = 1; i <= n; i++) {
            insert(heapMap, i, random.nextInt(20));
        }
        for (int i : heapMap) {
            System.out.print(i + " ");
        }
        System.out.println("===================================");
        int m = 10;
        for(int i=1;i<m;i++){
            System.out.print(heapMap[1]+" ");
            heapMap[1] = heapMap[n-i+1];
            shiftDown(heapMap,1,n);
        }
    }

    @Test
    public void test2(){
        int n = 20;

        int[] heapMap = new int[n + 1];
        Random random = new Random();
        for (int i = 1; i <= n; i++) {
            heapMap[i] = random.nextInt(20);
        }
        for (int i=1;i<n;i++) {
            System.out.print(heapMap[i] + " ");
        }
        System.out.println();
        for(int i=n/2;i>0;i--){
            shiftDown(heapMap,i,n);
        }
        for (int i=1;i<n;i++) {
            System.out.print(heapMap[i] + " ");
        }
    }

    static void shiftDown(int[] heapMap, int c,int count) {
        while ( c * 2 < count) {
            if (heapMap[c * 2] < heapMap[c * 2 + 1]) {
                if (heapMap[c] < heapMap[c * 2 + 1]) {
                    heapMap[c] = heapMap[c] + heapMap[c * 2 + 1];
                    heapMap[c * 2 + 1] = heapMap[c] - heapMap[c * 2 + 1];
                    heapMap[c] = heapMap[c] - heapMap[c * 2 + 1];
                    c = c * 2 + 1;
                }else{
                    break;
                }
            } else if (heapMap[c * 2] >= heapMap[c * 2 + 1]) {
                if (heapMap[c] < heapMap[c * 2]) {
                    heapMap[c] = heapMap[c] + heapMap[c * 2];
                    heapMap[c * 2] = heapMap[c] - heapMap[c * 2];
                    heapMap[c] = heapMap[c] - heapMap[c * 2];
                    c = c * 2;
                }else{
                    break;
                }
            }else{
                break;
            }
        }
    }

    static void shiftDown1(int[] heapMap, int count,int n) {
        heapMap[1] = heapMap[count];
        int c = 1;
        while (c < count && c * 2 < n) {
            if (heapMap[c * 2] < heapMap[c * 2 + 1]) {
                if (heapMap[c] < heapMap[c * 2 + 1]) {
                    heapMap[c] = heapMap[c] + heapMap[c * 2 + 1];
                    heapMap[c * 2 + 1] = heapMap[c] - heapMap[c * 2 + 1];
                    heapMap[c] = heapMap[c] - heapMap[c * 2 + 1];
                    c = c * 2 + 1;
                }else{
                    break;
                }
            } else if (heapMap[c * 2] >= heapMap[c * 2 + 1]) {
                if (heapMap[c] < heapMap[c * 2]) {
                    heapMap[c] = heapMap[c] + heapMap[c * 2];
                    heapMap[c * 2] = heapMap[c] - heapMap[c * 2];
                    heapMap[c] = heapMap[c] - heapMap[c * 2];
                    c = c * 2;
                }else{
                    break;
                }
            }else{
                break;
            }
        }
    }
}
