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
import java.util.ArrayList;
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
            int passLength = in.nextInt();
            int numChars = in.nextInt();
            char[][] strings = new char[passLength][numChars];
            int[] symbols = new int[passLength];
            int[] letters = new int[passLength];
            int[] numbers = new int[passLength];
            
            for(int i=0;i<passLength;i++){
                strings[i] = in.next().toCharArray();
                symbols[i] = Integer.MAX_VALUE;
                letters[i] = Integer.MAX_VALUE;
                numbers[i] = Integer.MAX_VALUE;
            }
            
            for(int i=0;i<passLength;i++){
                for(int j=0;j<numChars;j++){
                    if(strings[i][j] >= '0' && strings[i][j] <= '9'){
                        letters[i] = Math.min(letters[i], Math.min(j, numChars-j));
                        
                    }else if(strings[i][j] >='a' && strings[i][j] <='z'){
                        numbers[i] = Math.min(numbers[i], Math.min(j, numChars - j));
                    }else{
                        symbols[i] = Math.min(symbols[i], Math.min(j, numChars-j));
                    }
                    /*System.out.println(letters[i]);
                    System.out.println(numbers[i]);
                    System.out.println(symbols[i]);*/
                }
            }
            
            long minMoves = Long.MAX_VALUE;
            for(int a =0;a<passLength;a++){
                for(int b=0;b<passLength;b++){
                    for(int c=0;c<passLength;c++){
                        if(a==b || a==c || b==c){
                            continue;
                        }
                        long cost = (long)letters[a] + (long)numbers[b] + (long)symbols[c];
                        minMoves = Math.min(minMoves, cost);
                    }
                }
            }
            
            System.out.println(minMoves);
            
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
