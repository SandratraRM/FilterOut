package com.workit.filterout.utils;


import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArgsParserTest {
    private final static String[] ARGS = {"--input","input.txt","--output","output.txt","word1","word2","word3"};

    private ArgsParser argsParser;

    @Before
    public void before(){
        argsParser = new ArgsParser(Arrays.asList(ARGS));
    }

    @Test
    public void getInput() {
        assertEquals("input.txt",argsParser.getInput());
    }

    @Test
    public void getOutput() {
        assertEquals("output.txt",argsParser.getOutput());
    }

    @Test
    public void getRemainingArgs() {
        List<String> expected = Arrays.asList("word1","word2","word3");
        List<String> actual = argsParser.getRemainingArgs();
        assertEquals(expected,actual);
    }
}