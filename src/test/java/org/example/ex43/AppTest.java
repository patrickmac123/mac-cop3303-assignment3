package org.example.ex43;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void createFile()
    {

    }

    @Test
    void main()
    {

        String siteName = "awesomeco";
        String author = "Max Power";
        String JS = "y";
        String CSS = "y";
        String path = "";

        Path main = Paths.get("src/main/java/org/example/ex43");
        assertEquals( true, Files.exists(main));

        Path site = Paths.get("src/main/java/org/example/ex43/website/"+ siteName + "/index.html");
        assertEquals( true, Files.exists(site));

        Path cssFolder = Paths.get("src/main/java/org/example/ex43/website/"+siteName+"/css");
        assertEquals( true, Files.exists(cssFolder));

        Path jsFolder = Paths.get("src/main/java/org/example/ex43/website/"+siteName+"/js");
        assertEquals( true, Files.exists(jsFolder));


    }
}