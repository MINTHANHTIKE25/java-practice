package myproject.practice;

import java.util.Scanner;

public class LargestNoArray {
    static  int count=0;
    public static void main(String[] args) {

        int [] numbers=new int[10];
        Scanner scanner=new Scanner(System.in);
            for (int i=0;i< numbers.length;i++){
                count++;
            System.out.print("Enter your numbers:");
            int innum= scanner.nextInt();
            numbers[i]=innum;

                System.out.print(count);
                System.out.println();
            }


        int last=numbers.length;
        int first=0;
        int temp=0;

        for (int i=0;i<last;i++){
            for (int j=i+1;j<last;j++){
                if (numbers[i]>numbers[j]){
                    temp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;
                }
            }

        }
        System.out.println(numbers[last-1]);
    }
}

/*while (middle>first){
        if (numbers[middle]>numbers[middle-1]){
        temp=middle;
        break;
        }else {
        continue;
        }
        }*/