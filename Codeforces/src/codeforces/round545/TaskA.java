/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round545;

/**
 *
 */
import java.util.Scanner;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numCars = scan.nextInt();
        
        boolean[] cars = new boolean[numCars];
        
        for(int i=0;i<numCars;i++){
            cars[i] = true;
        }
        
        for(int i=0;i<numCars;i++){
            for(int j=0;j<numCars;j++){
                int result = scan.nextInt();
                if(result == 1){
                    cars[i] = false;
                }else if(result == 2){
                    cars[j] = false;
                }else if(result == 3){
                    cars[i] = false;
                    cars[j] = false;
                }
            }
        }
        
        int numGoodCars = 0;
        
        for(int i=0;i<cars.length;i++){
            if(cars[i]){
                numGoodCars++;
            }
        }
        
        System.out.println(numGoodCars);
        
        for(int i=0;i<cars.length;i++){
            if(cars[i]){
                System.out.print((i+1) +" ");
            }
        }
        
    }
}
