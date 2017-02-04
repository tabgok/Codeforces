/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round546;

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
public class TaskD {
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
            int numGames = in.nextInt();
            long[] results = new long[5000001];
            int[] vals = new int[5000001];
            for(int i=1;i<5000001;i++){
                vals[i] = i;
            }
            for(int i=2;i<=5000000;i++){
                if(vals[i] != 1){
                    for(int d=i;d<results.length;d+=i){
                        while(vals[d] > 1 && vals[d]%i==0){
                            vals[d] /= i;
                            results[d]++;
                        }
                    }
                }
            }
            
            for(int i=2;i<=5000000;i++){
                results[i] = results[i]+results[i-1];
            }
            
            StringBuilder sb = new StringBuilder();
            
            for(int game=0;game<numGames;game++){
                int a = in.nextInt();
                int b = in.nextInt();
                long rounds = results[a] - results[b];
                
                sb.append(rounds);
                sb.append("\n");
            }
            
            System.out.println(sb.toString());
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
