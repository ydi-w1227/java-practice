package com.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class handles user input and retry 3 times if input is invalid.
 * If input is valid, then check if the input path and file name is valid
 * If input bye, then exit the process
 */
public class InputHandler {

    /**
     * This function handles user input and retry 3 times if input is invalid.
     * @return valid path
     */
    public String inputFile(Scanner input) throws IOException {
        System.out.print("Enter Directory name: ");
        String dirName = input.nextLine();
        validateDirPath(dirName);

        System.out.print("Enter file name: ");
        String fileName = input.nextLine();
        validateFilePath(dirName, fileName);

        String filePath = filePath(dirName, fileName);
        System.out.println(filePath);
        return filePath;
    }

    /**
     * Input and validate word
     * @param input word
     * @return word
     */
    public String inputWord(Scanner input) {
        System.out.print("Enter word: ");
        String word = input.nextLine().toLowerCase();
        word = word.replaceAll("[^a-z]$", "");
        boolean wordValidated = validateWord(word);
        while (!wordValidated) {
            System.out.print("Invalid word, please input again: ");
            System.out.print("Enter word: ");
            String newWord = input.nextLine();
            boolean newValidated = validateWord(newWord);
            if (newValidated == true) {
                word = newWord;
                break;
            }
        }
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
     */
    private void validateFilePath(String dirPath, String fileName) throws IOException {
        String filePath = filePath(dirPath, fileName);
        File file = new File(filePath);
        if (!file.exists() ||  !file.isFile()) {
            throw new IOException("File does not exist");
        }
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
