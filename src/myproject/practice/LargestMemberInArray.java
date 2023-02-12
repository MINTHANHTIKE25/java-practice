package myproject.practice;

import java.util.Scanner;

public class LargestMemberInArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr=new int[5];
        for (int i=0;i<arr.length;i++){
            System.out.println("Enter the data: ");
            int input=scanner.nextInt();
            arr[i]=input;
        }
        int temp=0;
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                   temp=arr[i];
                   arr[i]=arr[j];
                   arr[j]=temp;
                }
            }
        }
        System.out.println(arr[arr.length-1]);
        for (int var: arr) {
            System.out.println(var);
        }

    }
}
