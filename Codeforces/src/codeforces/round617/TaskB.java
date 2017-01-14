/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.round617;

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
 * @author teague
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
            int numPieces = in.nextInt();
            
            int[] bar = new int[numPieces];
            
            int firstNut = -1;
            int lastNut = -1;
            
            for(int i=0;i<numPieces;i++){
                bar[i] = in.nextInt();
                if(firstNut == -1 && bar[i] == 1){
                    firstNut = i;
                }
                
                if(bar[i] == 1){
                    lastNut = i;
                }
            }
            
            long numCuts = 1;
            
            int consecutiveZeros = 0;
            if(firstNut == -1){
                System.out.println(0);
                return;
            }
            
            for(int i=firstNut+1;i<=lastNut;i++){
                if(bar[i] == 0){
                    consecutiveZeros++;
                }else{
                    numCuts *= (long)(consecutiveZeros+1);
                    consecutiveZeros = 0;
                }
            }
            
            System.out.println(numCuts);
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
