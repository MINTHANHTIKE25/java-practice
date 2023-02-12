package myproject.practice;
import java.util.Scanner;
public class PrimeNumber {
    public static void prime(int num){

        int i=2;
        boolean result=true;

            while (i <= num) {
                if (num / i == 1) {
                    result = true;
                    break;
                } else if (num % i == 0) {
                    result = false;
                    break;
                }
                i++;

        }
        if (result){
            System.out.println(" Your number is prime number. ");
        }else {
            System.out.println("Your number is not prime number.");
        }
    }

    public static void main(String[] args) {
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("If u want to exit enter 00");

        while (exit) {
            System.out.print("Enter the number:");
            int input = scanner.nextInt();
            if (input == 00) {
                exit = false;
            } else {
                prime(input);
                continue;
            }
        }
    }
}
