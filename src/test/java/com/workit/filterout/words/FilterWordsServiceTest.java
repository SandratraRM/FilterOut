package com.workit.filterout.words;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class FilterWordsServiceTest {

    private FilterWordsService filterWordsService;

    @Before
    public void before(){
        List<String> excluded = Arrays.asList("word3","word4");
        filterWordsService = new FilterWordsService(new HashSet<>(excluded));
    }

    @Test
    public void removeWordsToExclude() {
        List<String> input = Arrays.asList("word1","word2","word3","word4");
        List<String> remaining = filterWordsService.removeWordsToExclude(input);
        List<String> expectedRemaining = Arrays.asList("word1","word2");
        assertEquals(expectedRemaining,remaining);
    }
}