/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round476;

import java.util.Scanner;

/**
 *
 */
public class TaskA {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numStairs = scan.nextInt();
        int numMoves = scan.nextInt();
        
        int moves = (numStairs+1)/2;
        
        for(;moves < numStairs && moves%numMoves!=0;moves++){}
        
        if(moves%numMoves == 0){
            System.out.println(moves);
        }else{
            System.out.println(-1);
        }
    }

}
