/**
 *
 *  Program: Intro to Java
 *
 */

import java.util.*;
import java.util.Scanner.*;

public class bubbleSort {


        public bubbleSort() {System.out.println("Hello, this is the Constructor!");}

        //Overload the Constructor
        public bubbleSort(String FName, String LName){
        System.out.println("First Name: " + FName + "  Last Name: " + LName);
        }
        public bubbleSort(int Age){

            System.out.println("Age: " + Age);

        }

        //This is a bubble sort
        void bubbleSort(int[] arr2){
            int n = arr2.length;
            for(int i = 0; i < n-1; i++){
                for(int j = 0; j < n - i - 1 ; j++){
                    if(arr2[j] > arr2[j+1]){
                        int temp = arr2[j];
                        arr2[j] = arr2[j+1];
                        arr2[j+1] = temp;
                    }//end of condition
                }//end of second loop
            }//end of first loop
        }//end of Bubble Sort

        //This is the print statement
        void printArray(int[] arr2){
            int n = arr2.length;
            for(int i = 0; i < n; i++){

                    System.out.print(arr2[i] + " ");
                    System.out.print(" ");

            }
        }

    public static void main(String [] args){
            /*
            //Constructor here call it.
            Intro i = new Intro("Edward", "Moon");
            Intro i1 = new Intro(23);
            //This is an array...nothing special about it
        int[] arr1 = {123, 32, 44, 90};
        for(int i2 = 0; i2 < arr1.length; i2++){
            System.out.print(arr1[i2] + " ");
        }

        //Try Sorting the Array Using a Bubble Sort
        */


            //Scanner in = new Scanner(System.in);
            bubbleSort ob = new bubbleSort();
            int arr[] = {64, 23, 12, 22, 30, 90};
            ob.bubbleSort(arr);
            System.out.print("Bubble Sorted Array: ");
            ob.printArray(arr);




        }//end of main

    }


