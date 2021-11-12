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
                String[] lineWords = line.split("\\s+");
//                System.out.println(Arrays.toString(lineWords));
                for(String word: lineWords) {
                    word = word.replaceAll("[^a-z]", "");
                    int column = line.indexOf(word);
                    if(column != -1) { //hel!oo
                        String occurrence = "Line: " + lineNumber + " Column: " + column;
//                        System.out.println("word " + word + " :" + lineNumber + ", " + column);
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
}
