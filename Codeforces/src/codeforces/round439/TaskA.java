/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round439;

/**
 *
 */

 import java.util.Scanner;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numSongs = scan.nextInt();
        int duration = scan.nextInt();
        
        int ChuruTime = (numSongs-1)*10;
        
        int DevuTime = 0;
        for(int i=0;i<numSongs;i++){
            DevuTime += scan.nextInt();
        }
        
        
        if(DevuTime+ChuruTime > duration){
            System.out.println(-1);
        }else{
            System.out.println( (duration-DevuTime) / 5);
        }
    }
}