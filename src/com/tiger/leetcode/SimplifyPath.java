package com.tiger.leetcode;

import java.util.LinkedList;

public class SimplifyPath {
    public static String simplifyPath(String path) {  
        if(path.length() == 0){  
            return path;  
        }  
          
        String[] splits = path.split("/");  
        LinkedList<String> stack = new LinkedList<String>();
        for (String s : splits) {  
            if(s.length()==0 || s.equals(".")){  
                continue;  
            }else if(s.equals("..")){  
                if(!stack.isEmpty()){  
                    stack.pop();  
                }  
            }else{  
                stack.push(s);  
            }  
        }  
          
        if(stack.isEmpty()){  
            stack.push("");  
        }  
        String ret = "";  
        while(!stack.isEmpty()){  
            ret += "/" + stack.removeLast();  
        }  
          
        return ret;  
    }  
      
}
