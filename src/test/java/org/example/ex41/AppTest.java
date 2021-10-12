package org.example.ex41;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void nameSort()
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
        assertEquals("Ling, Mai", names.get(0));
        assertEquals("Johnson, Jim", names.get(1));
        assertEquals("Zarnecki, Sabrina", names.get(2));
        assertEquals("Jones, Chris", names.get(3));
        assertEquals("Jones, Aaron", names.get(4));
        assertEquals("Swift, Geoffrey", names.get(5));
        assertEquals("Xiong, Fong", names.get(6));
    }
}