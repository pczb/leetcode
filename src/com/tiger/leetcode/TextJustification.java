package com.tiger.leetcode;
import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new ArrayList<String>();
        int pre = 0;
        int wordsLen = 0;
        List<String> tmp = new ArrayList<String>();
        for(int i = 0; i < words.length; i++) {
            if(pre + words[i].length() <= L){
                tmp.add(words[i]);
                pre += words.length;
                wordsLen += wordsLen;
                if(pre + words[i].length() != L)
                    pre += 1;
            }else{
                int wordsCount = tmp.size();
                int space = (L - wordsLen)
            }
        }
        return null;
    }
}
