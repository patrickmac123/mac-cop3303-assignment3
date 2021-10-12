package org.example.ex41;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *  UCF COP3330 Fall 2021 Assignment 3
 *  Copyright 2021 Patrick Mac
 */

class sort
{
    public static List<String> nameSort(List names)
    {
        Collections.sort(names);
        return names;
    }
    public static void printNames(List names)
    {
        int size = names.size();
        try
        {
            FileWriter myWriter = new FileWriter("src/main/java/org/example/ex41/exercise41_output.txt");
            myWriter.write(String.format("Total of %d names\n----------------- \n",size));
            for(int n = 0; n < names.size(); n++)
            {
                myWriter.write((names.get(n) + "\n"));
            }
            myWriter.close();
            System.out.print("Printing successful");
        }
        catch (IOException e)
        {
            System.out.print("An error has occurred");
            return;
        }
        {

        }
    }
}

public class names
{

    public static void main( String[] args )
    {
        List<String> names = new ArrayList<>();
        try
        {
            names = Files.readAllLines(Paths.get("src/main/java/org/example/ex41/exercise41_input.txt"), StandardCharsets.US_ASCII);
        }
        catch (IOException e)
        {
            System.out.println("File was not found");
            return;
        }
        sort obj = new sort();
        obj.printNames(obj.nameSort(names));

    }
}
