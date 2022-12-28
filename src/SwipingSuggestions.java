import java.util.*;
import java.io.*;

class SwipingSuggestions {
    static final int NUMCHARS = 26;
    static String options[];
    static String words[];

    static int count = 0;


    static String inputWord;
    static boolean wordFound = false;
    // WRITE YOUR CODE HERE

    static void keyboardSearch(int nextIndex, String partialWord) {
        String Comparison = "";
        if (partialWord.length() == inputWord.length()) {
            if (Arrays.binarySearch(words, partialWord) > -1) {
                wordFound = true;
                System.out.print(partialWord + " ");
            }
            return;
        }

        for (int i = 0; i < options.length; i++) {
            if (inputWord.charAt(nextIndex) == options[i].charAt(0)) {
            Comparison = options[i];
            }

            }

           for (int i = 0; i < Comparison.length(); i++) {
               keyboardSearch(nextIndex + 1, partialWord + Comparison.charAt(i));
            }
        }

    /*
    A5 Swiping Suggestions

    Recursive method parameters?

    static String inputWord;

    findOptions(int nextIndex, String partialWord)
        if length matches for partialWord and inputWord
            check partialWord in dictionary and output if valid
                ( binarySearch() method for efficiency )

            return

        look at the options for inputWord.charAt(nextIndex);
        for each of those characters
            findOptions(nextIndex+1, partialWord + optionChar);


    main():
        inputWord = input.next();

        findOptions(0, "");
     */
    public static void main(String[] args) throws Exception {
        Scanner dictionaryInput = new Scanner(new File("words.txt"));

        int numWords=0;
        while (dictionaryInput.hasNextLine()) {
            dictionaryInput.nextLine();
            numWords++;
        }
        dictionaryInput.close();

        words = new String [numWords];
        dictionaryInput = new Scanner(new File("words.txt"));
        for(int i=0; i<numWords; i++)
            words[i] = dictionaryInput.nextLine();
        dictionaryInput.close();

        Scanner optionsInput = new Scanner(new File("options.txt"));
        options = new String [NUMCHARS];
        for(int i=0; i<NUMCHARS; i++) {
            options[i] = optionsInput.nextLine();
        }

        Scanner input = new Scanner(System.in);
        inputWord = input.next();

        keyboardSearch(0, "");
        if(wordFound == false){
            System.out.print("None");
        }

// WRITE YOUR CODE HERE
    }
}
