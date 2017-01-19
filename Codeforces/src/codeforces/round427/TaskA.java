/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round427;

/**
 *
 */

 import java.util.Scanner;
import java.lang.Math;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numEvents = scan.nextInt();
        
        int untreated = 0;
        int freePolice = 0;
        
        for(int i=0;i<numEvents;i++){
            int next = scan.nextInt();
            
            if(next == -1){
                if(freePolice == 0){
                    untreated++;
                }else{
                    freePolice--;
                }
            }else{
                freePolice += next;    
            }
        }
        
        System.out.println(untreated);
    }
}
