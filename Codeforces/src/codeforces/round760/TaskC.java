/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round760;

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
            int numSkewers = in.nextInt();
            HashMap<Integer, Integer>nodes = new HashMap<>();
            
            for(int i=1;i<=numSkewers;i++){
                nodes.put(i, in.nextInt());
            }
            
            int numCycles = 0;
            for(int i=1;i<=numSkewers;i++){
                if(nodes.containsKey(i)){
                   int node = i;
                    numCycles++;

                    while(nodes.containsKey(node)){
                        int next = nodes.get(node);
                        nodes.remove(node);
                        node = next;
                    }
                }
            }
            
            int numSwaps = 0;
            for(int i=0;i<numSkewers;i++){
                if(in.next().equals("1")){
                    numSwaps++;
                }
            }
            
            int changes = (numSwaps+1)%2 + (numCycles == 1 ? 0 : numCycles);
            
            System.out.println(changes);
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
