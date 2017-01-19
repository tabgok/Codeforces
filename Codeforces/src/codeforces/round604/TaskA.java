/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round604;

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
            double totalScore = 0;
            
            int[] submitTimes = new int[5];
            int[] wrongSubmissions = new int[5];
            int[]scores = {500, 1000, 1500, 2000, 2500};
            
            
            for(int i=0;i<5;i++){
                submitTimes[i] = in.nextInt();
            }
            
            for(int i=0;i<5;i++){
                wrongSubmissions[i] = in.nextInt();
            }
            
            int succ = in.nextInt();
            int unsucc = in.nextInt();
            
            
            for(int i=0;i<5;i++){
                totalScore += calcScore(scores[i], submitTimes[i], wrongSubmissions[i]);
            }
            
            totalScore += 100*succ - 50*unsucc;
            
            System.out.println((int)totalScore);
            
        }
    }
    
    static double calcScore(int maxScore, int minute, int wrongSubmissions){
        return (double)Math.max(0.3*maxScore, (1-minute/250.0)*maxScore - 50*wrongSubmissions);
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
