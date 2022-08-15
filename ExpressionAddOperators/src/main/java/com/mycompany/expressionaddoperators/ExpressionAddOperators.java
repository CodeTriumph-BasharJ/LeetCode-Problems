/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.expressionaddoperators;

/**
 *
 * @author basha
 */
import java.util.List;
import java.util.ArrayList;

public class ExpressionAddOperators {

    public static void main (String[] args){
        List<String> ans = new ArrayList<>();
        int target =6;
        String num = "222";
        dfs(ans, num, ""/*path*/, target, 0/*depth*/, 0/*eval*/, 0/*lastAdd*/);
        System.out.println(ans);
    }
    private static void dfs(List<String> ans, String num,  String path, int target, int depth, long eval, long lastAdd){
        if(depth == num.length()){
            if(eval == target) ans.add(path);
            return;
        }

        for(int i = depth; i < num.length();++i){
            // substring the operand, excluding the leading '0' ones 
            if(i > depth && num.charAt(depth) == '0') break;
            long cur = Long.parseLong(num.substring(depth, i + 1)); //[depth... i]
            // global first operand 
            if(depth == 0){
               dfs(ans, num , Long.toString(cur)/*path*/, target, i + 1 /*depth*/, cur, cur); // leading element
            }
            else{
                //add
                dfs(ans,num,path + "+" + cur, target, i + 1, eval + cur, cur);
                //subtract
                dfs(ans,num,path + "-" + cur, target, i + 1, eval - cur, -cur);
                //multiply
                dfs(ans,num,path + "*" + cur, target, i + 1, eval - lastAdd + lastAdd * cur, lastAdd * cur);
            }
        }
    }
}

