package org.example.ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3
 *  Copyright 2021 Patrick Mac
 */

class ReadFile
{
    private ArrayList<String> list;
    private Scanner scan;

    public ReadFile() throws FileNotFoundException {
        list = new ArrayList<String>();
        File file = new File("src/main/java/org/example/ex45/exercise45_input.txt");
        scan = new Scanner(file);
    }
    public void read()
    {
        try
        {
            int i = 0;
            while(scan.hasNext())
            {
                String fileData = scan.nextLine();
                list.add(fileData);
            }
        }
        finally
        {
            scan.close();
        }
    }

    public ArrayList<String> getdata()
    {
        return list;
    }
}

class Input
{
    String output;
}

class WriteFile {
    private FileWriter writer;
    private int count;
    private ArrayList<String> list;
    public WriteFile(String output, String name, ArrayList<String> list) throws IOException
    {

        String root = "src/main/java/org/example/ex45/";
        writer = new FileWriter(root+output);
        this.list = list;
    }

    public WriteFile() {

    }

    public void replace() throws IOException {
        for(int i =0;i<list.size();i++)
        {
            String temp = list.get(i);
            String str = "utilize";
            int index = 0;
            while(true)
            {
                index = temp.indexOf(str,index);
                if(index != -1)
                {
                    count++;
                    index+=str.length();
                }
                else
                {
                    break;
                }
            }
            temp = temp.replaceAll("utilize","use");
            writer.write(temp+"\n");
        }

        writer.close();
    }
 public int getCount()
 {
        return count;
 }

}

public class App
{
    public static void main(String[] args) throws IOException {


        String input = "src/main/java/org/example/ex45/exercise45_input.txt";

        ReadFile readfile = new ReadFile();
        readfile.read();

        ArrayList<String> list = readfile.getdata();

        Scanner scanner = new Scanner(System.in);
        Input data = new Input();
        System.out.print("Enter the output file name: ");
        data.output = scanner.nextLine();

        WriteFile write = new WriteFile(data.output,input, list);

        write.replace();
        System.out.println("The number of Modifications are: "+write.getCount());
    }


}
