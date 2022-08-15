/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.rainwater;

/**
 *
 * @author basha
 */

import java.util.*;
import java.util.Collections;

public class RainWater extends ArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        List<Integer> counters = new ArrayList<>();

        Collections.addAll(arr,0,1,0,2,1,0,1,3,2,1,2,1);
        Integer max = 0, counter = 0;
        int i = 0;
        
       int v1 = 0;
       int v2 = 0;
     for(i = 0; i < arr.size(); ++i){
         max = arr.get(i);
         counter = 0;
         for(int x = i+1 ; x < arr.size();){
             
             if(arr.get(x) >= max){
                 counters.add(counter);
                 break;
                 
             }
             else {
               
                 if (x-1 >= 0) v1 = Math.abs(arr.get(x-1)-arr.get(x));
                 if(x+1 < arr.size())v2= Math.abs(arr.get(x+1)-arr.get(x));
                 if(v1 > v2)counter+= (int)v2;
                 else counter+= (int)v1;
                 ++x;
                 if(x == arr.size()){
                     break;
                 }
             }

         }
         
         
     }
       int sum=0;
       for(Integer j : counters)sum+=j;
       System.out.println("Number of Drops : " + sum);
      
      
      
       

    }
}
