/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round427;

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
            int numPrisoners = in.nextInt();
            int maxCrime = in.nextInt();
            int numToTransfer = in.nextInt();
            
            int[] prisoners = new int[numPrisoners];
            int numTooHigh = 0;
            long numWays = 0;
            
            int prisoner = 0;
            while(prisoner < numToTransfer){
                prisoners[prisoner] = in.nextInt();
                if(prisoners[prisoner] > maxCrime){
                    numTooHigh++;
                }
                prisoner++;
            }
            
            numWays += numTooHigh==0 ? 1 : 0;
            
            while(prisoner < numPrisoners){
                
                prisoners[prisoner] = in.nextInt();
                if(prisoners[prisoner] > maxCrime){
                    numTooHigh++;
                }
                
                if(prisoners[prisoner-numToTransfer] > maxCrime){
                    numTooHigh--;
                }
                if(numTooHigh == 0){
                    numWays++;
                }
                prisoner++;
            }
            
            System.out.println(numWays);
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
