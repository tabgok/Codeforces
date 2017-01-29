/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round608;

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
            char[] a = in.next().toCharArray();
            char[] b = in.next().toCharArray();
            
            //0: will store sum of 1s
            //1: will store sum of 0s
            int[][] sumsB = new int[2][b.length+1];
            
            for(int index=1;index<=b.length;index++){
                int i=Math.max(0, index-1);
                sumsB[0][index] = sumsB[0][i]+(b[i]=='0' ? 0:1);
                sumsB[1][index] = sumsB[1][i]+(b[i]=='0' ? 1:0);
            }
            /*
            "11\n" +
            "0000";
            */
            long sum = 0;
            
            /*System.out.println();
            for(int i=0;i<=b.length;i++){
                System.out.println(sumsB[0][i] + " " + sumsB[1][i]);
            }*/
            for(int i=0;i<a.length;i++){
                int index = (a[a.length-1-i]-'0');
                //System.out.println((a.length-i-1)+": " + (sumsB[index][b.length-i]) + "-"+sumsB[index][a.length-i-1]);
                sum += (sumsB[index][b.length-i])-sumsB[index][a.length-i-1];
            }
            System.out.println(sum);
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
