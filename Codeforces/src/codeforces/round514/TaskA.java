/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round514;

/**
 *
 */
import java.util.Scanner;
import java.lang.Math;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        char[] num = scan.next().toCharArray();
        int index = 0;
        
        if(num[0] == '9'){
            index = 1;
        }else{
            index = 0;
        }
        
        for(int i=index;i<num.length;i++){
            int cur = num[i] - '0';
            
            int val = Math.min(cur, 9-cur);
            
            num[i] = (char)((char)val+'0');
        }
        
        
        System.out.println(num);
    }
}
