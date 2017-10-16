package com.tiger;

import java.util.List;
import java.util.Stack;

/**
 * Created by tigerzhang on 2017/10/16.
 */
public class DecodeString {

    class ScanIndex {
        public ScanIndex(int index) {
            this.index = index;
        }

        int index;
    }

    public String decodeString(String s) {
        return decodeString(s, new ScanIndex(0));
    }

    public String decodeString(String s, ScanIndex index) {
        StringBuilder current = new StringBuilder();
        int repeat = 0;
        for (int i = index.index; i < s.length();) {
            char c = s.charAt(i);
            if (c == '[') {
                ScanIndex next = new ScanIndex(i + 1);
                String sub = decodeString(s, next);
                for (int j = 0; j < repeat; j++) {
                    current.append(sub);
                }
                i = next.index + 1;
                repeat = 0;
                continue;
            } else if (c == ']') {
                index.index = i;
                return current.toString();
            } else if (c >= '0' && c <= '9') {
                repeat = repeat * 10 + (c - '0');
            } else {
                current.append(c);
            }
            i++;
        }
        return current.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("2[xx]3[a2[b3[c]]]"));
    }
}
