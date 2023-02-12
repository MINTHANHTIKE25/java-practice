package myproject.practice;

import sun.nio.cs.ext.ISO2022_CN_CNS;

import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println("Enter the number that u want to transfer fabonacci");
        Scanner scanner =new Scanner(System.in);
        int input = scanner.nextInt();
        int []num2 = new int[input+1];
        int[]num1={0,1};
        for (int i=0;i< num2.length;i++){
            if (i<2){
                num2[i]=i;
            }else if (i==2 ^ i>2){
                num2[i]=num2[i-1]+num2[i-2];
            }
        }
        System.out.println(num2[num2.length-1]);
    }
}
