/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.round735;

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
            int numCells = in.nextInt();
            int jumpDistance = in.nextInt();
            
            char[] line = in.next().toCharArray();
            
            int gPos = -1, tPos=-1;
            
            for(int i=0;i<line.length;i++){
                if(line[i] == 'G'){
                    gPos = i;
                }else if(line[i] == 'T'){
                    tPos = i;
                }
            }
            
            if(gPos > tPos){
                int tmp = tPos;
                tPos = gPos;
                gPos = tmp;
            }
            
            while(gPos <= tPos){
                if(line[gPos] == '#'){
                    System.out.println("NO");
                    return;
                }else if(gPos == tPos){
                    System.out.println("YES");
                    return;
                }else{
                    gPos += jumpDistance;
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
