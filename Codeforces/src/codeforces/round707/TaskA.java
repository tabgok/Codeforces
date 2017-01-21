/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round707;

/**
 *
 */
import java.util.Scanner;
import java.util.HashSet;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        HashSet<String> colors = new HashSet<>();
        
        colors.add("C");
        colors.add("M");
        colors.add("Y");
        
        int width = scan.nextInt();
        int height = scan.nextInt();
        
        for(int i=0;i<width*height;i++){
            if(colors.contains(scan.next())){
                System.out.println("#Color");
                return;
            }
        }
        
        System.out.println("#Black&White");
        
    }
}