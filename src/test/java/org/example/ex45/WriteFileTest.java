package org.example.ex45;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class Input
{
    String output;
}
class WriteFileTest {

    @Test
    void getcount() throws IOException {
        String input = "src/main/java/org/example/ex45/exercise45_input.txt";
        ReadFile readfile = new ReadFile();
        readfile.read();
        ArrayList<String> list = readfile.getdata();
        Input name = new Input();
        name.output = "exercise45_input";
        WriteFile obj = new WriteFile(name.output, input,list);
        obj.replace();
        assertEquals(3,obj.getCount());
    }
}