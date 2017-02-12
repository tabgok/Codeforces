/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round433;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter; 
import java.util.Collections;
import java.util.PriorityQueue;
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
            int numStones = in.nextInt();
            long[] stones = new long[numStones+1];
            long[] orderedStones = new long[numStones+1];
            PriorityQueue<Long> sorting = new PriorityQueue<>();
            
            for(int i=1;i<=numStones;i++){
                long val = in.nextInt();
                stones[i] = val + stones[i-1];
                sorting.add(val);
            }
            
           
            //1,000,000,000
            int numQuestions = in.nextInt();
            
            for(int i=1;i<=numStones;i++){
                orderedStones[i] = sorting.poll() + orderedStones[i-1];
            }
            
            StringBuilder sb = new StringBuilder();
            
            for(int question=0;question<numQuestions;question++){
                int type = in.nextInt();
                int l = in.nextInt();
                int r = in.nextInt();
                
                if(type == 1)
                    sb.append(stones[r] - stones[l-1]);
                else{
                    sb.append(orderedStones[r] - orderedStones[l-1]);
                }
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
