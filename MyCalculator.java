package scientific_calculator;


import java.util.*;

public class MyCalculator {
    public static void main(String[] args) {
        double num1 = 0.0;
        double num2 = 0.0;
        char operator;
        double answer = 0.0;


        Scanner scanObject = new Scanner(System.in);

        System.out.println("What operation?");
        operator = scanObject.next().charAt(0);

        if (operator == '^') {
            System.out.println("Please enter the number to square: ");
            num1 = scanObject.nextInt();
        }
        else if (operator == '√') {
            System.out.println("Please enter the number to square root");
            num1 = scanObject.nextDouble();
        }
        else if (operator == 'x') {
            System.out.println("Please enter first number");
            num1 = scanObject.nextDouble();
            System.out.println("Please enter the exponent");
            num2 = scanObject.nextDouble();
        }
        else if (operator == '3'){
            System.out.println("Please enter the number to be cubed");
            num1 = scanObject.nextDouble();
        }
        else {
            System.out.println("Please enter first number: ");
            num1 = scanObject.nextDouble();
            System.out.println("Please enter second number: ");
            num2 = scanObject.nextDouble();
        }


        switch (operator) {
            case '+':
                answer = num1 + num2;
                System.out.println(num1 + " " + operator + " " + num2 + " = " + answer);
                break;
            case '-':
                answer = num1 - num2;
                System.out.println(num1 + " " + operator + " " + num2 + " = " + answer);
                break;
            case '*':
                answer = num1 * num2;
                System.out.println(num1 + " " + operator + " " + num2 + " = " + answer);
                break;
            case '/':
                answer = num1 / num2;
                System.out.println(num1 + " " + operator + " " + num2 + " = " + answer);
                break;
            case '^':
                answer = (Math.pow(num1, 2));
                System.out.println(num1 + "²" + " = " + answer);
                break;
            case '√':
                answer = (Math.sqrt(num1));
                System.out.println(num1 + " " + "√" + " = " + answer);
                break;
            case '%':
                answer = num1 % num2;
                System.out.println(num1 + " " + operator + " " + num2 + " = " + answer);
                break;
            case 'x':
                answer = (Math.pow(num1, num2));
                System.out.println(num1 + " " + "to the power of" + " " + num2 + " = " + answer);
                break;
            case '3':
               answer = (Math.pow(num1, 3));
               System.out.println(num1 + " cubed " + " = " + answer);
               break;
        }
    }
}

