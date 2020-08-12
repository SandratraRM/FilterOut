# FilterOut

## Introduction

The program parse words line per line from an `input` file, which is specified by passing the option `-i inputFilename` or `--input inputFilename`.
Then, it filters out all words from the input that match the input arguments (Those that are not options).
At last, it saves the remaining words line per line in a new file with default filename `output.txt` but we can specify with the option `-o outputFilename` or `--out outputFilename`.

## Launching and usage

- You can use an IDE to specify args and launch the program easily.
- You can run the test `com.workit.filterout.FilterOutApplicationTest`.
- You can build the jar with Maven with `mvn clean package`.

```
usage: java -jar filterout.jar <options> [excludeWord1 [excludeWord2 ...]]
Options:
 -i,--input <arg>    Filename of the input file
 -o,--output <arg>   Filename of the output file
```
## Dependencies

- Spring framework core
- Apache StringUtils
- Apache commons cli
- JUnit4