/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.wordsearch;

/**
 *
 * @author Bashar Jirjees
 */
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Arrays;

public class WordSearch {
private static volatile boolean res = false;
private static int check = 0;
    public static void main(String[] args) {
    String board[][] = {
    {"o","a","a","n"},
    {"e","t","a","e"},
    {"i","h","k","r"},
    {"i","f","l","v"}}; //4 * 4 array
    List<String> data = Arrays.asList(board).stream().flatMap(x -> Stream.of(x)).collect(Collectors.toList()); 
    final String search = "vroom";
    int counter = 1;
    int index = data.indexOf(String.valueOf(search.charAt(0)));
    int checker = 0;
    
   // System.out.println("Data   " + data);
    while(true){
        if(!data.contains(String.valueOf(search.charAt(0)))){ res = false; break;}
        
        else
        if( counter < search.length() && 
           ((index + 1 < data.size() && data.get(index + 1).equals(String.valueOf(search.charAt(counter))) && checking(1)) ||
            (index - 1 >= 0  && data.get(index - 1).equals(String.valueOf(search.charAt(counter))) && checking(-1))||
            (index + 4 < data.size()  && data.get(index + 4).equals(String.valueOf(search.charAt(counter)))&& checking(4)) ||
            (index - 4 >= 0  && data.get(index - 4).equals(String.valueOf(search.charAt(counter)))&& checking(-4)))) 
        {
            
            res = true;
            index = index + check;
            ++checker;
            if(checker == search.length() - 1) break;
            ++counter;
            
        }
        else{
            data.set(index, "0");
            counter = 0;
            checker = 0;
            index = data.indexOf(String.valueOf(search.charAt(counter)));
            counter = 1;
            res = false;
            
        }

    }
    System.out.println("Found: " + res + "  ");
    }
    
    public static boolean checking(int c){
        
        check = c;
        return true;
    }
    
}
