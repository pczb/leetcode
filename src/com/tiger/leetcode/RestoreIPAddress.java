package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class RestoreIPAddress {
    public static void main(String[] args) {
        RestoreIPAddress solution = new RestoreIPAddress();
        for(String ip: solution.restoreIpAddresses("010010"))
            System.out.println(ip);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        if (s == null) return ret;
        dfs(s, 0, ret, "", 0);
        return ret;
    }

    public void dfs(String s, int index, List<String> ret, String current, int count) {
        if (index == s.length() && count == 4) {
            ret.add(current);
            return;
        }
        if(index == s.length() || count == 4) return;
        if(s.charAt(index) == '0') {
            String tmp = "0.";
            if(count == 3)
                tmp = "0";
                dfs(s, index + 1, ret, current + tmp , count + 1);
            return;
        }
        for (int i = index; i <= index + 2 && i < s.length(); i++) {
            String ip = s.substring(index, i + 1);
            int tmp = Integer.valueOf(ip);
            if (count < 3) ip += ".";
            if (0 <= tmp && tmp <= 255) {
                dfs(s, i + 1, ret, current + ip, count + 1);

            } else
                break;
        }
    }
}
