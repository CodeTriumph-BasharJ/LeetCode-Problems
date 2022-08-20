/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.permutations;

/**
 *
 * @author basha
 */

import java.util.ArrayList;
import java.lang.StringBuilder;
public class Permutations {

    public static void main(String[] args) {
     
        final int n = 4;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> perm = new ArrayList<>();
        
        for(int i=1; i <= n; ++i) list.add(i);
      
        int factorial = n;
        for(int i = n-1; i > 0; --i)factorial = factorial*i;
        ArrayList<Integer> data = new ArrayList<>(list);
        final int perm_per_try = factorial / n;
        int perm_counter = 0;
        int process_counter = 0;
        int i = 1, j = 1;
        int prev;
        ArrayList<Integer> temp;
        
        
        while(true){
            
            prev = list.get(i+1);
            list.set(i+1,list.get(i));
            list.set(i,prev);
            temp = new ArrayList<>(list);
            perm.add(temp);
           
            ++i;
            ++process_counter;
            
            if(i == n - 1) i = 1;  
            if(process_counter == perm_per_try && j < n){
               process_counter = 0;
               list = data;
               prev = list.get(0);
               list.set(0,list.get(j));
               list.set(j, prev);
               i = 1;
               ++j;
            }
            ++perm_counter;
            if(perm_counter == factorial) break;
        }
        
        System.out.println("Number of Permutations: " +  perm.size());
        
        i = j = 0;
        StringBuilder str = new StringBuilder();
        
        while(true){
        str.append(perm.get(i).get(j));
        ++j;
        if(j == n){
            System.out.println(str.toString());
            str.delete(0, n);
            j=0;
            ++i;
            if(i == factorial)break;
        }
     }
    }
 
}
