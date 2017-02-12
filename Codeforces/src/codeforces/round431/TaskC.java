/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round431;

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
public class TaskC {
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
            int target = in.nextInt();
            int k = in.nextInt();
            int d = in.nextInt();
            

            long[] vals = new long[101];
            for(int i=1;i<=k;i++){
                vals[i] = 1;
            }
            
            for(int i=1;i<vals.length;i++){
                for(int j=1;j<=k && i-j >= 0;j++){
                    vals[i] += vals[i-j];
                    vals[i] %= 1000000007;
                }
            }

            
            long count = vals[target];
            for(int i=0;i<vals.length;i++){
                vals[i] = 0;
            }
            for(int i=1;i<=d-1;i++){
                vals[i] = 1;
            }
            
            for(int i=1;i<vals.length;i++){
                for(int j=1;j<=d-1 && i-j >= 0;j++){
                    vals[i] += vals[i-j];
                    vals[i] %= 1000000007;
                }
            }
            
            count = (count+1000000007-vals[target])%1000000007;

            System.out.println(count);
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
