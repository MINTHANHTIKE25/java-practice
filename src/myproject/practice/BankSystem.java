package myproject.practice;


import java.util.Scanner;
import java.lang.NullPointerException;

public class BankSystem {
    String[] username = new String[10];
    int[] userpassword = new int[10];
    String[] usernrc = new String[10];
    int[] userMoney = new int[10];
    int locate = 0;
    boolean con = true;

    int currentId = 0;

    BankSystem() {
        System.out.println("Welcome dear customer!!!!!!!!!!!!");

    }

    public int mainpage() {
        System.out.println("WELCOME FROM MAINPAGE!!!");
        Scanner mainIn = new Scanner(System.in);
        System.out.println("Press 1 to register!");
        System.out.println("Press 2 to Login!");
        System.out.println("Press 3 to exit!");
        int mainin = mainIn.nextInt();
        return mainin;
    }

    public void register() {
        System.out.println("WELCOME FROM REGISTER!!!!!");
        Scanner reIn = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = reIn.nextLine();
        System.out.println("Enter your password:");
        int Password = reIn.nextInt();
        reIn.nextLine();
        System.out.println("Enter your nrc:");
        String nrc = reIn.nextLine();

        username[locate] = name;
        userpassword[locate] = Password;
        usernrc[locate] = nrc;
        locate++;
        if (locate == 10) {
            System.out.println("out of memory!");
        }
    }

    public int Login() {
        boolean anotherControl = true;
        int ex = 1;
        System.out.println("WELCOME FROM LOGIN!!!!!!!!");
        Scanner IN = new Scanner(System.in);
        int tryAgain=0;
        while (anotherControl) {
            System.out.println("Enter your name:");
            String name = IN.nextLine();
            System.out.println("Enter your password");
            int password = IN.nextInt();
            IN.nextLine();
            int userAmount = 0;
            int Option1 = 0;
            for (int i = 0; i < locate; i++) {
                if (username[i].equals(name) && userpassword[i] == password) {
                    System.out.println("LOGIN SUCCESS!");
                    System.out.println("Enter the amount that u want to save:");
                    userAmount = IN.nextInt();
                    IN.nextLine();
                    userMoney[i] = userAmount;
                    currentId = i;
                    System.out.println("Welcome from another page!");
                    System.out.println("PRESS 1 TO TRANSFER:");
                    System.out.println("PRESS 2 TO WITHDRAW:");
                    System.out.println("PRESS 3 TO EXIT:");
                    Option1 = IN.nextInt();
                    IN.nextLine();
                    int j = Login(Option1);
                    if (j == 100) {
                        ex = j;
                        anotherControl=false;
                        break;

                    }
                } else {
                    continue;
                }
            }

            if ( ex!=100){
                if (tryAgain<2){
                    System.out.println("Try Again!");
                    tryAgain++;
                }else {
                    anotherControl=false;
                    break;
                }
            }
        }
        return ex;
    }

        public int Login ( int option){   //method overriding
            int i = 0;
            Scanner inName = new Scanner(System.in);
            while (con) {
                if (option == 1) {
                    System.out.println("Welcome from transfer!");
                    System.out.println("Enter the name of the person that u want to transfer:");
                    String receiverName = inName.nextLine();
                    System.out.println("How much money do u want to transfer:");
                    int transAmount = inName.nextInt();
                    inName.nextLine();
                    transfer(receiverName, transAmount);
                    Login();
                } else if (option == 2) {
                    withdraw();
                    break;
                } else if (option == 3) {
                    System.out.println("Exit!");
                    i = 100;
                    con = false;
                }
            }
            return i;
        }

        public void transfer (String receiveMan,int sendAmount){
            int transferMONEY = 0;

            int transferId ;
            for (int i = 0; i < locate; i++) {
                if (username[i].equals(receiveMan) && sendAmount <= userMoney[currentId]) {
                    transferId = i;

                    transferMONEY = transferprocess(currentId, sendAmount);//method overloading
                    System.out.println("TRANSATION SUCCESS!!");
                    System.out.println("Your money is :" + transferMONEY);
                    userMoney[transferId] = transferMONEY;
                    break;
                } else {
                    continue;
                }
            }
            for (String i : username) {
                if (!i.equals(receiveMan)) {
                    System.out.println("can't find your name in our database!");
                } else {
                    break;
                }
            }

        }
        public int transferprocess ( int id1, int id2){
            int money;
            money = userMoney[id1] - id2;
            return money;
        }


        public void withdraw() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How much money do u want to withdraw");
            int withdrawmoney = scanner.nextInt();
            scanner.nextLine();
            int control=0;
            while (control<3) {
                if (withdrawmoney <= userMoney[currentId]) {
                    userMoney[currentId] -= withdrawmoney;
                    System.out.println("This is your money now:" + userMoney[currentId]);
                    break;
                } else {
                    System.out.println("your withdraw money is greater than the money in your account!");
                    control++;
                    continue;
                }
            }
        }

        public static void main (String[]args){
            boolean con1 = true;
            BankSystem bankSystem = new BankSystem();
            while (con1) {

                int mainResult = bankSystem.mainpage();
                if (mainResult == 1) {
                    bankSystem.register();
                    continue;
                } else if (mainResult == 2) {
                    int exiting=  bankSystem.Login();
                    if (exiting == 100 | exiting == 19) {
                        System.out.println("bye bye");
                        con1 = false;
                    } else if (bankSystem.Login()==1 ) {
                        bankSystem.register();
                    }
                } else if (mainResult == 3) {
                    System.out.println("bye bye!");
                    con1 = false;
                }
            }
        }
    }
