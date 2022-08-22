/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.permutations;

/**
 *
 * @author Bashar Jirjees
 */

import java.util.ArrayList;
import java.lang.StringBuilder;
public class Permutations {

    public static void main(String[] args) {
     
        final int n = 9;
        final ArrayList<Integer> list = new ArrayList<>();
        final ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(i);
        for(int i = 0; i < n; ++i) nums.add(0);
        int factorial = n;
        for(int i = n-1; i > 0; --i)factorial = factorial*i;

        int i = 1;
        int prev;
        final ArrayList<ArrayList<Integer>> perm = new ArrayList<>();
        ArrayList<Integer> temp;
        perm.add(list);
        while(i < n){
           if(nums.get(i) < i){
              if(i % 2 == 0){
                  prev = list.get(0);
                  list.set(0, list.get(i));
                  list.set(i, prev);
              }else{
                  prev = list.get(nums.get(i));
                  list.set(nums.get(i), list.get(i));
                  list.set(i, prev);
              }
               temp = new ArrayList<>(list);
               perm.add(temp);
               nums.set(i, nums.get(i) + 1);
               i = 1;
 
           }else{
               nums.set(i, 0);
               ++i;
           }
          
       }
        
        System.out.println("Number of Permutations: " +  perm.size());
        
        i =0;
        int j = 0;
        StringBuilder str = new StringBuilder();
        while(true){
        str.append(perm.get(i).get(j));
        ++j;
        if(j == n){
           
            System.out.println(str.toString());
            str.delete(0, n);
            j=0;
            ++i;
            if(i == perm.size())break;
        }
      }
        
        }
    }


