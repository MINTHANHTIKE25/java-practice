package myproject.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Declare {
    protected int num, num2;
    protected double dnum, dnum2;
    int result;
    double dresult;

    protected abstract void input();

    protected abstract void showing();

    protected abstract int exitting();

}

class ChangingPrime extends Declare {

    @Override
    protected void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number check prime or not but u can't input the floating numbers: ");
        while (true) {
            try {
                num = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("U can only enter the integer number.");
                scanner.nextLine();
                continue;
            }
        }
    }

    @Override
    protected void showing() {
        if (to_prime() == true) {
            System.out.println(num + " is the prime numbers. ");
        } else {
            System.out.println(num + " is not the prime number. ");
        }
    }

    @Override
    protected int exitting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If u want to exit from this page enter 1!");
        System.out.println("If u want to completely exit enter 2");
        System.out.println("If u don't want to exit enter 0");
        int go = scanner.nextInt();
        return go;
    }


    private boolean to_prime() {
        boolean ans = false;
        int i = 2;
        while (i <= num) {
            if (num / i == 1) {
                ans = true;
                break;
            } else if (num % i == 0 & num / i != 1) {
                ans = false;
                break;
            }
            i++;
        }
        return ans;
    }
}

class FindingFabonacci extends Declare {
    @Override
    protected void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your numbers :");
        num = scanner.nextInt();
    }

    @Override
    protected void showing() {
        result = to_fabonacci();
        System.out.println(result + " is your fabonacci numbers. ");
    }

    @Override
    protected int exitting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If u want to exit from this page enter 1!");
        System.out.println("If u want to completely exit enter 2");
        System.out.println("If u don't want to exit enter 0");
        int go = scanner.nextInt();
        return go;
    }


    private int to_fabonacci() {
        int[] toFabo = new int[num + 1];
        for (int i = 0; i < toFabo.length; i++) {
            if (i < 2) {
                toFabo[i] = i;
            } else if (i == 2 ^ i > 2) {
                toFabo[i] = toFabo[i - 1] + toFabo[i - 2];
            }
        }
        return toFabo[toFabo.length - 1];
    }

}

class Calculating extends Declare {

    @Override
    protected void showing() {
        calculating2();

    }

    @Override
    protected int exitting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If u want to exit from this page enter 1!");
        System.out.println("If u want to completely exit enter 2");
        System.out.println("If u don't want to exit enter 0");
        int go = scanner.nextInt();
        return go;
    }

    @Override
    protected void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first number :");
        String firstIn = scanner.nextLine();
        System.out.println("Enter your second number :");
        String secondIn = scanner.nextLine();
        changing_type(firstIn, secondIn);
    }

    private void calculating2() {
        Scanner scanner = new Scanner(System.in);
        Operation obj = new Operation();
        System.out.println("Enter the operator:");
        String operator = scanner.nextLine();
        if (operator.equals("+")) {
            if (num == 0 & num2 == 0) {
                obj.add(dnum, dnum2);
            } else if (dnum == 0 & dnum2 == 0) {
                obj.add(num, num2);
            }
        }
        if (operator.equals("-")) {
            if (num == 0 & num2 == 0) {
                obj.sub(dnum, dnum2);
            } else if (dnum2 == 0 & dnum == 0) {
                obj.sub(num, num2);
            }
        }
        if (operator.equals("*")) {
            if (num == 0 & num2 == 0) {
                obj.multiply(dnum, dnum2);
            } else if (dnum2 == 0 & dnum == 0) {
                obj.multiply(num, num2);
            }
        }
        if (operator.equals("/")) {
            if (num == 0 & num2 == 0) {
                obj.divide(dnum, dnum2);
            } else if (dnum2 == 0 & dnum == 0) {
                obj.divide(num, num2);
            }
        }
        if (operator.equals("%")) {
            if (num == 0 & num2 == 0) {
                obj.remainder(dnum, dnum2);
            } else if (dnum2 == 0 & dnum == 0) {
                obj.remainder(num, num2);
            }
        }
    }

    private void changing_type(String userInput, String userInput2) {
        if ((userInput.contains(".") & userInput2.contains(".")) ^ (userInput.contains(".") ^ userInput2.contains("."))) {
            dnum = Double.parseDouble(userInput);
            dnum2 = Double.parseDouble(userInput2);
        } else {
            num = Integer.parseInt(userInput);
            num2 = Integer.parseInt(userInput2);

        }
    }
}

class Operation extends Calculating {
    protected void add(int no1, int no2) {
        result = no1 + no2;
        System.out.println("This is your result=" + result);
    }

    protected void add(double no1, double no2) {
        dresult = no1 + no2;
        System.out.println("This is your result =" + dresult);
    }

    protected void sub(int no1, int no2) {
        result = no1 + no2;
        System.out.println("This is your result =" + result);
    }

    protected void sub(double no1, double no2) {
        dresult = no1 + no2;
        System.out.println("This is your result =" + dresult);
    }

    protected void multiply(int no1, int no2) {
        result = no1 * no2;
        System.out.println("This is your result =" + result);
    }

    protected void multiply(double no1, double no2) {
        dresult = no1 * no2;
        System.out.println("This is your result =" + dresult);
    }

    protected void divide(int no1, int no2) {
        result = no1 / no2;
        System.out.println("This is your result =" + result);
    }

    protected void divide(double no1, double no2) {
        dresult = no1 / no2;
        System.out.println("This is your result =" + dresult);
    }

    protected void remainder(int a, int b) {
        result = a % b;
        System.out.println("This is your result =" + result);
    }

    protected void remainder(double a, double b) {
        dresult = a % b;
        System.out.println("This is your result =" + dresult);
    }
}

public class Calculator {
    private int calling(Declare declare) {
        int left;
//        Scanner scanner=new Scanner(System.in);
        declare.input();
        declare.showing();
//        System.out.println("If u want to exit enter 1");
        left = declare.exitting();
//        scanner.nextInt();
        return left;
    }

    public static void main(String[] args) {
        boolean complete = true;
        while (complete) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("If u want to check ur number to prime number enter 1 !");
            System.out.println("If u want to change your number to fabonacci number enter 2 !");
            System.out.println("If u want to calculate your numbers enter 3 !");
            System.out.println("If u want to exit enter 4");
            int mainin = scanner.nextInt();
            Calculator calculator = new Calculator();
            boolean exit = true;
            while (exit) {
                if (mainin == 1) {
                    System.out.println("Welcome from checking Prime !");
                    switch (calculator.calling(new ChangingPrime())) {
                        case 1:
                            exit = false;
                            break;
                        case 2:
                            exit = false;
                            complete = false;
                            break;
                    }
                } else if (mainin == 2) {
                    System.out.println("Welcome from finding the Fibonacci numbers !");
                    switch (calculator.calling(new FindingFabonacci())) {
                        case 1:
                            exit = false;
                            break;
                        case 2:
                            exit = false;
                            complete = false;
                            break;
                    }
                } else if (mainin == 3) {
                    System.out.println("Welcome from Calculation !");
                    switch (calculator.calling(new Calculating())) {
                        case 1:
                            exit = false;
                            break;
                        case 2:
                            exit = false;
                            complete = false;
                            break;
                    }
                } else if (mainin == 4) {
                    System.out.println("bye bye");
                    exit = false;
                    complete = false;
                }
            }
        }
    }
}
