/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round699;

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
            int numParticles = in.nextInt();
            
            int[] dirs = new int[numParticles];
            int[] pos = new int[numParticles];
            String dir = in.next();
            
            for(int i=0;i<numParticles;i++){
                dirs[i] = dir.charAt(i) == 'R' ? 1 : -1;
            }
            
            for(int i=0;i<numParticles;i++){
                pos[i] = in.nextInt();
            }
            
            int minTime = Integer.MAX_VALUE;
            
            for(int i=1;i<numParticles;i++){
                if(dirs[i] != -1 || dirs[i-1] != 1){
                    continue;
                }
                int time = (pos[i]-pos[i-1])/2;
                minTime = Math.min(time, minTime);
            }
            
            if(minTime == Integer.MAX_VALUE) minTime = -1;
            
            System.out.println(minTime);
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
