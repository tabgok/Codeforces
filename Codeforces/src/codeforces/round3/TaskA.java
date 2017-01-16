/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round3;

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
            String src = in.next();
            String dst = in.next();
            
            int x1 = src.charAt(0)-'a';
            int y1 = src.charAt(1)-'0';
            
            int x2 = dst.charAt(0)-'a';
            int y2 = dst.charAt(1)-'0';
            
            int x_d = Math.abs(x1-x2);
            int y_d = Math.abs(y1-y2);
            
            int moves = 0;
            
            moves += Math.min(x_d, y_d);
            
            y_d-=moves;
            x_d-=moves;
            
            moves += x_d+y_d;
            System.out.println(moves);
            
            while(x1!=x2 || y1!=y2){
                if(x1<x2){
                    System.out.print("R");
                    x1++;
                }else if(x1>x2){
                    System.out.print("L");
                    x1--;
                }
                
                if(y1 < y2){
                    System.out.print("U");
                    y1++;
                }else if(y1 > y2){
                    System.out.print("D");
                    y1--;
                }
                
                System.out.println();
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
    }
}
