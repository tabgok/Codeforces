/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round454;

/**
 *
 */
import java.lang.Math;
import java.util.Scanner;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int mid = n/2;
        
        for(int row=0;row<n;row++){
            char[] curRow = new char[n];
            int distance = mid - Math.abs(row-mid);
            
            for(int col=0;col<n;col++){
                if(Math.abs(mid-col) <= distance ){
                    curRow[col] = 'D';
                }else{
                    curRow[col] = '*';
                }
            }
            System.out.println(new String(curRow));
        }
    }
}
