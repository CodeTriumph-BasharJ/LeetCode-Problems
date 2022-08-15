/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.minimumwindowsubstring;

/**
 *
 * @author Bashar Jirjees
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class MinimumWindowSubstring {
    
 static List<String> counters = new ArrayList<>();
 
    public static void main(String[] args) {
        
        String target = "ABC";
        String container = "ADOBECODEBANC";
        length(container,target,target.length());
        counters = counters.stream().sorted((x,y) -> sort_by_length(x,y)).collect(Collectors.toList());
        if(!counters.isEmpty()) System.out.println(counters.get(0));
        else System.out.println("No Minimal String Exists");
    }
    public static int length(String container, String target, int length){
        if(length == container.length())return 0;
        int counter =0, counter2 = 0;
        String s = container.substring(container.length() - length - 1 ,container.length());
        String s2 = container.substring(0 ,length);
        for(int i = 0; i  < target.length(); ++i){
        if(s.contains(String.valueOf(target.charAt(i))))
          ++counter;  
        if(s2.contains(String.valueOf(target.charAt(i))))
          ++counter2; 
        }
        if(counter == target.length())counters.add(s);
        if(counter2 == target.length())counters.add(s2);
        return length(container,target,length+1);

    }
    public static int sort_by_length(String s1, String s2){
        int res = 0;
        if (s1.length() < s2.length())res = -1;
        else if(s1.length() > s2.length()) res = 1;
        else res = 0;
        
        return res;
        
    }
}
