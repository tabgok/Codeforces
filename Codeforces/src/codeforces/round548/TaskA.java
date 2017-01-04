/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.round548;

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
 * @author teague
 */
public class TaskA {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
    //    String str = "saddastavvat\n" + "2";
        //InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(1, in, out);
        out.close();
    }
    

    static class Solver {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String text = in.next();
            
            int numPalindromes = in.nextInt();
            int length = text.length() / numPalindromes;

            if(length == 0 || text.length() % numPalindromes != 0){
                System.out.println("NO");
                return;
            }
            for(int i=0;i+length<=text.length();i+=length){
                int l = i;
                int r = i+length-1;
                
                while(l < r){
                    if(text.charAt(l) == text.charAt(r)){
                        l++;
                        r--;
                    }else{
                        System.out.println("NO");
                        return;
                    }
                }
            }
            
            System.out.println("YES");
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
