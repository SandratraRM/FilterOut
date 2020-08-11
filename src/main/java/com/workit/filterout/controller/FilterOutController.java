package com.workit.filterout.controller;
import com.workit.filterout.words.FilterWordsService;
import com.workit.filterout.words.InputWordsService;
import com.workit.filterout.words.OutputWordsService;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;

@Component
public class FilterOutController {
    private InputWordsService inputWordsService;
    private FilterWordsService filterWordsService;
    private OutputWordsService outputWordsService;

    public FilterOutController(InputWordsService inputWordsService, FilterWordsService filterWordsService, OutputWordsService outputWordsService) {
        this.inputWordsService = inputWordsService;
        this.filterWordsService = filterWordsService;
        this.outputWordsService = outputWordsService;
    }

    public void filterInputAndSave() throws IOException {
        List<String> inputWords = inputWordsService.getWordsFromInputFile();
        List<String> retainedWords = filterWordsService.removeWordsToExclude(inputWords);
        outputWordsService.saveWordsInOutputFile(retainedWords);
    }
}
