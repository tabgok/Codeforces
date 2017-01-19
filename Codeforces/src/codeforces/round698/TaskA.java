/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round698;

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
            int numDays = in.nextInt();
            
            long restDays = 0;
            
            // 0: Did nothing
            // 1: Did contest
            // 2: Did sport
            // 3: Did one or the other
            int lastDay = 0;
            
            for(int i=0;i<numDays;i++){
                int nextDay = in.nextInt();
                
                if(nextDay == 0){
                    restDays++;
                    lastDay = 0;
                }else if(nextDay == 1){
                    restDays += lastDay == 1 ? 1 : 0;
                    lastDay = lastDay==1 ? 0 : 1;
                }else if(nextDay == 2){
                    restDays += lastDay == 2 ? 1 : 0;
                    lastDay = lastDay==2 ? 0 : 2;
                }else if(nextDay == 3){
                    if(lastDay == 0 || lastDay == 3){ lastDay = 3; }
                    else if(lastDay == 1){ lastDay = 2; }
                    else if(lastDay == 2){ lastDay = 1; }
                }
            }
            
            System.out.println(restDays);
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
