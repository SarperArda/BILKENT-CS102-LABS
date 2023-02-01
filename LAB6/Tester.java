/**
 * This class checking lab questions.
 * This methods from other classes.
 * Sarper Arda Bakır
 * 28 April 2022
 */

import java.util.ArrayList;
import java.util.Random;

public class Tester{

    public static Comparable[] RandomArrayGenerator(int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            temp.add(i);
        }
        Comparable[] arr = new Comparable[n];
        int x = n;
        Random rnd = new Random();
        for(int i = 0; i < n; i++){
            int t = rnd.nextInt(x);
            arr[i] = temp.get(t);
            temp.remove(t);
            x--;
        }
        return arr;
    }
    public static boolean isSorted(Comparable[] arr){

        for(int i = 0; i < arr.length - 1; i++){
            if ((int) arr[i] > (int) arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static Comparable[] sort(Comparable[] arr) {
        if(isSorted(arr)){
            return arr;
        }
        mergeSort(arr);
        System.out.println("merge");
        return arr;
    }
    public static void mergeSort(Comparable[] a) {

        if (a.length <= 1) { return; }
        Comparable[] first = new Comparable[a.length / 2];
        Comparable[] second = new Comparable[a.length - first.length];

        for (int i = 0; i < first.length; i++)
        {
            first[i] = a[i];
        }
        for (int i = 0; i < second.length; i++)
        {
            second[i] = a[first.length + i];
        }
        mergeSort(first);
        mergeSort(second);
        merge(first, second, a);
    }

    public static void merge(Comparable[] first, Comparable[] second, Comparable[] a)
    {

        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while(iFirst < first.length && iSecond < second.length)
        {

            if(first[iFirst].compareTo(second[iSecond]) == -1){
                a[j] = first[iFirst];
                iFirst++;
            }
            else{
                a[j] = second[iSecond];
                iSecond++;

            }
            j++;
        }
        while (iFirst < first.length)

        {

            a[j] = first[iFirst];
            iFirst++; j++;
        }


        while (iSecond < second.length)

        {

            a[j] = second[iSecond];
            iSecond++; j++;

        }
    }

    public static Comparable[] sort1(Comparable[] arr) {
        Quicksort(arr,0,arr.length -1 );
        System.out.println("quick");
        return arr;
    }

    public static void Quicksort(Comparable[] a, int from, int to) {
        if (from >= to) { return; }
        int p = partition(a, from, to);
        Quicksort(a, from, p);
        Quicksort(a, p + 1, to);
    }

    private static int partition(Comparable[] a, int from, int to) {
        int pivot = (int) a[from];
        int i = from - 1;
        int j = to + 1;
        while (i < j)
        {
            i++;
            while ((int)a[i] < pivot)
            { i++; }
            j--; while ((int)a[j] > pivot) { j--; }
            if (i < j) {
                swap(a, i, j);
            }
        }
        return j;
    }

    public static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static Comparable[] DecreasingArrayGenerator(int n) {

        Comparable[] arr = new Comparable[n];
        int x = n;
        for(int i = 0; i < n; i++){
            arr[i] = x;
            x--;
        }
        return arr;
    }


    public static Comparable[] IncreasingArrayGenerator(int n) {

        Comparable[] arr = new Comparable[n];
        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }
        return arr;
    }


    public static void main(String[] args){
        Comparable[] arr = DecreasingArrayGenerator(20);
        for (int i =0; i < 20; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Comparable[] merge = sort1(arr);
        for (int i =0; i < 20; i++){
            System.out.print(merge[i] + " ");
        }
    }
}
