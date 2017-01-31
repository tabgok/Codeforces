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
            int numBarriers = in.nextInt();
            int trackLength = in.nextInt();
            
            int[] kefa = new int[numBarriers];
            int[] sasha = new int[numBarriers];
            int[] trackA = new int[numBarriers]; // contains the distance between
            int[] trackB = new int[numBarriers];
            

            int last = in.nextInt();
            int first = last;
            for(int i=1;i<numBarriers;i++){
                int next = in.nextInt();
                int distance = next-last;
                trackA[i] = distance;
                last = next;
            }
            trackA[0] = trackLength-last+first;
            
            last = in.nextInt();
            first = last;
            for(int i=1;i<numBarriers;i++){
                int next = in.nextInt();
                int distance = next-last;
                trackB[i] = distance;
                last=next;
            }
            trackB[0] = trackLength-last+first;
            
            for(int i=0;i<numBarriers;i++){
                boolean equivalent = true;
                for(int j=0;j<numBarriers && equivalent;j++){
                    if(trackA[j] != trackB[(j+i)%numBarriers]){
                        equivalent = false;
                    }
                }
                if(equivalent){System.out.println("YES"); return;}
            }
            
            System.out.println("NO");
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
