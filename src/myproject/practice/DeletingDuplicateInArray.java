package myproject.practice;

import java.util.Arrays;
import java.util.Scanner;

public class DeletingDuplicateInArray {
    public static void main(String[] args) {
        int [] arr= new int[5];
        Scanner scanner=new Scanner(System.in);
        for (int i=0;i< arr.length;i++){
            System.out.print("Enter your data: ");
            int numbers=scanner.nextInt();
            arr[i]=numbers;
        }
        int temp=0;
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j< arr.length;j++){
                if (arr[i]==arr[j]){
                    temp=arr[i];
                    arr[i]=arr[arr.length-1];
                    arr[arr.length-1]=temp;
                    temp=arr[j];
                    arr[j]=arr[arr.length-2];
                    arr[arr.length-2]=temp;
                }
            }
        }
        int []result= Arrays.copyOf(arr,arr.length-2);
        for (int var : result) {
            System.out.println(var);
        }
    }
}
