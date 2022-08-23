/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.validnumber;

/**
 *
 * @author basha
 */

public class ValidNumber {

    
    public static void main(String[] args) {
        boolean valid = true;
        String number = "e987";
        String number_mod = number.toLowerCase();
        int dot = 0,e_ind = 0;
        
        if(number_mod.contains(".") && number.indexOf(".") != number.lastIndexOf("."))valid=false;
        
        else if(valid == true){
        if(number_mod.contains("."))dot = number_mod.indexOf(".");
        else  dot = -1;
        
        if(number_mod.indexOf("e")!=number_mod.lastIndexOf("e")) valid=false;
        if(number_mod.contains("e")) e_ind = number_mod.indexOf("e"); 
        if(number_mod.matches(".*[a-df-z].*")) valid = false;
        if(number_mod.matches(".*[?!#$%^&*=<>,'].*"))valid = false;
        }  
        
        if (valid == true){
        for(int i = 0; i < number_mod.length(); ++i){
        
         if((String.valueOf(number_mod.charAt(i)).equals("+")||String.valueOf(number_mod.charAt(i)).equals("-"))){
             if(i == 0 || i == e_ind +1)valid = true;
             else{
             valid = false; 
             break;
             }
         } else if(String.valueOf(number_mod.charAt(i)).equals("e") && dot != -1 && number_mod.indexOf("e") <= dot + 1) {
             valid = false; 
             break;
         } else if(String.valueOf(number_mod.charAt(i)).equals("//") || String.valueOf(number_mod.charAt(i)).equals("[")
                 || String.valueOf(number_mod.charAt(i)).equals("]") || String.valueOf(number_mod.charAt(i)).equals("{")
                 || String.valueOf(number_mod.charAt(i)).equals("}") || String.valueOf(number_mod.charAt(i)).equals("(")
                 || String.valueOf(number_mod.charAt(i)).equals(")"))
         {
             valid = false;
             break;
         }
           else valid = true;
            
        }
        
        }
        
        System.out.println(valid);
    }
}
