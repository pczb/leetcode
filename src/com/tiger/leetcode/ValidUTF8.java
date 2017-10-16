package com.tiger.leetcode;

import com.google.common.primitives.Ints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tigerzhang on 2017/8/28.
 */
public class ValidUTF8 {
    static class Solution {

        private byte significant = (byte)0b10000000;

        public boolean validUtf8(int[] data) {
            int start = 0;
            while (start < data.length) {
                int codeLen = getCodeLength(data[start]);
                if (codeLen >= 1 && isValid(data, start, codeLen)) {
                    start += codeLen;
                } else {
                    return false;
                }
            }
            return true;
        }

        private int getCodeLength(int data) {
            if ((data & 0b10000000) == 0b00000000) {
                return 1;
            } else if ((data & 0b11100000) == 0b11000000) {
                return 2;
            } else if ((data & 0b11110000) == 0b11100000) {
                return 3;
            } else if ((data & 0b11111000) == 0b11110000) {
                return 4;
            }
            return -1;
        }

        private boolean isValid(int[] data, int start, int len) {
            if (data.length < (start + len - 1)) {
                return false;
            }

            for (int i = 1; i < len; i++) {
                int tmp = 0b11000000 & data[start + i];
                if (tmp != 0b10000000) {
                    return false;
                }
            }
            return true;
        }
    }

        public static int[] stringToIntegerArray(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            String[] parts = input.split(",");
            int[] output = new int[parts.length];
            for(int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }

        public static String booleanToString(boolean input) {
            return input ? "True" : "False";
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                int[] data = stringToIntegerArray(line);

                for (int i= 0; i < data.length; i++) {
                    System.out.println(Integer.toOctalString(data[i] & 0xFF));
                    System.out.print(Integer.toBinaryString(0xFF & data[i]) + " | ");
                }
                boolean ret = new Solution().validUtf8(data);

                String out = booleanToString(ret);

                System.out.print(out);
            }
        }
}
