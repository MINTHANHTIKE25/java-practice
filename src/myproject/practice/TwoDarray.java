package myproject.practice;

import java.util.Scanner;

public class TwoDarray {
    String [][] name=new String[2][2];
    String [] name1=new String[5];
    public void indata(){
        Scanner scanner=new Scanner(System.in);
        int check=0;
        for (int i = 0; i < name.length; i++) {
            for (int i1 = 0; i1 < name.length; i1++) {
                System.out.println("Enter your name:");
                String name2=scanner.nextLine();
                name[i][i1]=name2;
                if (i == 0 & i1 < name.length) {
                    name1[i1]=name[i][i1];
                    check=i1;
                } else if (i ==1 & i1< name.length) {
                    check++;
                    name1[check]=name[i][i1];
                }

            }
        }

    }

    public void showdata(){
        for (String var: name1) {
            System.out.println(var);
        }
    }


    public static void main(String[] args) {
        TwoDarray twoDarray=new TwoDarray();
        twoDarray.indata();
        twoDarray.showdata();
    }
}
