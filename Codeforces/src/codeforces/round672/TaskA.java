/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.round672;

import java.util.Scanner;

/**
 *
 * @author teague
 */
public class TaskA {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int pos = scan.nextInt();
        
        StringBuilder result = new StringBuilder();
        
        int num = 1;
        
        while(result.length() < pos){
            result.append(num);
            num++;
        }
        
        System.out.println(result.charAt(pos-1));
    }
}
