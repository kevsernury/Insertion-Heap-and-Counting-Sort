/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Random;

public class _Grup_13_NewArray {

    int RandomArray[];
    int AscArray[];
    int DescArray[];
    int Size;

    public _Grup_13_NewArray(int size) {
        Size = size;
        int[] arr = new int[size];
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(1000000);
        }

        BuildAscArray(arr);
        BulitRandomArray(arr);
        BuildDescArray(arr);
    }

    private void BuildAscArray(int[] arr) {
        int[] ascArray = new int[Size];
        
        for (int i = 0; i < Size; i++) {
            ascArray[i] = arr[i];
        }
        
        _Grup_13_Heap ascArr = new _Grup_13_Heap(ascArray);
        ascArr.MaxHeapSort();
        AscArray = ascArr.Array;
    }

    private void BuildDescArray(int[] arr) {
        int[] descArray = new int[Size];
        
        for (int i = 0; i < Size; i++) {
            descArray[i] = arr[i];
        }
        
        _Grup_13_Heap descArr = new _Grup_13_Heap(descArray);
        descArr.MinHeapSort();
        DescArray = descArr.Array;
    }

    private void BulitRandomArray(int[] arr) {
        int[] array = new int[Size];
        
        for (int i = 0; i < Size; i++) {
            array[i] = arr[i];
        }
        RandomArray = array;
    }
}
