package com.nastuki.blog;

import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.Random;

/**
 * Created by Nastuki on 2017/8/21.
 */
public class test {

    @Test
    public void test1() {
        int n = 30000;
        Random random = new Random(n);
        int[] array = new int[n];
        for (int i = n - 1; i > 0; i--) {
            //array[i] = random.nextInt(2);
            array[n - i] = i;
        }
        generateArray(array, 10, n);

        int[] array1 = array.clone();
        int[] array2 = array.clone();
        Long time1 = new Date().getTime();
        selectSort(array);
        Long time2 = new Date().getTime();
        insertSort(array1);
        Long time3 = new Date().getTime();
        insertSort1(array2);
        Long time4 = new Date().getTime();
        shellSort1(array2);
        Long time = new Date().getTime();

        System.out.println("selectSort:" + (time2 - time1));
        System.out.println("insertSort:" + (time3 - time2));
        System.out.println("insertSort1:" + (time4 - time3));
       /* for(int i:array){
            System.out.println(i);
        }*/
    }

    @Test
    public void test2() {
        int n = 10;
        Random random = new Random(n);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }
        int[] array1 = {2, 3, 1, 5};
        selectSort(array1);
        //Assert.isTrue(validate(array));
        for (int i : array1) {
            System.out.println(i);
        }
    }

    public void generateArray(int[] array, int n, int x) {
        int i;
        int j;
        for (int k = 0; k < n; k++) {
            i = new Random().nextInt(x);
            j = new Random().nextInt(x);
            array[i] = array[i] + array[j];
            array[j] = array[i] - array[j];
            array[i] = array[i] - array[j];
        }

    }

    public boolean validate(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    array[i] = array[i] + array[j];
                    array[j] = array[i] - array[j];
                    array[i] = array[i] - array[j];
                }
            }
        }
    }

    public void scArray(int[] array, int n) {
        Random random = new Random();
        for (int i = n - 1; i > 0; i--) {
            array[i] = random.nextInt(n);
        }
    }

    @Test
    public void test5() {
        int n = 50000;
        int[] array = new int[n];
        scArray(array, n);
        //enerateArray(array, 10, n);
        for (int i = n - 1; i > 0; i--) {
            //array[i] = random.nextInt(2);
            array[n - i] = i;
        }
        generateArray(array, 0, n);

        int[] array1 = array.clone();
        int[] array2 = array.clone();
        int[] array3 = array.clone();
        int[] array4 = array.clone();
        int[] array5 = array.clone();
        int[] array6 = array.clone();

        Long time1 = new Date().getTime();
        selectSort(array);
        Long time2 = new Date().getTime();
        insertSort(array1);
        Long time3 = new Date().getTime();
        insertSort1(array2);
        Long time4 = new Date().getTime();
        shellSort(array3);
        Long time5 = new Date().getTime();
        bubbleSort(array4);
        Long time6 = new Date().getTime();
        shellSort1(array5);
        Long time7 = new Date().getTime();
        shellSort1(array6);
        Long time8 = new Date().getTime();


        System.out.println("selectSort:" + (time2 - time1));
        System.out.println("insertSort:" + (time3 - time2));
        System.out.println("insertSort1:" + (time4 - time3));
        System.out.println("shellSort:" + (time5 - time4));
        System.out.println("shellSort1:" + (time7 - time6));
        System.out.println("bubbleSort:" + (time6 - time5));
        System.out.println("mergeSort:" + (time8 - time7));
       /* for(int i:array){
            System.out.println(i);
        }*/
    }

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
    }


    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] > array[j - 1]; j--) {
                array[j] = array[j] + array[j - 1];
                array[j - 1] = array[j] - array[j - 1];
                array[j] = array[j] - array[j - 1];
            }
        }
    }

    //2,3,1,5
    public void insertSort1(int[] array) {
        int s;
        for (int i = 1; i < array.length; i++) {
            s = array[i];
            int j;
            for (j = i; j > 0 && array[j - 1] < s; j--) {
                array[j] = array[j - 1];
            }
            array[j] = s;
        }
    }


    @Test
    public void test3() {
        int n = 10;
        Random random = new Random(n);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }
        insert1(array);
        Assert.isTrue(validate(array));
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void insert(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] > array[j - 1]; j--) {
                array[j] = array[j] + array[j - 1];
                array[j - 1] = array[j] - array[j - 1];
                array[j] = array[j] - array[j - 1];
            }
        }
    }

    public void insert1(int[] array) {
        int a;
        for (int i = 1; i < array.length; i++) {
            a = array[i];
            int j;
            for (j = i; j > 0 && a > array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = a;
        }
    }

    @Test
    public void test4() {
        int n = 10;
        Random random = new Random(n);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(2);
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    @Test
    public void shellSortTest() {
        int n = 10;
        Random random = new Random(n);
        int[] array = {3, 0, 4, 5, 8, 1, 3, 0, 2, 7};
        /*for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }*/
        shellSort1(array);
        for (int i : array) {
            System.out.print(i + " , ");
        }
    }

    @Test
    public void shellSortTest1() {
        int n = 100000;
        Random random = new Random(n);
        int[] array = new int[n];
        //int[] array = {3, 0, 3, 0, 4, 6, 7, 8, 1, 6};
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }
        int[] array1 = array.clone();
        int[] array2 = array.clone();
        Long time1 = new Date().getTime();
        shellSort(array);
        Long time2 = new Date().getTime();
        shellSort1(array1);
        Long time3 = new Date().getTime();
        insert1(array2);
        Long time4 = new Date().getTime();
        /*for (int i : array) {
            System.out.print(i + " , ");
        }
        System.out.println( "");
        for (int i : array1) {
            System.out.print(i + " , ");
        }
        System.out.println( "");
        for (int i : array2) {
            System.out.print(i + " , ");
        }*/

        System.out.println("");
        System.out.println("insert1:" + (time4 - time3));
        System.out.println("shellSort:" + (time2 - time1));
        System.out.println("shellSort1:" + (time3 - time2));
    }


    @Test
    public void test6() {
        int n = 1000000;
        int[] array = new int[n];
        scArray(array, n);
        //enerateArray(array, 10, n);
        for (int i = n - 1; i > 0; i--) {
            //array[i] = random.nextInt(2);
            array[n - i] = i;
        }
        generateArray(array, 0, n);

        int[] array1 = array.clone();
        int[] array2 = array.clone();
        int[] array3 = array.clone();
        int[] array4 = array.clone();
        int[] array5 = array.clone();
        int[] array6 = array.clone();

        Long time1 = new Date().getTime();
        //selectSort(array);
        Long time2 = new Date().getTime();
        insertSort(array1);
        Long time3 = new Date().getTime();
        insertSort1(array2);
        Long time4 = new Date().getTime();
        shellSort(array3);
        Long time5 = new Date().getTime();
        //bubbleSort(array4);
        Long time6 = new Date().getTime();
        shellSort1(array5);
        Long time7 = new Date().getTime();
        shellSort1(array6);
        Long time8 = new Date().getTime();


        //System.out.println("selectSort:" + (time2 - time1));
        System.out.println("insertSort:" + (time3 - time2));
        System.out.println("insertSort1:" + (time4 - time3));
        System.out.println("shellSort:" + (time5 - time4));
        System.out.println("shellSort1:" + (time7 - time6));
        //System.out.println("bubbleSort:" + (time6 - time5));
        System.out.println("mergeSort:" + (time8 - time7));
       /* for(int i:array){
            System.out.println(i);
        }*/
    }
    @Test
    public void mergeSortTest() {
        int[] array = { 3, 0, 4, 6, 7, 8, 1, 6,5,2};
        mergeSort(array);
        for (int i : array) {
            System.out.print(i + " , ");
        }
    }
    public void shellSort(int[] array) {
        int i;
        int j;
        int k;
        int gap;
        int a;
        for (gap = array.length / 2; gap > 0; gap /= 2) {
            for (i = 0; i < gap; i++) {
                for (j = i; j < array.length; j += gap) {
                    a = array[j];
                    for (k = j; k >= gap && a > array[k - gap]; k -= gap) {
                        array[k] = array[k - gap];
                    }
                    array[k] = a;
                }
            }
        }
    }


    public void shellSort1(int[] array) {
        int j;
        int k;
        int gap;
        int a;

        for (gap = array.length / 2; gap > 0; gap /= 2) {
            for (j = gap; j < array.length; j++) {
                a = array[j];
                for (k = j; k >= gap && a > array[k - gap]; k -= gap) {
                    array[k] = array[k - gap];
                }
                array[k] = a;
            }
        }
    }

    public void mergeSort(int[] array) {
        int n = array.length;
        merge(array, 0, n-1);

    }

    public void merge(int[] array, int l, int r) {
        if (l >= r) {
            return;
        } else {
            merge(array, l, (l + r) / 2);
            merge(array, (l + r) / 2 + 1, r);
            if(array[(l + r) / 2]<array[(l + r) / 2 + 1]){
                mergeSortM(array, l, (l + r) / 2, r);
            }
        }
    }

    public void mergeSortM(int[] array, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <=r; i++) {
            aux[i - l] = array[i];
        }
        for(int a:aux){
            System.out.print(a + " , ");
        }
        System.out.println( " ");
        System.out.println("l:"+l+" mid:"+mid+" r:"+r);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <=r; k++) {

            if (i > mid) {
                array[k] = aux[j - l];
                j++;
            } else if (j > r) {
                array[k] = aux[i - l];
                i++;
            } else if (aux[i - l] > aux[j - l]) {
                array[k] = aux[i - l];
                i++;
            } else {
                array[k] = aux[j - l];
                j++;
            }
        }
        for(int a:array){
            System.out.print(a + " , ");
        }
        System.out.println( " ");
        System.out.println( " ");
    }

}
