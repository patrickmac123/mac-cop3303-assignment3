package org.example.ex43;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Website
{
    public String siteName;
    public String author;
    public String JS;
    public String CSS;
    public String root;
}
public class App {
    public static void createFile(String File)
    {
        new File(File).mkdirs();
        System.out.println("Created " + File);
    }
    public static void create(Website obj) throws IOException {
        obj.root = "src/main/java/org/example/ex43/website/" +  obj.siteName;
        createFile(obj.root);

        File f = new File("src/main/java/org/example/ex43/website/"+ obj.siteName+"/index.html");
        BufferedWriter buffer = new BufferedWriter(new FileWriter(f));
        buffer.write("<html><head><title>"+  obj.siteName+ "</title><meta name= "+ obj.author+"></head>");
        buffer.close();
        Desktop.getDesktop().browse(f.toURI());
        System.out.println("Created src/main/java/org/example/ex43/website/"+ obj.siteName+"/index.html");

        if ( obj.JS.equals("y") ||  obj.JS.equals("Y"))
        {
            obj.root = "src/main/java/org/example/ex43/website/"+ obj.siteName+"/js/";
            createFile( obj.root);
        }
        if (obj.CSS.equals("y") || obj.CSS.equals("Y"))
        {
            obj.root = "src/main/java/org/example/ex43/website/"+obj.siteName+"/css/";
            createFile(obj.root);
        }
    }
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        Website obj = new Website();
        System.out.print("Site name: ");
        obj.siteName = input.nextLine();
        System.out.print("Author: ");
        obj.author = input.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        obj.JS = input.nextLine();
        System.out.print("Do you want a folder for CSS? ");
        obj.CSS = input.nextLine();
        create(obj);

    }
}
