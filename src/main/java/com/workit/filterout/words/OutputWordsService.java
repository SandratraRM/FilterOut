package com.workit.filterout.words;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class OutputWordsService {

    private String outputFileName;

    public OutputWordsService(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public void saveWordsInOutputFile(List<String> words) throws IOException {
        if(isBlank(outputFileName)) throw new IllegalArgumentException("Output filename is not defined. Specify default in application.properties as [ defaultoutput ] or set it with the option --output=<filename>");
        String toSave = StringUtils.joinWith("\r\n",words.toArray());
        Path path = Paths.get(outputFileName);
        if(!path.isAbsolute())
            path = Paths.get(System.getProperty("user.dir"),outputFileName);
        Files.write(path,toSave.getBytes());
        System.out.println("Written file in " + path.toString());
    }
}
