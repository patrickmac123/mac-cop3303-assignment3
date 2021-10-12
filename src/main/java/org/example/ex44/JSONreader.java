package org.example.ex44;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3
 *  Copyright 2021 Patrick Mac
 */

class Item
{
    public String search;
    public String name;
    public Double price;
    public Long quantity;

}
public class JSONreader
{
    public static void setItem(Item input) throws IOException, ParseException
    {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/java/org/example/ex44/exercise44_input.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray subject = (JSONArray) jsonObject.get("products");

                Iterator iterator = subject.iterator();
                while (iterator.hasNext()) {
                    JSONObject object = (JSONObject) iterator.next();
                    String name = (String) object.get("name");

                    if (input.search.equalsIgnoreCase(name))
                    {

                        input.name = (String) object.get("name");
                        input.price = (Double) object.get("price");
                        input.quantity = (Long) object.get("quantity");
                    }
                }
    }
    public static Item reader(Item input)
    {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/java/org/example/ex44/exercise44_input.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray subject = (JSONArray) jsonObject.get("products");
            Scanner scanner = new Scanner(System.in);
            int flag = 0;
            boolean status = true;
            while (status)
            {
                System.out.print("What is the product name? ");
                input.search = scanner.nextLine();
                Iterator iterator = subject.iterator();

                while (iterator.hasNext()) {
                    JSONObject object = (JSONObject) iterator.next();
                    String name = (String) object.get("name");

                    if (input.search.equalsIgnoreCase(name))
                    {
                        System.out.println("Name: " + object.get("name"));
                        System.out.println("Price: " + object.get("price"));
                        System.out.println("Quantity: " + object.get("quantity"));

                        setItem(input);

                        flag = 1;
                        status = false;
                    }

                }
                if (flag == 0) {
                    System.out.println("Sorry, that product was not found in our inventory");
                    status = true;
                }

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return input;
    }
    public static void main(String[] args)
    {
        Item obj = new Item();
        reader(obj);
    }
}
