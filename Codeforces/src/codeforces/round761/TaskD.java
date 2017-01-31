/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round761;

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
            int length = in.nextInt();
            long minVal = in.nextInt();
            long maxVal = in.nextInt();
            long offset = 0;
            long[]a = new long[length];
            long[]p = new long[length];
            
            for(int i=0;i<length;i++){
                a[i] = in.nextLong();
            }
            
            for(int i=0;i<length;i++){
                p[i] = in.nextLong();
            }
            
            long[] b = new long[length];
            
            long min = Integer.MAX_VALUE;
            long max = Integer.MIN_VALUE;
            for(int i=0;i<length;i++){
                b[i] = p[i]-1 + a[i];
                min = Math.min(b[i], min);
                max = Math.max(b[i], max);
            }
            
            offset = Math.max(0,minVal - min);
            
            if(offset+max <= maxVal){
               for(int i=0;i<length;i++){
                    System.out.print((b[i]+offset) + " ");
                } System.out.println();
                return;
            }else{
                offset = Math.min(0, maxVal - max);
                if(offset+min >= minVal){
                    for(int i=0;i<length;i++){
                        System.out.print((b[i]+offset) + " ");
                    } System.out.println();
                    return;
                }
            }
            
            System.out.println(-1);
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
