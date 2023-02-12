package myproject.practice;

import java.util.Arrays;
import java.util.Scanner;

public class DeletingArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("how much data do u want to input:");
        int arrSize=scanner.nextInt();
        int [] num=new int[arrSize];
        for (int i=0;i<arrSize;i++){
            System.out.print("Enter the data into arrays");
            int values=scanner.nextInt();
            num[i]=values;
        }
        System.out.print("Enter the data that u want to delete");
        int invalue=scanner.nextInt();
        for (int i=0;i<arrSize;i++){
            if (num[i]==invalue){
                int temp=0;
                temp=num[arrSize-1];
                num[arrSize-1]=num[i];
                num[i]=temp;
            }
        }

        int j=0;
        int []num2 =Arrays.copyOf(num, arrSize-1);
        for (int var: num2) {
            System.out.println(var);
        }
    }
}
