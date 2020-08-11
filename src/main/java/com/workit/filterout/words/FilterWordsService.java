package com.workit.filterout.words;

import com.workit.filterout.utils.Filter;

import java.util.List;
import java.util.Set;

public class FilterWordsService {
    private Set<String> wordsToExclude;

    public FilterWordsService(Set<String> wordsToExclude) {
        this.wordsToExclude = wordsToExclude;
    }

    public List<String> removeWordsToExclude(List<String> inputWords){
        return Filter.getFilteredList(inputWords,wordsToExclude);
    }
}
