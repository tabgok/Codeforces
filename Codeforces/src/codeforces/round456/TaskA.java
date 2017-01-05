/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round456;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
import java.util.Comparator;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numLaptops = scan.nextInt();
        Laptop[] laptops = new Laptop[numLaptops];
        
        for(int i=0;i<numLaptops;i++){
            laptops[i] = new Laptop(scan.nextInt(), scan.nextInt());
        }
        
        Arrays.sort(laptops, new Comparator<Laptop>(){
           public int compare(Laptop a, Laptop b){
               return Integer.compare(a.price, b.price);
           } 
        });
        
        for(int i=0;i<laptops.length-1;i++){
            if(laptops[i].quality > laptops[i+1].quality){
                System.out.println("Happy Alex");
                return;
            }
        }
        
        System.out.println("Poor Alex");
    }
}

class Laptop{
    int price;
    int quality;
    
    public Laptop(int p, int q){
        price = p;
        quality = q;
    }
}