/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round414;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
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
            int maxInt = in.nextInt();
            int length = in.nextInt();
            HashMap<Integer, HashSet<Integer>> divisors = new HashMap<>();
            long[][]results = new long[length+1][maxInt+1];
            
            
            for(int i=1;i<=maxInt;i++){
                divisors.put(i, new HashSet<>());
                for(int j=1;j<=i;j++){
                    if(i%j==0){
                        divisors.get(i).add(j);
                    }
                }
                
            }
            
            
            for(int i=1;i<=maxInt;i++){
                results[1][i] = 1;
            }
            
            for(int l=2;l<=length;l++){
                for(int c = 1;c<= maxInt;c++){
                    for(int j=c;j<=maxInt;j+=c){
                        results[l][j] += results[l-1][c];
                        results[l][j] %= 1000000007;
                    }
                   // for(int d : divisors.get(c)){
                    //    results[l][c] += results[l-1][d];
                    //    results[l][c] %= 1000000007;
                   // }
                    //results[l][c]++;
                }
            }
            
            /*for(int i=0;i<= length;i++){
                for(int j=0;j<=maxInt;j++){
                    System.out.print(results[i][j]+" ");
                }System.out.println();
            }*/
            
            long result = 0;
            
            for(int i=0;i<=maxInt;i++){
                result += results[length][i] ;
                result %= 1000000007;
            }
            
            System.out.println(result);
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
        
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}