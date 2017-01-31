/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round732;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
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
            long[] meals = new long[3];
            
            meals[0] = in.nextLong();
            meals[1] = in.nextLong();
            meals[2] = in.nextLong();
            
            
            while(meals[0] < meals[1] || meals[0] < meals[2]){
                long tmp = meals[0];
                meals[0] = meals[1];
                meals[1] = meals[2];
                meals[2] = tmp;
            }
            
            //bookend
            if(meals[0] > meals[1] &&  meals[0] > meals[2]){
                meals[1]++;
                meals[2]++;
            }else if(meals[0] == meals[1] && meals[0] > meals[2]){
                meals[2]++;
            }else if(meals[0] == meals[2] && meals[0] > meals[1]){
                meals[1]++;
            }
            
            BigInteger missed = BigInteger.ZERO;
            
            missed = missed.add(BigInteger.valueOf(meals[0]));
            missed = missed.add(BigInteger.valueOf(meals[0]));
            missed = missed.subtract(BigInteger.valueOf(meals[1]));
            missed = missed.subtract(BigInteger.valueOf(meals[2]));
            
            
            System.out.println(missed);
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
