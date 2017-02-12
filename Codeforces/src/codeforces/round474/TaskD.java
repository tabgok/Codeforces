/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round474;

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
            int numTests = in.nextInt();
            int groupSize = in.nextInt();
            
            long[] memo = new long[1000001];
            
            for(int i=1;i<groupSize;i++){
                memo[i] = 1;
            }
            memo[groupSize]=2;
            
            for(int i=groupSize+1;i<memo.length;i++){
                memo[i] = memo[i-1] + memo[i-groupSize];
                
                //if(i%groupSize == 0){
                //    memo[i] += (2*(memo[i-groupSize]-2)+1000000007) % 1000000007;
               //}
                //if(i<=5){
                //    System.out.println(i+": " + memo[i]);
                //}
                memo[i] = memo[i]%1000000007;
            }
            
            for(int i=1;i<memo.length;i++){
                memo[i] = (memo[i]+memo[i-1]) % 1000000007;
            }
            //for(int i=0;i<20;i++){
            //    System.out.println(i+": " + memo[i]);
            //}
            
            for(int test=0;test<numTests;test++){
                int a = in.nextInt();
                int b = in.nextInt();
                //158897762
                //1000000007
                //266988
                //2147483648
                //    System.out.println(a+ " " + b + " " + memo[a-1] + " " + memo[b]);
                System.out.println((memo[b]-memo[a-1]+1000000007)%1000000007);
                
            }
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
