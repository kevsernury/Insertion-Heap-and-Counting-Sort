/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author Kevsernur
 */
public class Main {

    static long start;
    static long end;
    static long beforeUsedMem;
    static long afterUsedMem;
    static long actualMemUsed;

    public static void main(String[] args) {

        NewArray array_100 = new NewArray(100);
        NewArray array_bin = new NewArray(1000);
        NewArray array_50bin = new NewArray(50000);
        NewArray array_500bin = new NewArray(500000);
        NewArray array_10milyon = new NewArray(10000000);

        System.out.println("-------100--------");
        CountTime(array_100);
        System.out.println("");
        System.out.println("-------1.000--------");
        CountTime(array_bin);
        System.out.println("");
        System.out.println("-------50.000--------");
        CountTime(array_50bin);
        System.out.println("");
        System.out.println("-------500.000--------");
        CountTime(array_500bin);
        System.out.println("");
        System.out.println("-------10.000.000--------");
        CountTime(array_10milyon);

    }

    private static void CountTime(NewArray array) {

        //Haep
        System.out.println("---Heap Sort---");
        AllHeapSort(array);

        //Count
        System.out.println("---Counting Sort---");
        AllCountingSort(array);

        //instertion
    }

    private static void AllCountingSort(NewArray array) {

        //    System.out.println("ASC array");
        //  PrintArray(array.AscArray);
        //beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        beforeUsedMem = Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        Counting ascArr = new Counting(array.AscArray);
        ascArr.Sort();
        end = System.nanoTime();
        //afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        afterUsedMem = Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Asc (K->B) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);
       // PrintArray(ascArr.ResultArray);

        //System.out.println("DESC array");
        //PrintArray(array.DescArray);        
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        Counting descArr = new Counting(array.DescArray);
        descArr.Sort();
        end = System.nanoTime();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Desc (B->K) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);
       // PrintArray(descArr.ResultArray);

        //   System.out.println("Random array");
        //   PrintArray(array.RandomArray);
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        Counting randArr = new Counting(array.RandomArray);
        randArr.Sort();
        end = System.nanoTime();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Random (Karışık) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);
      //  PrintArray(randArr.ResultArray);

    }

    private static void AllHeapSort(NewArray array) {
        
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();        
        start = System.nanoTime();
        
        Heap ascArr = new Heap(array.AscArray);
        ascArr.MinHeapSort();
        
        end = System.nanoTime();        
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        
        System.out.println("Asc (K->B) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);
        
        
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        Heap descArr = new Heap(array.DescArray);
        descArr.MinHeapSort();
        end = System.nanoTime();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Desc (B->K) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);

        
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        Heap randArr = new Heap(array.RandomArray);
        randArr.MinHeapSort();
        end = System.nanoTime();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Random (Karışık) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);
    }

    private static void PrintArray(int[] arr) {
        for (int i = 0; i < 100; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
