/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round766;

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
            int msgLength = in.nextInt();
            char[] message = in.next().toCharArray();
            int[] max = new int[26];
            
            for(int i=0;i<max.length;i++){
                max[i] = in.nextInt();
            }
            
            long numWays = 0;
            long maxSubstring = 0;
            long minSubstrings = 0;
            
            int[]maxRange = new int[msgLength];
            int l = 0;
            int r = 0;
            
            while(l < msgLength){
                
                int min = max[message[l]-'a'];
                while(r+1<msgLength && Math.min(min, max[message[r+1]-'a']) >= (r-l+2)){
                    min = Math.min(min,max[message[r+1]-'a']);
                    //System.out.println(min + " " + l + " " +(r+1));
                    r++;
                    
                }
                maxSubstring = Math.max(maxSubstring, r-l+1);
                maxRange[l] = r-l+1;
                l++;
                r = l;
                
            }
            
            long[] counts = new long[msgLength+1];
            counts[msgLength] = 1;
            counts[maxRange.length-1] = 1;
            
            for(int i=maxRange.length-1;i>=0;i--){
                long ways = 0;
                for(int j=1;j<=maxRange[i];j++){
                    ways += counts[i+j] % 1000000007;
                }
                counts[i] = ways% 1000000007;
            }
            int i=0;
            while(i < maxRange.length){
                i+= maxRange[i];
                minSubstrings++;
            }
            
            System.out.println(counts[0]);
            System.out.println(maxSubstring);
            System.out.println(minSubstrings);
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
