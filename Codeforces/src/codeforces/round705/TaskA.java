/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round705;

/**
 *
 */
import java.util.Scanner;
import java.lang.StringBuffer;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        
        int numLayers = scan.nextInt();
        
        if(numLayers%2 == 0){
            sb.append("I love it");
        }else{
            sb.append("I hate it");
        }
        
        numLayers--;
        
        for(;numLayers>0;numLayers--){
            String loveHate = numLayers%2 == 1 ? "hate" : "love";
            sb.insert(0,"I " + loveHate + " that ");
        }
        
        System.out.println(sb.toString());
        
    }
}