package org.example.ex46;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class WordCount
{
    public String high = null;
    public String middle = null;
    public String low = null;
    int b = 7;
    int m = 2;
    int s = 1;
    String badger = "badger";
    String mushroom = "mushroom";
    String snake = "snake";
}
class AppTest {

    @Test
    void checkVal()
    {
        App app = new App();
        String badger = "badger";
        String mushroom = "mushroom";
        String snake = "snake";
        WordCount words = new WordCount();

        assertEquals(7,words.b);
        assertEquals(2,words.m);
        assertEquals(1,words.s);
    }
}