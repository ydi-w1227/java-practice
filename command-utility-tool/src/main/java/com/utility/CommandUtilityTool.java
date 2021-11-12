package com.utility;

import java.util.Scanner;
/**
 * This class is the main class for command utility tool
 * User input file path and word itself
 * the tool will return the occurrences of the word from the file.
 */
public class CommandUtilityTool {

    /**
     * 1. User input path
     * 2. User input word
     * 3. If word match key then that’s one occurrence and keep looking to next
     * 4. Return all occurence
     * fs.scanFile("/Users/didi/IdeaProjects/command-utility-tool/hello.txt");
     */
    public void execProcess() {
        Scanner input = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        String filePath = inputHandler.inputFile(input);
        FileScanner fs = new FileScanner();
        fs.scanFile(filePath);
        String word = inputHandler.inputWord(input);
        System.out.println(fs.checkOccurrences(word));
    }

    public static void main(String[] args) {
        CommandUtilityTool cut = new CommandUtilityTool();
        cut.execProcess();
    }
}
