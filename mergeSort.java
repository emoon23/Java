/**
 *
 * =======================================================
 * This part of the Java program is to test out the
 * divide and conquer algoritm known as a merge sort.
 * Main functionality is to divide input array in two
 * halves, calls itself for the two halves and then merges
 * the two sorted halves. merge() function is used for merging
 * two halves.
 * =======================================================
 *
 */
import java.util.*;
import java.util.Scanner.*;

public class mergeSort {

    void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create Temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /* Copying data to temp arrays */
        for(int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for(int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        //Initial indexes of first and second subarrays
        int i = 0, j = 0;

        //Initial index of merged subarry array
        int k = l;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copying remaining elements of L[] if any */
        while( i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }//end of L[]

        /* Copying remaining elements of R[] if any */
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }//end of R[]
    }//end of merge sort function

    //Main function that sorts arr[l..r] using
    //merge()
    void sort(int arr[], int l, int r){
        if(l < r)
        {
            //Find the middle point
            int m = (l + r )/2;

            //Sort first and second halves
            sort(arr,l,m);
            sort(arr, m + 1, r );

            //Merge the sorted halves
            merge(arr,l,m,r);
        }//end of if statement
    }//end of sort function

    /* A utility function to print array of size n */
    static void printArray(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n; ++i)
            System.out.println(arr[i] + " ");
        System.out.println();
    }

    //Driver method
    public static void main(String args[]){
        int arr[] = {12, 11, 13, 4, 90, 44};

        System.out.println("Given Array");
        printArray(arr);

        mergeSort ob = new mergeSort();
        ob.sort(arr,0, arr.length-1);

        System.out.println("\nSorted Array");
        printArray(arr);
    }//end of driver method

}//end of mergeSort Class
