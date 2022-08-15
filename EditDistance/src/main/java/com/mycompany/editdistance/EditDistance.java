/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.editdistance;

/**
 *
 * @author basha
 */
import java.util.ArrayList;
public class EditDistance {

    public static void main(String[] args) {
        String word1 = "dictionary";
        String word2 = "intention";
        final int L1 = word1.length();
        final int L2 = word2.length();
        ArrayList<Integer> list = new ArrayList<>();
        
        int i = 0, j =0;
        
        while(true){
            if(String.valueOf(word2.charAt(i)).equals(String.valueOf(word1.charAt(j)))){
                if(!list.contains(word2.lastIndexOf(word2.charAt(i))))
                list.add(word2.lastIndexOf(word2.charAt(i)));
               
            }
            ++i;
            if(i==word2.length()) { i=0;++j;}
            if(j == word1.length())break;
            
        }
        if(list.isEmpty())System.out.println("Number of operations needed: " + Math.abs(word2.length() - word1.length()));
        else{
            i=0;
            int swaps = 0;
            
            while(i < list.size()-1){
                if(list.get(i)>list.get(i+1)){
                    
                    ++swaps;

                }
                ++i;
            }
            
            
            System.out.println("Number of operations needed: " + swaps + Math.abs(Integer.max(word2.length(),word2.length()) - list.size()));
        }
      
        
        
    }
}
