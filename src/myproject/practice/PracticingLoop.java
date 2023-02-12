package myproject.practice;

public class PracticingLoop {
    public static void main(String[] args) {
        for (int i=1;i<6;i++){
            for (int j=6;j>i;j--){
                System.out.print(i);
            }
            System.out.println();
            for (int k=i;k<(i)*2;k++) {
                System.out.print(" ");
            }
        }
    }
}

class AnotherLoop{
    public static void main(String[] args) {
        for (int i=1;i<6;i++){
            for (int j=1;j<(i-1)+2;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}