/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round606;

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
public class TaskA {
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
            int numBlue = in.nextInt();
            int numViolet = in.nextInt();
            int numOrange = in.nextInt();
            
            int targetBlue = in.nextInt();
            int targetViolet = in.nextInt();
            int targetOrange = in.nextInt();
            
            int requiredOrbs = Math.max(0, targetBlue-numBlue) +
                    Math.max(0, targetViolet-numViolet) +
                    Math.max(0, targetOrange-numOrange);
            
            int generatableOrbs = Math.max(0,numBlue-targetBlue)/2 +
                    Math.max(0, numOrange - targetOrange)/2 + 
                    Math.max(0, numViolet - targetViolet)/2;
            
            if(generatableOrbs >= requiredOrbs){
                System.out.println("Yes");
            }else{
                System.out.println("No");
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
