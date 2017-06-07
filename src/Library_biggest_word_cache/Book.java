package Library_biggest_word_cache;

import java.util.HashMap;

public class Book {
    String bookName;
    String bookText;
    String biggestWord;


//calculation biggest word in a book
    public void calcBiggestWord() {
        biggestWord = "";
        String[] bookSplit = bookText.split("\\s");
        for (int i = 0; i <bookSplit.length ; i++) {
            if (bookSplit[i].length() > biggestWord.length()) {
                biggestWord = bookSplit[i];
            }
        }

    }

}
