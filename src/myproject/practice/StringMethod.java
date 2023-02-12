package myproject.practice;

import java.util.Scanner;

public class StringMethod {
    public static void main(String[] args) {
        System.out.print("Enter the string :");
        Scanner name = new Scanner(System.in);
        String inName = name.nextLine();
        System.out.print("Enter the character that u want to find inndex:");
        Scanner num = new Scanner(System.in);
        String inNum = num.nextLine();
        char ch1[] = inNum.toCharArray();
        char ch[] = inName.toCharArray();

        int t=0;
        int k=0;

        while(t<inNum.length()){
        for (int i = 0; i < inName.length(); i++) {
            if (ch1[t] == ch[i]) {
                    System.out.println("your index="+i);

                } else {
                    continue;
                }
            }t++;
        }
    }

}

