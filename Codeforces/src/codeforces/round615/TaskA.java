/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round615;

/**
 *
 */
import java.util.Scanner;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int stickA = scan.nextInt();
        int stickB = scan.nextInt();
        
        int numMoves = 0;
        
        while(stickA > 0 && stickB > 0 && (stickA >= 2 || stickB >= 2)){
            if(stickA > stickB){
                stickB++;
                stickA-=2;
            }else{
                stickA++;
                stickB-=2;
            }
            numMoves++;
        }
        System.out.println(numMoves);
    }
}