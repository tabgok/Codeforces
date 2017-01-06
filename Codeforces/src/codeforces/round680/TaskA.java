/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.round680;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int[]cards = new int[101];
        
        int sum = 0;
        for(int i=0;i<5;i++){
            int next = scan.nextInt();
            cards[next]++;
            sum += next;
        }
        
        
        
        int max = 0;
        for(int i=0;i<101;i++){
            if(cards[i] >= 2){
                max = Math.max(max, Math.min(cards[i],3)*i);
            }
        }
        
        System.out.println(sum-max);
    }
}