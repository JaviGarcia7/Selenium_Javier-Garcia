package class3_Methods;
//Escribir un método que reciba un número y retorne su doble

import java.util.Scanner;

public class Exercise1 {

    public static void main(String args[]){

        int num = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        num = input.nextInt();

        int duplicate = calculateDouble(num);
        System.out.println("The double of "+num+" is: "+duplicate);
    }

    public static int calculateDouble (int doble){
        return doble * 2;
    }
}
