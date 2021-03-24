/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.tecnm.itcm.utils;

/**
 *
 * @author Henry McElwaine
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int minLimit, int maxLimit, int value) {
        if (maxLimit >= 0 && array[minLimit] <= value && array[maxLimit] >= value) {
            int mid = getMidValue(minLimit, maxLimit);
            System.out.printf("Límite inferior %d límite superior %d valor en el arreglo %d valor a buscar %d%n", minLimit, maxLimit, array[mid], value);
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                return binarySearch(array, mid + 1, maxLimit, value);
            }
            return binarySearch(array, minLimit, mid - 1, value);
        }
        return -1;
    }

    public static int getMidValue(int minLimit, int maxLimit) {
        return (maxLimit + minLimit) / 2;
    }

    public static int search(int[] arr, int dato) {
        int inicio = 0;
        int fin = arr.length - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio + fin) / 2;
            if (arr[pos] == dato) {
                return pos;
            } else if (arr[pos] < dato) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int value = 400;
        System.out.println("Se quiere buscar: " + value);
        int[] arr = {10, 15, 20, 40, 50, 100, 120, 200, 400, 500, 600, 800, 2222};
        int result = binarySearch(arr, 0, arr.length - 1, value);
        System.out.printf("Result %d%n", result);
    }
}
