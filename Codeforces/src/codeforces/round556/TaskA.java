/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round556;

/**
 *
 */
import java.util.Scanner;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int stringLength = scan.nextInt();
        String string = scan.next();
        
        int numZeros = 0;
        
        for(char c : string.toCharArray()){
            if(c == '0'){
                numZeros++;
            }
        }
        
        int numOnes = stringLength - numZeros;
        
        System.out.println(Math.abs(numOnes-numZeros));
    }
}