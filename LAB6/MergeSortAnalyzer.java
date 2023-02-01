/**
 * This class is about merge sorting.
 * Codes from this class is taken from BigJavaLateObjects 2nd edition, pages from 662 to 663 and is fixed by lab questions.
 * Sarper Arda Bakır
 * 28 April 2022
 */
public class MergeSortAnalyzer extends SortAnalyzer{

    @Override
    public Comparable[] sort(Comparable[] arr) {
        if(isSorted(arr)){
            return arr;
        }
        System.out.println("In");
        mergeSort(arr);
        return arr;
    }

    /**
     * Codes from this method is taken from BigJavaLateObjects 2nd edition, pages from 662 and is fixed by lab questions.
     * @param a
     */
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

    /**
     * Codes from this method is taken from BigJavaLateObjects 2nd edition, pages from 662 to 663 and is fixed by lab questions.
     * @param first
     * @param second
     * @param a
     */
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
}

