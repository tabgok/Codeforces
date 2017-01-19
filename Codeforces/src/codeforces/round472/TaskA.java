/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round472;

import java.util.Scanner;

/**
 *
 */
public class TaskA {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int otherPart = scan.nextInt()-4;
        
        int evenPart = 4;
        
        int count = 0;
        
        int i = 2;
        while(!isComposite(otherPart)){
            evenPart+=2;
            otherPart-=2;
        }
        
        System.out.println(evenPart + " " + otherPart);
    }
    
    private static boolean isComposite(int n){
        for(int i=2;i<n/2;i++){
            if(n % i == 0){
                return true;
            }
        }
        
        return false;
    }

}
