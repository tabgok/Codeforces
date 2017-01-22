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
            long numBeds = in.nextInt();
            long numPillows = in.nextInt();
            long frodoPos = in.nextInt();
            
            numPillows -= numBeds;
            
            long frodoPillows = 1;
            
            long num = 1;
            
            long l = Math.max(0, num-frodoPos);
            long r = Math.max(0, frodoPos+(num-1)-numBeds);
            while(num<numBeds && num*num - l*(l+1)/2 - r*(r+1)/2 <= numPillows){
                //System.out.println(l + " " + r);
                num++;
                frodoPillows++;
                l = Math.max(0, num-frodoPos);
                r = Math.max(0, frodoPos+num-numBeds-1);
            }
            
            num--;l--;r--;
            numPillows -= num*num - l*(l+1)/2 - r*(r+1)/2;
            
            
            frodoPillows += numPillows/numBeds;

            System.out.println(frodoPillows);
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
