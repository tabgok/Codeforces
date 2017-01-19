/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round465;

/**
 *
 */
import java.util.Scanner;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numBits = scan.nextInt();
        scan.nextLine();
        
        char[] next = scan.nextLine().toCharArray();
        
        int count =0;
        while(count < next.length && next[count] != '0'){
            count ++;
        }
        if(count < next.length){
            count += 1;
        }
        
        System.out.println(count);
    }
}
