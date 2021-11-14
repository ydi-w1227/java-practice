package com.utility;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class scans the input file and stores word-occurrence pairs
 */
public class FileScanner {

//        1. - use map to store
//        1. key:  word all lowercase
//        2. value: occurrence
    Map<String, List<String>> wordByOccurrence = new HashMap<>();

    /**
     * Scan the input file and save with word-occurrence pairs
     * @param filePath
     */
    public void scanFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scan = new Scanner(file);
            //Reading each line of the file using Scanner class
            int lineNumber = 1;
            while(scan.hasNextLine()){
                String line = scan.nextLine().toLowerCase();

                List<String> lineWords = getLineWords(line);
                System.out.println(Arrays.toString(lineWords.toArray()));
//                System.out.println(Arrays.toString(lineWords));
                for(String word: lineWords) {
                    System.out.println(word);

                    // remove any special characters at the end
                    for (int i = 0; i < line.length() - word.length() + 1 ; i++) {
                        int column = -1;
                        String currentStr = line.substring(i, i + word.length());
                        System.out.println(currentStr);

                        if (currentStr.equals(word)) {
                            column = i;
                            String occurrence = "Line: " + lineNumber + " Column: " + column;
                            System.out.println("word " + word + " :" + lineNumber + ", " + column);
                            if (wordByOccurrence.containsKey(word)){ // not first time
                                List<String> value = wordByOccurrence.get(word);
                                value.add(occurrence);
                            } else { // first time
                                List<String> occurrences = new ArrayList<>();
                                occurrences.add(occurrence);
                                wordByOccurrence.put(word, occurrences);
                            }
                        }
                    }

                }
//                System.out.println("line " + lineNumber + " :" + line);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println(wordByOccurrence.toString());
    }

    /**
     * print out
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Check all occurrences of the input word
     * @param word
     * @return all occurrences or "no result found"
     */
    public String checkOccurrences(String word) {
        List<String> value = wordByOccurrence.get(word);
        if (Optional.ofNullable(value).isPresent()) {
            return Arrays.deepToString(value.toArray());
        } else {
            return "No result found..";
        }
    }

    /**
     * Get list of
     * @param scanLine
     * @return
     */
    private List getLineWords(String line) {
        // split word with space
        String[] lineWords = line.split("\\s+");

        List<String> newList = new ArrayList<>();
        List<String> list = new ArrayList<>(Arrays.asList(lineWords));
        for (String word: list) {
            word = word.replaceAll("[^a-z]$", "");
            if (!newList.contains(word)) {
                newList.add(word);
            }
        }
        return newList;
    }
}
