/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round588;

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
            long number = in.nextLong();
            
            
            HashMap<Long, Long> divisors = new HashMap<>();
            
            for(long i=2;i<Math.sqrt(number)+1;i++){
                while(number%i == 0){
                    if(!divisors.containsKey(i)){
                        divisors.put(i, (long)0);
                    }
                    divisors.put(i,divisors.get(i)+1);
                    number /= i;
                }
            }
            
            if(!divisors.containsKey(number)){
                divisors.put(number, (long)0);
            }
            
            divisors.put(number, divisors.get(number)+1);
           
            long maxDivisor = 1;
            //divisors.forEach((s,l) -> System.out.println(s+": " + l));
            for(long divisor : divisors.keySet()){
                maxDivisor *= divisor;
            }
            System.out.println(maxDivisor);
            
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
