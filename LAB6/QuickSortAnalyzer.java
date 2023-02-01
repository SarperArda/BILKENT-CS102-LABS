/**
 * This class is about quick sorting.
 * Codes from this class is taken from BigJavaLateObjects 2nd edition, pages from 653, 666 and 667 and is fixed by lab questions.
 * Sarper Arda Bakır
 * 28 April 2022
 */
public class QuickSortAnalyzer extends SortAnalyzer{
    @Override
    public Comparable[] sort(Comparable[] arr) {
        sort(arr,0,arr.length -1 );
        return arr;
    }

    /**
     *Codes from this method is taken from BigJavaLateObjects 2nd edition, pages from 666 and is fixed by lab questions.
     * @param a
     * @param from
     * @param to
     */
    public static void sort(Comparable[] a, int from, int to) {
        if (from >= to) { return; }
        int p = partition(a, from, to); sort(a, from, p);
        sort(a, p + 1, to);
    }

    /**
     * Codes from this method is taken from BigJavaLateObjects 2nd edition, pages from 667 and is fixed by lab questions.
     * @param a
     * @param from
     * @param to
     * @return
     */
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

    /**
     * Codes from this method is taken from BigJavaLateObjects 2nd edition, pages from 653 and is fixed by lab questions.
     * @param a
     * @param i
     * @param j
     */
    public static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
