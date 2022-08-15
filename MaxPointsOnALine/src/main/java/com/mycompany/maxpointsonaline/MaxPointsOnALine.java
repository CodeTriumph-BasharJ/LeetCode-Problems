/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.maxpointsonaline;

/**
 *
 * @author basha
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MaxPointsOnALine {

    public static void main(String[] args) {
        final int arr[][] = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        List<Integer> list = new ArrayList<>();
        int counter = 1;
       
        int x,y;
        for(int i = 0; i < arr.length; ++i){
            x =arr[i][0];
            y =arr[i][1];
 
            for(int j = i + 1; j < arr.length; ++j){
                if(arr[j][0] > x && arr[j][1] > y)++counter;
 
            }
            list.add(counter);
            counter = 1;
        } 
        
        for(int i = 0; i < arr.length; ++i){
            x =arr[i][0];
            y =arr[i][1];
 
            for(int j = i + 1; j < arr.length; ++j){
                if(arr[j][0] < x && arr[j][1] < y)++counter;
 
            }
            list.add(counter);
            counter = 1;
        }
        
        for(int i = 0; i < arr.length; ++i){
            x =arr[i][0];
            y =arr[i][1];
 
            for(int j = i + 1; j < arr.length; ++j){
                if(arr[j][0] == x && arr[j][1] == y)++counter;
 
            }
            list.add(counter);
            counter = 1;
        }
        
        System.out.println("Max Line Dots: " + Collections.max(list));
    }
}
