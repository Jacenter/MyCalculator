package scientific_calculator;

public class Calculator {
    public static void main(String[] args) {
        Console.println("Welcome to my Calculator");
        String s = Console.getStringInput("Enter a string");
        Integer i = Console.getIntegerInput("Enter an Integer");
        Double d = Console.getDoubleInput("Enter a double.");

        Console.println("The user input %s as a string", s);
        Console.println("The user input %s as a string", i);
        Console.println("The user input %s as a d", d);
    }
}
