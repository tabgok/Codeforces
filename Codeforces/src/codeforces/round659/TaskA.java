/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round659;

/**
 *
 */
import java.util.Scanner;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numHouses = scan.nextInt();
        int startHouse = scan.nextInt();
        int moves = scan.nextInt();
        
        while(moves < 0){
            moves += numHouses;
        }
        
        int endHouse = (startHouse + moves) % numHouses;
        if(endHouse == 0){ 
            endHouse = numHouses;
        }
        
        System.out.println(endHouse);
    }
}