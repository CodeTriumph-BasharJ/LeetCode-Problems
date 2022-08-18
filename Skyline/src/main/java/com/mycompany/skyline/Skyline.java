/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.skyline;

/**
 *
 * @author Bashar Jirjees
 */

import java.util.ArrayList;

public class Skyline {

    public static void main(String[] args) {
        
        int arr [][] = {{0,2,3},{2,5,3}};
        ArrayList<ArrayList<Integer>> skyline = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        final int row = arr.length;
        final int column = arr[0].length;
       
        int i = 0;
        int x = 0;
        int val_l = 0;
        int val_2 = 0;
        for(;;){
            for(int j = x + 1; j < row; ++j){
            
            if(arr[j][1] >= arr[x][1] ){
              val_l = arr[j][0] - arr[x][0];
              val_2 = arr[x][1] - arr[x][0];
              if(val_l > val_2){
                  list.add(arr[x][1]);
                  list.add(0);
                  skyline.add(list);
                  break;
                  
              }else {
                  
                list.add(arr[x][0]);
                if(arr[x][2] > arr[j][2])list.add(arr[x][2]);
                else list.add(arr[j][2]);
                skyline.add(list);
                if(arr[x][1] <= arr[j][1] && arr[x][2] != arr[j][2]){
                list = new ArrayList<>();  
                list.add(arr[x][1]);
                list.add(arr[j][2]);
                skyline.add(list);
                }
                break; 
              }

            }else {    
               list.add(arr[x][0]);
               if(arr[x][2] < arr[j][2])list.add(arr[x][2]);
               else list.add(arr[j][2]);
               skyline.add(list);  
               break;
            }
     } 
     list = new ArrayList<>();     
     ++x;
     if(x == row)
     {
         list.add(arr[row-1][1]);
         list.add(0);
         skyline.add(list);
         break;
     }
       }
    System.out.println(skyline);
      }
    }

