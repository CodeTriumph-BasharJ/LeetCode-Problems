/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.nqueens;

/**
 *
 * @author basha
 */

import java.util.ArrayList;

public class NQueens {

    public static void main(String[] args) {
        final int n = 15;
        String [][] arr = new String[n][n];
        
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<String> matrix = new ArrayList<>();
        int counter = 0, breaker=0;
        int i = 0, j = 0;
        int prevL ,prevR ;
        String s = "";
       
        
    while(true){
        
      prevL=prevR=-1;
      
      while(true){
      
       
       if (counter == 0 && !indexes.contains(i) && i != prevL && i!= prevR){
       
       arr[j][i] =" Q";
       indexes.add(i);
       prevL = i-1;
       prevR = i+1;
       ++counter;
       }
       else {
        
        ++i; 
        if(i == n){
                i= 0;
                j++;
                counter = 0;
                if(j == n){ j = i = 0; break;}
            }else arr[j][i] = " .";
       

       }   
            
        }
    counter = 0;
    for(int z = 0; z < arr.length; ++z){
      for(int x = 0; x < arr[0].length; ++x){
          if(arr[z][x] == null)arr[z][x] = " .";
          
          s = s.concat(arr[z][x]);
         
        }
       matrix.add(s);
       s = "";
      
      }
   i = ++breaker;
  
   if(matrix.get(n-1).contains(" Q"))System.out.println(matrix);
   if(breaker == n) break;
   arr = new String[n][n];
   indexes = new ArrayList<>();
   matrix =  new ArrayList<>();
   counter = 0;
   
     }
    }
   }
