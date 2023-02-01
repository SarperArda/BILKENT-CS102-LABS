/**
 * This is abstract class about sorting.
 * Sarper Arda Bakır
 * 28 April 2022
 */

import java.util.ArrayList;
import java.util.Random;

public abstract class SortAnalyzer implements ArrayGenerator{
    private int numberOfComparisons;
    protected int k;

    public int getNumberOfComparisons() {
        return numberOfComparisons;
    }

    //Implementing interfaces methods
    @Override
    public int[] RandomArrayGenerator(int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            temp.add(i);
        }
        int[] arr = new int[n];
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

    @Override
    public int[] DecreasingArrayGenerator(int n) {

        int[] arr = new int[n];
        int x = n;
        for(int i = 0; i < n; i++){
            arr[i] = x;
            x--;
        }
        return arr;
    }

    @Override
    public int[] IncreasingArrayGenerator(int n) {

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }
        return arr;
    }

    protected int compare(Comparable o1, Comparable o2){
        numberOfComparisons++;
        if(o1.compareTo(o2) == 1){
            return (int) o1;
        }
        if(o1.compareTo(o2) == -1){
            return (int) o2;
        }

        else{
            return (int) o1;
        }
    }
    public boolean isSorted(Comparable[] arr){

        for(int i = 0; i < arr.length; i++){
            if ((int) arr[i] > (int) arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public abstract Comparable[] sort(Comparable[] arr);
}


