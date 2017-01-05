/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round549;

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
            int height = in.nextInt();
            int width = in.nextInt();
            
            char[][] matrix = new char[height][width];
            
            for(int i=0;i<height;i++){
                matrix[i] = in.next().toCharArray();
            }
            
            int numFaces = 0;
            
            for(int h=0;h<height-1;h++){
                boolean f = false;
                boolean a = false;
                boolean c = false;
                boolean e = false;
                
                for(int w=0;w<width-1;w++){
                    
                    f = matrix[h][w] == 'f' || matrix[h+1][w] == 'f' || matrix[h][w+1] == 'f' || matrix[h+1][w+1] == 'f';
                    a = matrix[h][w] == 'a' || matrix[h+1][w] == 'a' || matrix[h][w+1] == 'a' || matrix[h+1][w+1] == 'a';
                    c = matrix[h][w] == 'c' || matrix[h+1][w] == 'c' || matrix[h][w+1] == 'c' || matrix[h+1][w+1] == 'c';
                    e = matrix[h][w] == 'e' || matrix[h+1][w] == 'e' || matrix[h][w+1] == 'e' || matrix[h+1][w+1] == 'e';
                    
                    if(f && a && c && e){
                        numFaces++;
                    }
                }
                
                
            }
            
            System.out.println(numFaces);
            
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
