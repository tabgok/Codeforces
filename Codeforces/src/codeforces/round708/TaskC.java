/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round708;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
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
            int numGhosts = in.nextInt();
            int candleTime = in.nextInt();
            int reqCandles = in.nextInt();
            LinkedList<Integer> candleTimes = new LinkedList<>();
            
            //There's no way to light enough candles
            if(candleTime < reqCandles){
                System.out.println(-1);return;
            }
            int minCandles = 0;
            int firstTime = in.nextInt();
            for(int i=0;i<reqCandles;i++){
                //System.out.println("Addint First at: " + (firstTime-i));
                candleTimes.addFirst(firstTime - i);
                minCandles++;
            }
            
            for(int i=1;i<numGhosts;i++){
                int time = in.nextInt();
                while(!candleTimes.isEmpty() && candleTimes.peekFirst()+candleTime < time+1){
                    candleTimes.removeFirst();
                }
                
                for(int c=reqCandles-candleTimes.size();c>0;c--){
                    candleTimes.add(time-c+1);
                    //System.out.println("Adding at: " + (time-c+1));
                    minCandles++;
                }
            }
            
            System.out.println(minCandles);
            
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
