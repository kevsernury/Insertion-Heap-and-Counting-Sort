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

        _Grup_13_NewArray array_100 = new _Grup_13_NewArray(100);
        _Grup_13_NewArray array_bin = new _Grup_13_NewArray(1000);
        _Grup_13_NewArray array_50bin = new _Grup_13_NewArray(50000);
        _Grup_13_NewArray array_500bin = new _Grup_13_NewArray(500000);
        _Grup_13_NewArray array_2bucukmilyon = new _Grup_13_NewArray(2500000);
        
        System.out.println("Verilen 100 elemanlı dizi:");
        for (int i = 0; i < 100; i++) {
            System.out.print(array_100.AscArray[i] + " ");
        }
        
        System.out.println("\nInsertion Sort:");        
        _Grup_13_InsertionSort Arr1 = new _Grup_13_InsertionSort(array_100.AscArray);
        Arr1.insertionSort();
        for (int i = 0; i < 100; i++) {
            System.out.print(Arr1.Array[i] +" ");
        }
        
        System.out.println("\nCounting Sort:");  
        _Grup_13_Counting Arr2 = new _Grup_13_Counting(array_100.AscArray);
        Arr2.Sort();
        for (int i = 0; i < 100; i++) {
            System.out.print(Arr2.ResultArray[i] + " ");
        }
        
        System.out.println("\nHeap Sort:");  
        _Grup_13_Heap ascArr = new _Grup_13_Heap(array_100.AscArray);
        ascArr.MinHeapSort();
        for (int i = 0; i < 100; i++) {
            System.out.print(ascArr.Array[i] + " ");
        }
        
        System.out.println("-------100--------");
        Work(array_100);
        System.out.println("");
        System.out.println("-------1.000--------");
        Work(array_bin);
        System.out.println("");
        System.out.println("-------50.000--------");
        Work(array_50bin);
        System.out.println("");
        System.out.println("-------500.000--------");
        Work(array_500bin);
        System.out.println("");
        System.out.println("-------10.000.000--------");
        Work(array_2bucukmilyon);

    }

    private static void Work(_Grup_13_NewArray array) {

        System.out.println("---Insertion Sort---");
        AllInsertionSort(array);

        System.out.println("---Heap Sort---");
        AllHeapSort(array);

        System.out.println("---Counting Sort---");
        AllCountingSort(array);
    }

  

    private static void AllInsertionSort(_Grup_13_NewArray array) {
        beforeUsedMem = beforeUsedMem = Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        _Grup_13_InsertionSort ascArr = new _Grup_13_InsertionSort(array.AscArray);
        ascArr.insertionSort();
        end = System.nanoTime();
        afterUsedMem = beforeUsedMem = Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;

        System.out.println("Asc (K->B) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);

        beforeUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        _Grup_13_InsertionSort descArr = new _Grup_13_InsertionSort(array.DescArray);
        descArr.insertionSort();
        end = System.nanoTime();
        afterUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Desc (B->K) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);

        beforeUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        _Grup_13_InsertionSort randArr = new _Grup_13_InsertionSort(array.RandomArray);
        randArr.insertionSort();
        end = System.nanoTime();
        afterUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Random (Karışık) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);
    }

    private static void AllCountingSort(_Grup_13_NewArray array) {

        beforeUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        _Grup_13_Counting ascArr = new _Grup_13_Counting(array.AscArray);
        ascArr.Sort();
        end = System.nanoTime();
        afterUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Asc (K->B) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);

        beforeUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        _Grup_13_Counting descArr = new _Grup_13_Counting(array.DescArray);
        descArr.Sort();
        end = System.nanoTime();
        afterUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Desc (B->K) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);

        beforeUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        _Grup_13_Counting randArr = new _Grup_13_Counting(array.RandomArray);
        randArr.Sort();
        end = System.nanoTime();
        afterUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Random (Karışık) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);

    }

    private static void AllHeapSort(_Grup_13_NewArray array) {

        beforeUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        _Grup_13_Heap ascArr = new _Grup_13_Heap(array.AscArray);
        ascArr.MinHeapSort();
        end = System.nanoTime();
        afterUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;

        System.out.println("Asc (K->B) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);

        beforeUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        _Grup_13_Heap descArr = new _Grup_13_Heap(array.DescArray);
        descArr.MinHeapSort();
        end = System.nanoTime();
        afterUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Desc (B->K) time: " + (end - start) / 1000000);
        System.out.println("Space: " + actualMemUsed);

        beforeUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
        start = System.nanoTime();
        _Grup_13_Heap randArr = new _Grup_13_Heap(array.RandomArray);
        randArr.MinHeapSort();
        end = System.nanoTime();
        afterUsedMem =Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
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
