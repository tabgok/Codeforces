/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.round617;
import java.util.Scanner;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int friendPos = scan.nextInt();
        
        int numFives = friendPos / 5;
        int remaining = friendPos % 5;
        
        int numSteps = numFives + (remaining > 0 ? 1 : 0);
        
        System.out.println(numSteps);
    }
}