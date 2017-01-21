/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round711;

/**
 *
 */import java.util.Scanner;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numRows = scan.nextInt();
        String[] rows = new String[numRows];
        
        boolean seated = false;
        
        for(int i=0;i<numRows;i++){
            rows[i] = scan.next();
        }
        
        for(int i=0;i<numRows && !seated;i++){
            String row = rows[i];
            
            if(row.contains("OO")){
                rows[i] = row.replaceFirst("OO","++");
                seated = true;
            }
        }
        
        if(seated){
            System.out.println("YES");
            for(String row : rows){
                System.out.println(row);
            }
        }else{
            System.out.println("NO");
        }
        
        
    }
}