package myproject.practice;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    static int count=0;
    public static void main(String[] args) {
        Random random=new Random();
        int result= 1+random.nextInt( 100);
        System.out.println(result);
        while (true){

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter the number 1 to 100:");
            int input= scanner.nextInt();

            if (input>100){
                System.out.println("Ur input is invalid");
            }
            count++;
            if (input!=result){
                if (input>result){
                    System.out.println("Ur result is greater than the result");
                }else if (input<result){
                    System.out.println("U r result is less than the result");
                }
            }

            if (count==5) {
                result=1+random.nextInt(100);
                System.out.println("result is "+result+"\t"+count);
            }

            if (input==result){
                System.out.println("U r right!");

                if (count<=3){
                    System.out.println("U are genius");
                    System.out.println("U play this game "+count+"times");
                }  else if (count <=6) {
                    System.out.println("U are good");
                    System.out.println("U play this game "+count+"times");
                }else if (count<=9){
                    System.out.println("U are not bad");
                    System.out.println("U play this game "+count+"times");
                }else {
                    System.out.println("U are bad");
                    System.out.println("U play this game "+count+"times");
                }
                break;
            }


        }
    }
}
