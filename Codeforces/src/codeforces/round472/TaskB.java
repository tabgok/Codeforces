/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round472;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 */
public class TaskB {
    public static void main(String[] args) {
        InputStream inputStream;
        String str = null;
        if(str == null){
            inputStream = System.in;
        }else{
            inputStream = new ByteArrayInputStream(str.getBytes());
        }
        
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(1, in, out);
        out.close();
    }
    

    static class Solver {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int numPeople = in.nextInt();
            int maxCapacity = in.nextInt();
            
            int[]destinations = new int[2001];
            
            for(int i=0;i<numPeople;i++){
                destinations[in.nextInt()]++;
            }
            
            long time = 0;
            int curCapacity = 0;
            int curLocation = 1;
            
            int i=2000;
            
            while(i>0){
                while(i > 1 && destinations[i]==0){
                    
                    i--;
                }
                
                time += 2*(i-1);
                
                //Pickup as many people at the top as possible.
                while(i>0 && curCapacity != maxCapacity){
                    if(destinations[i] > 0){
                        int droppedOff = Math.min(maxCapacity-curCapacity, destinations[i]);
                        curCapacity += droppedOff;
                        destinations[i] -= droppedOff;
                    }else{
                        i--;
                    }
                }
                
                curCapacity = 0;
            }
            
            System.out.println(time);
        }
    }
    
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
