package com.workit.filterout.utils;

import org.apache.commons.cli.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArgsParser {
    private static final String INPUT_KEY = "input";
    private static final String OUTPUT_KEY = "output";

    private List<String> args;
    private String input;
    private String output;
    private List<String> remainingArgs;

    public ArgsParser(){

    }

    public ArgsParser(List<String> args) {
        this.args = args;
        this.configureOptions();
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public List<String> getRemainingArgs() {
        return remainingArgs;
    }

    public void setRemainingArgs(List<String> remainingArgs) {
        this.remainingArgs = remainingArgs;
    }

    private void configureOptions() {
        Options options = new Options();
        Option inputOption = new Option("i", INPUT_KEY, true, "Filename of the input file");
        inputOption.setRequired(true);
        options.addOption(inputOption);
        Option outputOption = new Option("o", OUTPUT_KEY, true, "Filename of the output file");
        outputOption.setRequired(false);
        options.addOption(outputOption);
        CommandLineParser parser = new DefaultParser();
        HelpFormatter helpFormatter = new HelpFormatter();
        try {
            CommandLine commandLine = parser.parse(options, (String[]) args.toArray());
            setInput(commandLine.getOptionValue(INPUT_KEY));
            setOutput(commandLine.getOptionValue(OUTPUT_KEY));
            setRemainingArgs(commandLine.getArgList());
        }catch (ParseException e){
            helpFormatter.printHelp("... <options> [excludeWord1 [excludeWord2 ...]]\r\nOptions:\r\n",options);
            System.exit(1);
        }
    }

}
