/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round450;

/**
 *
 */
import java.util.Scanner;
import java.util.LinkedList;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numChildren = scan.nextInt();
        int numCandies = scan.nextInt();
        
        LinkedList<child> children = new LinkedList<>();
        
        for(int i=0;i<numChildren;i++){
            children.addLast(new child(scan.nextInt(), i+1));
        }
        
        while(children.size() > 1){
            child c = children.removeFirst();
            c.desire -= numCandies;
            if(c.desire > 0){
                children.addLast(c);
            }
        }
        
        System.out.println(children.get(0).number);
    }
}

class child{
    int desire = 0;
    int number = 0;
    
    public child(int d, int n){
        desire = d;
        number = n;
    }
}