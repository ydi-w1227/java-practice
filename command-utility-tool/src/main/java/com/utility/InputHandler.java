package com.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class handles user input
 * if input path and file name are invalid, throw corresponding exceptions
 * If input path and file name are valid, then input word
 * If the word is not valid, then keep let user input
 * If word is valid, do the later process
 * Press Control c to stop the process
 */
public class InputHandler {

    /**
     * This function handles user input
     * throw exception if input is invalid.
     * otherwise, returnn valid path
     * @param input
     * @return valid path
     * @throws IOException
     */
    public String inputFile(Scanner input) throws IOException {
        System.out.print("Enter Directory name: ");
        String dirName = input.nextLine();
        validateDirPath(dirName);

        System.out.print("Enter file name: ");
        String fileName = input.nextLine();
        validateFilePath(dirName, fileName);

        String filePath = filePath(dirName, fileName);
        return filePath;
    }

    /**
     * Input and validate word
     * @param input
     * @return
     */
    public String inputWord(Scanner input) {
        System.out.print("Enter word: ");
        String word = input.nextLine();
        while (!validateWord(wordProcessed(word))) {
            System.out.print("Invalid word, please input again: ");
            System.out.print("Enter word: ");
            String newWord = input.nextLine();
            if (validateWord(wordProcessed(newWord))) {
                word = newWord;
                break;
            }
        }
        return word;
    }

    /**
     * make input word lower case and replace special characters
     * @param inputWord
     * @return
     */
    private String wordProcessed(String inputWord) {
        String word = inputWord.toLowerCase();
        word = word.replaceAll("[^a-z]$", "");
        return word;
    }

    /**
     * Validate directory path
     * @param dirPath
     * @return
     */
    private boolean validateDirPath(String dirPath) {
        File tmpDir = new File(dirPath);
        if (!tmpDir.exists() || !tmpDir.isDirectory()){
            throw new InvalidPathException(dirPath, " Invalid path");
        }
        return true;
    }

    /**
     * Validate file path
     * @param dirPath
     * @param fileName
     * @return
     * @throws IOException
     */
    private boolean validateFilePath(String dirPath, String fileName) throws IOException {
        String filePath = filePath(dirPath, fileName);
        File file = new File(filePath);
        if (!file.exists() ||  !file.isFile()) {
            throw new IOException("File does not exist");
        }
        return true;
    }

    /**
     * Valid if input word is not empty
     * @param word
     * @return
     */
    private boolean validateWord(String word) {
        if(word == null || word.trim().isEmpty() || word.contains("[^a-z]")) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param dirPath
     * @param fileName
     * @return absolute file path
     */
    private String filePath(String dirPath, String fileName) {
        Path filePath = Paths.get(dirPath.toString(), "", fileName);
        String path = String.valueOf(filePath);
        return path;
    }
}
