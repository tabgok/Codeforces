/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round670;

/**
 *
 */
import java.util.Scanner;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numDays = scan.nextInt();
        
        int fullWeeks = numDays/7;
        int remainder = numDays%7;
        
        int minOff = fullWeeks*2;
        int maxOff = fullWeeks*2;
        
        if(remainder == 6){
            minOff += 1;
        }
        
        if(remainder == 1){
            maxOff += 1;
        }else if( remainder >= 2){
            maxOff += 2;
        }
        
        System.out.println(minOff +" " + maxOff);
        
    }
}