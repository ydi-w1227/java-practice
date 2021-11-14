package com.utility;

import java.io.IOException;
import java.util.Scanner;
/**
 * This class is the main class for command utility tool
 * User input file path and word itself
 * the tool will return the occurrences of the word from the file.
 */
public class WordCounterCLIController {

    /**
     * 1. User input path
     * 2. User input word
     * 3. If word match key then that’s one occurrence and keep looking to next
     * 4. Return all occurence
     * 4. User can keep input word until press control+c to terminate the program
     * fs.scanFile("/Users/didi/IdeaProjects/command-utility-tool/hello.txt");
     */
    void execProcess() throws IOException {
        Scanner input = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        String filePath = inputHandler.inputFile(input);

        long startTime = System.nanoTime();
        FileScanner fs = new FileScanner();
        fs.scanFile(filePath);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Reading finished in " + duration + " milli sec");

        while(true) {
            String word = inputHandler.inputWord(input);
            System.out.println(fs.checkOccurrences(word));
        }
    }

    public static void main(String[] args) throws IOException {
        WordCounterCLIController wordCounter = new WordCounterCLIController();
        wordCounter.execProcess();
    }
}
