package ru.geekbrains.lamba;

import com.sun.org.apache.xpath.internal.operations.Operation;

import java.util.Scanner;

public class MainLamba
{
    public static void main(String[] args)
    {
        // write your code here
        Scanner sc = new Scanner(System.in);
        Operationable addition;
        addition = ((x, y) -> x + y);

        Operationable subtraction;
        subtraction = ((x, y) -> x - y);

        Operationable multiplication;
        multiplication = ((x, y) -> x * y);

        Operationable division;
        division = ((x, y) -> x / y);

        System.out.println("Калькулятор консольный.");
        while (true)
        {
            System.out.println("Ведите действие, например А * В");
            String string = sc.nextLine();
            String[] token = string.split(" ");
            if (token[1].equals("+")) {
                System.out.println(addition.calculate(Integer.parseInt(token[0]), Integer.parseInt(token[2])));
            } else if (token[1].equals("-")) {
                System.out.println(subtraction.calculate(Integer.parseInt(token[0]), Integer.parseInt(token[2])));
            } else if (token[1].equals("*")) {
                System.out.println(multiplication.calculate(Integer.parseInt(token[0]), Integer.parseInt(token[2])));
            } else if (token[1].equals("/")) {
                try {
                    System.out.println(division.calculate(Integer.parseInt(token[0]), Integer.parseInt(token[2])));
                }
                catch (Exception e)
                {
                    System.out.println("На ноль делить нельзя.");
                }
            }
            System.out.println("Продолжить?:  Y N");
            if(sc.nextLine().equalsIgnoreCase("N"))
            {
                break;
            }
        }
    }
}
