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
public class _Grup_13_Heap {

    int Array[];
    int HeapSize;

    public _Grup_13_Heap(int[] array) {
        int[] arr = new int[array.length];
        
        for(int i = 0; i < array.length; i++){
            arr[i] = array[i];
        }
        this.Array = arr;
        HeapSize = array.length;
    }

    private int Left(int i) {
        return 2 * i + 1;
    }

    private int Right(int i) {
        return 2 * i + 2;
    }

    private void MinHeapify(int i) {
        int smallest = i;
        int left = Left(i);
        int right = Right(i);

        if (left < HeapSize && Array[left] < Array[smallest]) {
            smallest = left;
        }

        if (right < HeapSize && Array[right] < Array[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = Array[i];
            Array[i] = Array[smallest];
            Array[smallest] = temp;

            MinHeapify(smallest);
        }
    }

    private void BuiltMinHeap() {
        for (int i = HeapSize / 2 - 1; i >= 0; i--) {
            MinHeapify(i);
        }
    }

    public void MinHeapSort() {
        HeapSize = Array.length;
        BuiltMinHeap();

        for (int i = HeapSize - 1; i >= 0; i--) {

            int temp = Array[0];
            Array[0] = Array[i];
            Array[i] = temp;
            HeapSize = i;
            MinHeapify(0);
        }
    }
    
    private void MaxHeapify(int i) {
        int largest = i;
        int left = Left(i);
        int right = Right(i);

        if (left < HeapSize && Array[left] > Array[largest]) {
            largest = left;
        }

        if (right < HeapSize && Array[right] > Array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = Array[i];
            Array[i] = Array[largest];
            Array[largest] = temp;

            MaxHeapify(largest);
        }
    }

    private void BuiltMaxHeap() {
        for (int i = HeapSize / 2 - 1; i >= 0; i--) {
            MaxHeapify(i);
        }
    }

    public void MaxHeapSort() {
        HeapSize = Array.length;
        BuiltMaxHeap();

        for (int i = HeapSize - 1; i >= 0; i--) {

            int temp = Array[0];
            Array[0] = Array[i];
            Array[i] = temp;
            HeapSize = i;
            MaxHeapify(0);
        }      
        
    }
    

    public void PrintArray() {

        for (int i = 0; i < Array.length; ++i) {
            System.out.print(Array[i] + " ");
        }
        System.out.println();
    }
    
  
}
