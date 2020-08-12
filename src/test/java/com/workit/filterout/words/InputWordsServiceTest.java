package com.workit.filterout.words;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputWordsServiceTest {

    private InputWordsService inputWordsService;

    @Before
    public void before(){
        URL url = this.getClass().getClassLoader().getResource("input.txt");
        if (url == null) throw new RuntimeException("Input file for test is not found");
        inputWordsService = new InputWordsService(url.getFile());
    }

    @Test
    public void getWordsFromInputFile() throws FileNotFoundException {
        List<String> expected = Arrays.asList("word1","word2","word3","word4","word5");
        List<String> actual = inputWordsService.getWordsFromInputFile();
        assertEquals(expected,actual);
    }
}