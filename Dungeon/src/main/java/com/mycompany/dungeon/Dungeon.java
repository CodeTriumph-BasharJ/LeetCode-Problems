/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.dungeon;

/**
 *
 * @author basha
*/

import java.util.ArrayList;

public class Dungeon {
static int i = 0;
    public static void main(String[] args) {
      
        int arr[][] = { {-2, -3,  3,3} ,
                        {-5,-10, 1,0},
                        {10, 30,-5,7} };
        
        ArrayList<Integer> list = new ArrayList<>();

     
        final int width = arr[0].length;
        final int height = arr.length;
        
        int sum = 0;
        int sum_temp=0;
        int counter = 0;
        int y = 0;
        int z = 1;
        int prev = 0,prev_sum=0;
        
    for(int j = 0; j < height; j++){
       prev = j;
       sum_temp += arr[j][0];
       
    for(;;){
           
            if(z <= width-1 && counter == 0){
                prev_sum = sum+=arr[j][z]; 
                counter = 1;
            }
            else if(j < height-1 && counter == 1){
                
                sum+=arr[++j][y = z];
               
            }
            else if(j == height-1 && y < width-1){
                
                sum+=arr[j][++y];
                
            }
            else if(y == width -1 && z < width){
               
                list.add(sum + sum_temp);
                j = prev;
                ++z;
                sum=prev_sum;
                counter = 0;
            }
            else if(z == width){                                 
                j = prev;
                counter=0;
                sum = 0;
                z=1;
                break;
            }
          }
        }
    
    System.out.println(list);
    
       }
      } 

