/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.largestrectangleinhistogram;

/**
 *
 * @author basha
 */
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        
        Integer arr[] = {1,2,4,3,2,7};
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        List<Integer> areas = new ArrayList<>();
        Integer min = list.get(0);
      
        if(list.size() == 1)System.out.println("Max Rectangle Area: " + list.get(0));
        else{
        for(int i = 1; i < list.size(); ++i)
        {
            
            if(list.get(i) < min && list.get(i)!= 0 ) {min = list.get(i);}
            else{
                
                areas.add(min * (i + 1));
                if(i  < list.size())min = list.get(i);
                list.subList(0,i).clear();
                i = 0;
            } 
            
           
        }
    
        if(!areas.isEmpty()) System.out.println("Max Rectangle Area: " + Collections.max(areas));
        else System.out.println("Max Rectangle Area: " + 0);
        }
    }
}
