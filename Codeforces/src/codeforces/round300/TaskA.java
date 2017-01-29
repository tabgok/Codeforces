/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round300;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
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
            int size = in.nextInt();
            LinkedList<Integer> negs = new LinkedList<>();
            LinkedList<Integer> pos = new LinkedList<>();
            LinkedList<Integer> zeros = new LinkedList<>();
            zeros.add(0);
            
            for(int i=0;i<size;i++){
                int next = in.nextInt();
                if(next < 0){
                    negs.add(next);
                }else if(next > 0){
                    pos.add(next);
                }
            }

            if(negs.size() >= 3 ){
                pos.add(negs.removeFirst());
                pos.add(negs.removeFirst());
            }
            
            if(negs.size()%2 == 0){
                zeros.add(negs.removeFirst());
            }
            
            System.out.print(negs.size() + " ");
            for(int i : negs.toArray(new Integer[0])){
                System.out.print(i+" ");
            }
            System.out.println();

            
            System.out.print(pos.size() + " " );
            for(int i : pos.toArray(new Integer[0])){
                System.out.print(i+" ");
            }
            System.out.println();
            System.out.print(zeros.size() + " ");
            for(int i : zeros.toArray(new Integer[0])){
                System.out.print(i+" ");
            }
            System.out.println();
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
