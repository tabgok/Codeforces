/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round550;

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
            String value = in.next();
            
            if(value.contains("0")){
                System.out.println("YES\n0");return;
            }else if(value.contains("8")){
                System.out.println("YES\n8");return;
            }
            
            if(value.length() == 2){
                int val = Integer.parseInt(value);
                if(val%8 == 0){
                    System.out.println("YES\n"+val);return;
                }
            }
            
            
            for(int a=0;a<value.length()-2;a++){
                for(int b=a+1;b<value.length()-1;b++){
                    for(int c=b+1;c<value.length();c++){
                        int valA = (value.charAt(a)-'0')*10 + (value.charAt(b)-'0');
                        int valB = (value.charAt(a)-'0')*10 + (value.charAt(c)-'0');
                        int valC = (value.charAt(b)-'0')*10 + (value.charAt(c)-'0');
                        int valD = (value.charAt(a)-'0')*100+(value.charAt(b)-'0')*10 + (value.charAt(c)-'0');
                        
                        
                        if(valA%8==0){
                            System.out.println("YES\n" + valA); return;
                        }else if(valB%8==0){
                            System.out.println("YES\n" + valB); return;
                        }else if(valC%8==0){
                            System.out.println("YES\n" + valC); return;
                        }else if(valD%8==0){
                            System.out.println("YES\n" + valD); return;
                        }
                    }
                }
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
    }
}
