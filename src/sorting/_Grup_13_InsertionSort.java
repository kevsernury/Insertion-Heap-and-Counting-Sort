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
public class _Grup_13_InsertionSort {

    int Size;
    int Array[];
    
    public _Grup_13_InsertionSort(int[] array){
        Array = array;
        Size = array.length;
    }
    
    public void insertionSort() {
        int len = Size, tmp, j;
        for (int i = 1; i < len; i++) {
            tmp = Array[i];
            for (j = i; j > 0; j--) {
                if (Array[j - 1] < tmp) {
                    Array[j] = Array[j - 1];
                } else {
                    break;
                }
            }
            Array[j] = tmp;
        }
    }

}
