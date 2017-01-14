/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round550;

import java.util.Scanner;

/**
 *
 */
public class TaskA {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        String s = scan.next();
        
        if( (s.contains("BA") && s.replaceFirst("BA","CC").contains("AB")) ||
            (s.contains("AB") && s.replaceFirst("AB","CC").contains("BA")) ){
                System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
