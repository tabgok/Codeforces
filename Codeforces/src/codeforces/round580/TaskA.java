/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.round580;

import java.util.Scanner;

/**
 *
 * @author teague
 */
public class TaskA {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numDays = scan.nextInt();
        int[] earnings = new int[numDays];
        
        for(int i=0;i<numDays;i++){
            earnings[i] = scan.nextInt();
        }
        
        int curIncreasing = 1;
        int maxIncreasing = 1;
        
        for(int i=1;i<numDays;i++){
            if(earnings[i] >= earnings[i-1]){
                curIncreasing++;
                maxIncreasing = Math.max(curIncreasing, maxIncreasing);
            }else{
                curIncreasing = 1;
            }
        }
        System.out.println(maxIncreasing);
    }
}
