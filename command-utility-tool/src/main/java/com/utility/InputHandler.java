package com.utility;

import java.io.File;
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
    public String inputFile(Scanner input) {
        System.out.print("Enter Directory name: ");
        String dirName = input.nextLine();
        checkExit(dirName);
        boolean dirPathValidated = validateDirPath(dirName);
        int inputCounter = 3;
        while(!dirPathValidated) {
            System.out.print("Invalid file Path, please input again: ");
            System.out.print("Enter Directory name: ");
            String newDirName = input.nextLine();
            checkExit(newDirName);
            boolean newDirPathValidated = validateDirPath(newDirName);
            if (newDirPathValidated == true) {
                dirName = newDirName;
                break;
            }
            inputCounter--;
            if(inputCounter == 0) {
                throw new RuntimeException("Exceed retry times: invalid dir name");
            }
        }

        System.out.print("Enter file name: ");
        String fileName = input.nextLine();
        checkExit(fileName);
        boolean filePathValidated = validateFilePath(dirName, fileName);
        int fileInputCounter = 3;
        while (!filePathValidated) {
            System.out.print("Invalid file Path, please input again: ");
            System.out.print("Enter file name: ");
            String newFileName = input.nextLine();
            checkExit(newFileName);
            boolean newFilePathValidated = validateFilePath(dirName, newFileName);
            if (newFilePathValidated == true) {
                fileName = newFileName;
                break;
            }
            fileInputCounter--;
            if(fileInputCounter == 0) {
                throw new RuntimeException("Exceed retry times: invalid file name");
            }
        }
        return dirName + "/" + fileName;
    }

    /**
     * Input and validate word
     * @param input word
     * @return word
     */
    public String inputWord(Scanner input) {
        System.out.print("Enter word: ");
        String word = input.nextLine();
        checkExit(word);
        boolean wordValidated = validateWord(word);
        int wordCounter = 3;
        while (!wordValidated) {
            System.out.print("Invalid word, please input again: ");
            System.out.print("Enter word: ");
            String newWord = input.nextLine();
            checkExit(newWord);
            boolean newValidated = validateWord(newWord);
            if (newValidated == true) {
                word = newWord;
                break;
            }
            wordCounter--;
            if(wordCounter == 0) {
                throw new RuntimeException("Exceed retry times: invalid word");
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
            return false;
        }
        return true;
    }

    /**
     * Validate file path
     * @param dirPath
     * @param fileName
     * @return
     */
    private boolean validateFilePath(String dirPath, String fileName) {
        String fp = dirPath + "/" + fileName;
        File file = new File(fp);
        if (!file.exists() ||  !file.isFile()) {
            return false;
        }
        return true;
    }

    /**
     * Valid if input word is not empty
     * @param word
     * @return
     */
    private boolean validateWord(String word) {
        if(word == null || word.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Terminate the process
     * @param check
     */
    private void checkExit(String check) {
        if (check.equals("bye")) {
            System.out.println("Bye..");
            System.exit(0);
        }
    }
}
