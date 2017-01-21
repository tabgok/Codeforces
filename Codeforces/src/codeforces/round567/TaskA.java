/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round567;

/**
 *
 */
import java.util.Scanner;
import java.lang.Math;
import java.util.HashMap;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numCities = scan.nextInt();
        int[] cities = new int[numCities];
        
        for(int i=0;i<numCities;i++){
            cities[i] = scan.nextInt();
        }
        
        //Print the first city's values
        System.out.println(
            (cities[1]-cities[0]) +" " + 
            (cities[numCities-1]-cities[0]));
        
        for(int i=1;i<numCities-1;i++){
            System.out.println(
                Math.min(cities[i+1]-cities[i], cities[i]-cities[i-1]) + " " +
                Math.max(cities[i]-cities[0], cities[numCities-1]-cities[i])
                );
        }
        
        //Print out the last city's values
        System.out.println((cities[numCities-1] - cities[numCities-2]) + " " +
            (cities[numCities-1] - cities[0]));
    }
}