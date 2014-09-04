package com.tiger.leetcode;



import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 14-9-4.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {

        int currentWordsLen = 0, currentWordCount = 0, currentLineLen = 0;

        List<String> ans = new LinkedList<String>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if(word.length() > L)
                return new LinkedList<String>();

            if(currentLineLen + word.length() > L) {

                ans.add(justifyText(words, i, currentWordsLen, currentWordCount, L));
                currentWordCount = 0;
                currentWordsLen = 0;
                currentLineLen = 0;
            }
            currentWordCount++;
            currentLineLen += word.length() + 1;
            currentWordsLen += word.length();
        }
        StringBuilder builder = new StringBuilder();
        for(int i = currentWordCount; i > 1; i--) {
            builder.append(words[words.length - i]);
            builder.append(" ");
        }
        builder.append(words[words.length -1]);
        for(int i = currentWordsLen + currentWordCount; i <= L; i++)
            builder.append(" ");
        ans.add(builder.toString());
        return ans;
    }

    private String justifyText(String[] words, int end, int currentWordsLen, int currentWordCount, int L) {
        StringBuffer buffer = new StringBuffer();
        if(currentWordCount == 1) {
            buffer.append(words[end - 1]);
            for(int k = currentWordsLen + 1; k <= L; k++) buffer.append(" ");
        }else {
            int avgSpace = (L - currentWordsLen) / (currentWordCount - 1);
            int extraSpace = (L - currentWordsLen) % (currentWordCount - 1);
            for(int k = currentWordCount; k > 1; k--) {
                buffer.append(words[end - k]);
                for(int j = 0; j < avgSpace; j++) buffer.append(" ");
                if(extraSpace != 0){
                    buffer.append(" ");
                    extraSpace -= 1;
                }
            }
            buffer.append(words[end - 1]);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        TextJustification solution = new TextJustification();
        String[] text = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] text1 = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] text2 = {"a","b","c","d","e"};
        String[] text3 = "What must be shall be.".split(" ");
        for(String str: solution.fullJustify(text3, 12)) System.out.println(str);
    }
}
