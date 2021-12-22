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
public class _Grup_13_Counting {

    int Array[];
    int CounterArray[];
    int ResultArray[];

    public _Grup_13_Counting(int[] array) {
        int[] arr = new int[array.length];
        
        for(int i = 0; i < array.length; i++){
            arr[i] = array[i];
        }
        this.Array = arr;
    }

    private int FindBiggestElement() {
        int biggest = 0;

        for (int i = 0; i < Array.length; i++) {
            if (Array[i] > biggest) {
                biggest = Array[i];
            }
        }
        return biggest;
    }

    private void BuildCounterArray() {
        int size = FindBiggestElement();
        int[] arr = new int[size + 1];
        for (int i = 0; i < size + 1; i++) {
            arr[i] = 0;
        }
        CounterArray = arr;
    }

    private void FillCounterArray() {
        for (int i = 0; i < Array.length; i++) {
            int index = Array[i];
            CounterArray[index]++;
        }

        for (int i = 1; i < CounterArray.length; i++) {
            CounterArray[i] += CounterArray[i - 1];
        }
    }

    private void BuildSortedArray() {
        int size = Array.length;
        int []arr = new int[size];        
        int index, element;
        
        for (int i = 0; i < size; i++) {
            element = Array[i];
            index = CounterArray[element] -1;
            arr[size-index-1] = element;
            CounterArray[element]--;
        }
        
        ResultArray = arr;
    }
    public void PrintCounterArray() {
        for (int i = 0; i < CounterArray.length; i++) {
            System.out.println(i + ": " + CounterArray[i]);
        }
    }

    public void PrintResultArray() {
        for (int i = 0; i < ResultArray.length; i++) {
            System.out.print(ResultArray[i] + " ");
        }
    }
    
    public void Sort() {
        BuildCounterArray();
        FillCounterArray();
        BuildSortedArray();
    }

    
}
