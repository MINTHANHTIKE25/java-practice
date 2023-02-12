package myproject.practice;

import java.util.Scanner;

public class SchoolarMain {
    static int location=0;
    static String [] username=new String[100];
    static String [] adminname={"min than htike","Aung myo lwin"
    };

    public static void input() {
        Scanner scanner=new Scanner(System.in);
        boolean exit=true;
        int putting=0;
        while (exit) {
            System.out.println("If u want to exit enter 1");
            System.out.println("Enter your name:");
            String user = scanner.nextLine();

            if (!user.contains("1")){
                for (String s : adminname) {
                    if (user.equals(s)) {
                        System.out.println("Welcome from admin");
                    } else {
                        continue;
                    }
                }
                for (int i=0;i< username.length;i++){
                    username[i]=user;
                }
            }else {
                exit=false;
            }
        }
    }
}

