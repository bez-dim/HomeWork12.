package com.company;

/**
 * Created by user on 15.12.2016.
 */
public class AList {
    private int initialSize;
    private int size=0;
    private float maxLoad=0.8f;
    private float minLoad=0.6f;
    private int[]array;
    private static final int MIN_SIZE=10;
    public AList(){
        this.initialSize=10;
        this.array=new int[initialSize];
    }
    public AList(int initialSize){
        this.initialSize=initialSize;
        this.array=new int[initialSize];

    }
    public int size(){
        return size;
    }
    public void add(int n) {
        float currentLoad = size / (initialSize*1.0f);
        if (currentLoad >= maxLoad) {

        initialSize = (int) (size * 1.5);
        int[] tmp = new int[initialSize];
        for (int i = 0; i < size; i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }
        array[size++] = n;
    }
    public int get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        return array[index];
    }

    public int getArrayLength() {
        return array.length;
    }


    public void addFirstElement(int n) {
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = n;
        size++;

    }

    public void removeFirstElement() {
        for (int i = 0; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;

    }

    public void add(int n, int index) {
        if (index > size) {
            System.out.println("Невозможно  добавить элемент в индекс " + index + " т.к в массиве " + size + " элементов");
        }
        if (index < size) {
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = n;
            size++;
        } else {
            add(n);
        }
    }

    public void remove(int index) {
        if (index >= size) {
            System.out.println("Невозможно  добавить элемент в индекс " + index + " т.к в массиве " + size + " элементов");
            return;
        }
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public int indexOf(int n) {
        for (int i = 0; i < size; i++) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }


    public String convertArrayToString(String separator) {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            str.append(array[i] + separator);
        }
        str.delete(str.length() - 1, str.length());
        return str.toString();
    }

    public void sortAscendingByIncertions() {
        int tmp;
        for (int i = 0; i < size - 1; i++) {
            if (array[i] > array[i + 1]) {
                for (int j = i; j >= 0; j--) {
                    if (array[j + 1] > array[j]) break;
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }
    //Сортировка по возрастанию
    public void sortAscending(){
        int tmp;
        for (int i = 0; i <size-1 ; i++) {
            for (int j = 0; j <size-1-i ; j++) {
                if (array[j]>array[j+1]){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }
/*сортировка по возрастанию и убыванию используя
алгоритм сортировки вставками (Insertion)  */

    public void insertsSortingAlgorithm() {
        int tmp;
        for (int i = 0; i < size - 1; i++) {
            if (array[i] < array[i + 1]) {
                for (int j = i; j >= 0; j--) {
                    if (array[j + 1] < array[j]) break;
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }


}
