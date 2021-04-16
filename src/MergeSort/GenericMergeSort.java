package MergeSort;

class GenericMergeSort {
    public static void main(String[] args) {
        String[] strings = {"F", "K", "C", "A"};
        Integer[] ints = {0, 10 ,42, 55, 23, 430};

        mergeSort(ints);
        mergeSort(strings);
        for (Integer i : ints) {
            System.out.println(i);
        }

        for (String s: strings) {
            System.out.println(s);
        }
    }
    public static <E extends Comparable<E>> void mergeSort(E[] list) {
    if (list.length > 1) {

        E[] firstHalf = (E[]) new Comparable[list.length / 2];
        System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
        mergeSort(firstHalf);

        int secondHalfLength =  list.length - list.length / 2;
        E[] secondHalf = (E[]) new Comparable[secondHalfLength];
        System.arraycopy(list, list.length / 2, secondHalf, 0,secondHalfLength);
        mergeSort(secondHalf);


        merge(firstHalf, secondHalf, list);
    }
    }

    static <E extends Comparable<E>> void merge(E[] firstHalf, E[] secondHalf, E[] tempList) {
        int currentOne = 0;
        int currentTwo = 0;
        int currentThree = 0;

        while (currentOne < firstHalf.length && currentTwo < secondHalf.length) {
            if (firstHalf[currentOne].compareTo(secondHalf[currentTwo]) < 0) {
                tempList[currentThree++] = firstHalf[currentOne++];
            }
            else {
                tempList[currentThree++] = secondHalf[currentTwo++];
            }
        }

        while (currentOne < firstHalf.length) {
            tempList[currentThree++] = firstHalf[currentOne++];
        }

        while (currentTwo < secondHalf.length) {
            tempList[currentThree++] = secondHalf[currentTwo++];
        }
        
    }

}
