/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round588;

/**
 *
 */
import java.util.Scanner;
import java.lang.Math;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numDays = scan.nextInt();
        long cost = 0;
        
        int minCost = Integer.MAX_VALUE;
        
        for(int i=0;i<numDays;i++){
            int required_today = scan.nextInt();
            int cost_today = scan.nextInt();
            
            minCost = Math.min(minCost, cost_today);
            
            cost += minCost*required_today;
        }
        
        System.out.println(cost);
    }
}
