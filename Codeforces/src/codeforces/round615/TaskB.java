/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round615;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
            int numPictures = in.nextInt();
            
            Integer[]pictures = new Integer[numPictures];
            
            for(int i=0;i<numPictures;i++){
                pictures[i] = in.nextInt();
            }
            
            long happyCount = 0;
            
            while(pictures.length!=0){
                Arrays.sort(pictures);
                ArrayList<Integer> nextRound = new ArrayList<>();
                boolean allEqual = true;
                for(int i=0;i<pictures.length-1;i++){
                    if(pictures[i] < pictures[i+1]){
                        happyCount++;
                        allEqual = false;
                    }else{
                        nextRound.add(pictures[i]);
                    }
                }
                
                if(!allEqual){
                    Integer[] nextRoundArray = new Integer[nextRound.size()];
                    pictures = nextRound.toArray(nextRoundArray);
                }else{
                    pictures = new Integer[0];
                }
            }
            
            System.out.println(happyCount);
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
