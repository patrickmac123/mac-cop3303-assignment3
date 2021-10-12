package org.example.ex44;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JSONreaderTest {

    @Test
    void reader() throws IOException, ParseException {

        JSONreader obj = new JSONreader();

        Item input = new Item();
        input.search = "Widget";

        obj.setItem(input);
        assertEquals("Widget",input.name);
        assertEquals(25.00,input.price);
        assertEquals(5,input.quantity);



    }
}