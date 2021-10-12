package org.example.ex42;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/*
 *  UCF COP3330 Fall 2021 Assignment 3
 *  Copyright 2021 Patrick Mac
 */

class Person
{
    public String lastName;
    public String firstName;
    public int salary;
}

public class App
{
public static void storage(Person[] records, List<String> input)
{
    String currentLine;
    for (int index = 0; index < records.length; index++)
    {
        records[index] = new Person();
        currentLine = input.get(index);
        records[index].lastName = currentLine.substring(0, currentLine.indexOf(","));
        currentLine = currentLine.substring(currentLine.indexOf(",") + 1);
        records[index].firstName = currentLine.substring(0, currentLine.indexOf(","));
        currentLine = currentLine.substring(currentLine.indexOf(",") + 1);
        records[index].salary = Integer.parseInt(currentLine);
    }
}
    public static void main(String[] args)
    {
        List<String> input;
        try
        {
            input = Files.readAllLines(Paths.get("src/main/java/org/example/ex42/exercise42_input.txt"), StandardCharsets.US_ASCII);
        }
        catch (Exception e)
        {
            System.out.println("File not found.");
            return;
        }

        Person[] records = new Person[input.size()];
        storage(records,input);



        System.out.println(String.format("%-8s %-8s %-8s\n--------------------------", "Last", "First", "Salary"));
        for (int index=0;index<records.length;index++)
        {
            System.out.println(String.format("%-8s %-8s %-8s", records[index].lastName, records[index].firstName, records[index].salary));
        }
    }
}

