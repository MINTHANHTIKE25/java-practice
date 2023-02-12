package myproject.practice.phonepack;

import java.util.Scanner;

public class Internetpack extends Declare implements Checkable {
    Internetpack(){
        System.out.println("Enter number of the package'option that u want to buy ");
    }
    protected int user_input;
    @Override
    public void checking_bill() {
        int check=user_input;
        switch (check){
            case 1:
                if (bill >=1000){
                    bill-=1000;
                    System.out.println("The money u left is "+bill);
                    break;
                }else {
                    System.out.println("U don't have enough bill.");
                    break;
                }
            case 2:
                if (bill <2000){
                System.out.println("U don't have enough bill.");
                break;
                }else {
                    bill-=2000;
                    System.out.println("The money u left is "+bill);
                }
                break;
            case 3:
                if (bill<3000){
                System.out.println("U don't have enough bill.");
                break;
                }else {
                    bill -=3000;
                    System.out.println("The money u left is "+bill);
                }
                break;
            case 4:
                if (bill <19000){
                System.out.println("U don't have enough bill. ");
                break;
                }else {
                    bill -= 19000;
                    System.out.println("The money u left is "+bill);
                }break;
            case 5:
                if (bill <26000){
                System.out.println("U don't have enough bill. ");
                break;
                }else {
                    bill-=26000;
                System.out.println("The money u left is "+bill);
                }
        }
    }
    public int option(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("1: 1GB = 1000Kyats");
        System.out.println("2: 2GB = 2000Kyats");
        System.out.println("3: 3GB = 3000Kyats");
        System.out.println("4: 10GB = 19000Kyats");
        System.out.println("5: 15GB = 26000Kyats");
        user_input=scanner.nextInt();
        return user_input;
    }
}
class Borrow extends Declare implements Checkable{
    protected int user_input;
    @Override
    public void checking_bill() {
        switch (user_input){
            case 1 :
           if (bill<200) {
               bill += 800;
               System.out.println("Your borrowing process is successful.");
               break;
           }else {
               System.out.println("Ur bill must be lower than 200 kyats."+bill);
               break;
           }
            case 2:{
                if (bill<200){
                    bill += 3000;
                    System.out.println("Your borrowing process is successful.");
                }else {
                    System.out.println("Ur bill must be lower than 200 kyats."+bill);
                }
            }
        }
    }

    @Override
    public int option() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("If u want to borrow 800 Kyats enter 1");
        System.out.println("If u want to borrow 3000Kyats enter 2(Premium member only)");
        user_input=scanner.nextInt();
        return user_input;
    }
}
