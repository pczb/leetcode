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
                int space = (L - wordsLen) / (wordsCount- 1);
                int extra = (L - wordsLen) % (wordsCount - 1);
                StringBuilder builder = new StringBuilder();
                for(int j = 0; j < wordsCount; j++){
                    builder.append(tmp.get(j));
                    if(j < wordsCount - 1) {
                        for (int k = 0; k < space; k++)
                            builder.append(" ");
                        if (extra != 0) {
                            builder.append(" ");
                            extra -= 1;
                        }
                    }
                }
                ret.add(builder.toString());
            }
        }
        return null;
    }
}
