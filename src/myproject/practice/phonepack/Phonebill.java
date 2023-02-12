package myproject.practice.phonepack;

import java.util.Scanner;

interface Checkable {
    void checking_bill();
    int option();
}
abstract class Declare {
    int bill=1000;
    String user_input;
    protected static final String inpack="*975#";
    protected static final String phpack="*954#";
    protected static final String borrow="*125#";
    protected static final String check="*124#";
    private void input(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("how much money do u want to save:");
        bill=bill+scanner.nextInt();
    }
    protected void startoption(){
        String main_in="";
        Scanner scanner=new Scanner(System.in);
        System.out.println("If U want to buy Internet Package Enter *975#");
        System.out.println("If U want to buy PhoneCall Package Enter *954#");
        System.out.println("If u want to check your phone bill Enter *124#");
        System.out.println("If u want to borrow money Enter *125#");
        user_input=scanner.nextLine();
    }
    protected void callingObj(Checkable checkable){
        checkable.option();
        checkable.checking_bill();
    }
}
public class Phonebill extends Declare{
    Phonebill(){
        System.out.println("U already have 1000 Kyats .");
    }
    public static void main(String[] args) {
        Phonebill phonebill=new Phonebill();
        phonebill.startoption();
        boolean exit=true;
        while (exit){
            switch (phonebill.user_input){
                case inpack: phonebill.callingObj(new Internetpack());
                break;
                case phpack: phonebill.callingObj(new Phonecallpack());
                break;
                case check: phonebill.callingObj(new Borrow());
                break;
                case borrow:
                    System.out.println("This is your money now="+phonebill.bill);
                default:
                    System.out.println(" Ur input is wrong.");
                    exit=false;
            }

        }
    }
}