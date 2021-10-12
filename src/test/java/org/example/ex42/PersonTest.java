package org.example.ex42;

import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest
{
    @Test
    void storage()
    {
        App app = new App();
        List<String> input = null;
        try
        {
            input = Files.readAllLines(Paths.get("src/main/java/org/example/ex42/exercise42_input.txt"), StandardCharsets.US_ASCII);

        } catch (IOException e)
        {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        assertEquals("Ling,Mai,55900",input.get(0));

        Person[] records = new Person[input.size()];
        app.storage(records,input);

        assertEquals("Ling",records[0].lastName);
        assertEquals("Mai",records[0].firstName);
        assertEquals(55900,records[0].salary);
    }

}