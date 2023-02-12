package myproject.practice.phonepack;

import java.util.Scanner;

public class Phonecallpack extends Declare implements Checkable {
    @Override
    public void checking_bill() {
        int check = option();
        switch (check) {
            case 1:
                if (bill < 1000) {
                    System.out.println("U don't have enough bill.");
                    break;
                } else {
                    bill -= 1000;
                    System.out.println(bill);
                }
                break;
            case 2:
                if (bill < 2000) {
                    System.out.println("U don't have enough bill.");
                    break;
                } else {
                    bill -= 2000;
                    System.out.println(bill);
                }
                break;
            case 3:
                if (bill < 3000) {
                    System.out.println("U don't have enough bill.");
                    break;
                } else {
                    bill -= 3000;
                    System.out.println(bill);
                }
                break;
            case 4:
                if (bill < 19000) {
                    System.out.println("U don't have enough bill. ");
                    break;
                } else {
                    bill -= 19000;
                    System.out.println(bill);
                }
                break;
            case 5:
                if (bill < 26000) {
                    System.out.println("U don't have enough bill. ");
                    break;
                } else {
                    bill -= 26000;
                    System.out.println(bill);
                }
        }

    }

    @Override
    public int option() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : 20min  = 1000Kyats");
        System.out.println("2 : 40min  = 2000Kyats");
        System.out.println("3 : 60min  = 3000Kyats");
        System.out.println("4 : 160min = 10000Kyats");
        System.out.println("5 : 240min = 22000Kyats");
        return scanner.nextInt();
    }
}
