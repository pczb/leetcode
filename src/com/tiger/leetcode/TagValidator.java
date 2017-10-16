package com.tiger.leetcode;


import java.util.LinkedList;

/**
 * Created by tigerzhang on 2017/10/9.
 */
public class TagValidator {



    private LinkedList<String> tagQueue = new LinkedList<>();

    public boolean isValid(String code) {
        tagQueue.clear();
        char[] chars = code.toCharArray();
        if (chars[0] != '<') {
            return false;
        }

        int index = consumePrevTag(chars, 1);
        while (index > 0 && index < code.length()) {
            char c = chars[index];
            if (c != '<') {
                index = consumeText(chars, index);
                continue;
            }
            if (index + 1 >= chars.length - 1) {
                return false;
            }
            char c1 = chars[index + 1];
            if (c1 == '/') {
                index = consumeEndTag(chars, index + 2) + 1;
            } else if (c1 == '!') {
                index = consumeCDATA(chars, index + 2) + 1;
            } else {
                index = consumePrevTag(chars, index + 1);
            }
        }

        return index > 0 && tagQueue.isEmpty();
    }

    public int consumeCDATA(char[] c, int startIndex) {
        while (startIndex + 2 < c.length) {
            if (c[startIndex] == ']' && c[startIndex + 1] == ']' && c[startIndex + 2] == '>') {
                return startIndex + 2;
            }
            startIndex += 1;
        }
        return -1;
    }

    public int consumePrevTag(char[] c, int startIndex) {
        int charLen = consumeTag(c, startIndex);
        if (charLen > 0) {
            tagQueue.push(new String(c, startIndex, charLen));
            return startIndex + 1 + charLen;
        }
        return -1;
    }

    public int consumeEndTag(char[] c, int startIndex) {
        int charLen = consumeTag(c, startIndex);
        if (charLen > 0) {
            String current = new String(c, startIndex, charLen);
            if (current.equals(tagQueue.peek())) {
                tagQueue.pop();
                return startIndex + charLen;
            }
        }
        return -1;
    }

    public int consumeTag(char[] c, int startIndex) {
        int tmp = startIndex;
        while (startIndex < c.length) {
            if (c[startIndex] < 'A' || c[startIndex] > 'Z') {
                break;
            }
            startIndex += 1;
        }
        if (startIndex >= c.length || c[startIndex] != '>'
                || startIndex - tmp < 1) {
            return -1;
        }
        return startIndex - tmp;
    }

    public int consumeText(char[] c, int startIndex) {
        int tmp = startIndex;
        while (startIndex < c.length) {
            if (c[startIndex] == '<') {
                break;
            }
            startIndex += 1;
        }

        return startIndex;
    }

    public static void main(String[] args) {
        TagValidator redisService =new TagValidator();
        System.out.println(redisService.isValid("<A><A></A></A>"));
    }
}
