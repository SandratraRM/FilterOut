package com.workit.filterout.words;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class InputWordsService {
    private String inputFileName;

    public InputWordsService(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public List<String> getWordsFromInputFile() throws FileNotFoundException {
        if (isBlank(inputFileName)) throw new IllegalArgumentException("Blank input filename, use --input=<filename> to specify the input file");
        File file = new File(inputFileName);
        if (!file.exists() || !file.isFile()) throw new FileNotFoundException("Input file doesn't exist or is a directory");
        Scanner scanner = new Scanner(file);
        ArrayList<String> inputWords = new ArrayList<>();
        while (scanner.hasNextLine()){
            inputWords.add(scanner.nextLine());
        }
        scanner.close();
        return inputWords;
    }
}
