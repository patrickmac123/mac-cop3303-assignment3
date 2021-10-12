package org.example.ex46;

import java.io.*;

/*
 *  UCF COP3330 Fall 2021 Assignment 3
 *  Copyright 2021 Patrick Mac
 */

class WordCount
{
    public String high = null;
    public String middle = null;
    public String low = null;
    int b = 0;
    int m = 0;
    int s = 0;
    String badger = "badger";
    String mushroom = "mushroom";
    String snake = "snake";
}

public class App
{

    public static WordCount count() throws IOException {
        File f1 = new File("src/main/java/org/example/ex46/exercise46_input.txt");
        String[] words = null;
        FileReader fr = new FileReader(f1);
        BufferedReader buffer = new BufferedReader(fr);

        String string;



        WordCount obj = new WordCount();

        while((string = buffer.readLine())!=null)
        {
            words = string.split(" ");
            for(String word:words)
            {
                if(word.equals(obj.badger))
                {
                    obj.b++;
                }
                else if(word.equals(obj.mushroom))
                {
                    obj.m++;
                }
                else if(word.equals(obj.snake))
                {
                    obj.s++;
                }
            }

        }
        fr.close();
        return obj;
    }
    public static void main(String[] args) throws IOException
    {

        WordCount obj = new WordCount();
        obj = count();
        checkVal(obj,obj.badger,obj.mushroom,obj.snake,obj.b,obj.m,obj.s);


        System.out.print("\n"+obj.high+": ");
        print(obj.b);
        System.out.print("\n"+obj.middle+": ");
        print(obj.m);
        System.out.print("\n"+obj.low+": ");
        print(obj.s);

    }

    static void checkVal(WordCount obj, String badger, String mushroom, String snake, int b, int m, int s)
    {


        if(b > m && b > s)
        {
            obj.high = badger;
            if(m > s)
            {
                obj.middle = mushroom;
                obj.low = snake;
            }
            else if(s > m)
            {
                obj.middle = snake;
                obj.low = mushroom;
            }
        }
        else if(m > b && m > s)
        {
            obj.high = mushroom;
            if(b > s)
            {
                obj.middle = badger;
                obj.low = snake;
            }
            else if(s > b)
            {
                obj.middle = snake;
                obj.low = badger;
            }
        }
        else if(s > b && s > m)
        {
            obj.high = snake;
            if(m > b)
            {
                obj.middle = mushroom;
                obj.low = badger;
            }
            else if(b > m)
            {
                obj.middle = badger;
                obj.low = mushroom;
            }
        }
    }

    public static void print(int n)
    {
        for(int i = 0; i < n;i++)
        {
            System.out.print("*");
        }
    }
}
