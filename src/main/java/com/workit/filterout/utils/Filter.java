package com.workit.filterout.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Filter {
    public static List<String> getFilteredList(List<String> input, Set<String> exclude){
        List<String> filtered = new ArrayList<String>(input);
        filtered.removeAll(exclude);
        return filtered;
    }
}