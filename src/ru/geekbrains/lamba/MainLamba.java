package ru.geekbrains.lamba;

import com.sun.org.apache.xpath.internal.operations.Operation;

public class MainLamba
{
    public static void main(String[] args)
    {
        // write your code here
        Operationable addition;
        addition = ((x, y) -> x + y);

        Operationable subtraction;
        subtraction = ((x, y) -> x - y);

        Operationable multiplication;
        multiplication = ((x, y) -> x * y);

        Operationable division;
        division = ((x, y) -> x / y);

        System.out.println(addition.calculate(10, 20));
        System.out.println(subtraction.calculate(30, 10));
        System.out.println(multiplication.calculate(10, 20));
        System.out.println(division.calculate(300, 20));
    }
}
