/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round714;

/**
 *
 */
import java.util.Scanner;
import java.lang.Math;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        long l1 = scan.nextLong();
        long r1 = scan.nextLong();
        
        long l2 = scan.nextLong();
        long r2 = scan.nextLong();
        
        long k = scan.nextLong();
        
        long l = Math.max(l1, l2);
        long r = Math.min(r1, r2);
        
        long time = Math.max(0,(r-l + (k >= l && k <= r ? 0 : 1 )));
        
        System.out.println(time);
    }
}
