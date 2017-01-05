/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round476;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
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
            char[] sent = in.next().toCharArray();
            char[] received = in.next().toCharArray();
            LinkedList<position> plays = new LinkedList<>();
            
            //Determine actual end position
            int pos = 50;
            for(char c : sent){
                if(c == '+'){
                    pos++;
                }else{
                    pos--;
                }
            }
            int actualEnd = pos;
            
            //Calculate the spread of resultant positions
            int[] positions = new int[100];
            
            positions[50] = 1;
            
            
            
            for(char c : received){
                int[] newPositions = new int[100];
                for(int i=0;i<100;i++){
                    if(positions[i] >= 1){
                        switch (c) {
                            case '+':
                                newPositions[i+1] += positions[i];
                                break;
                            case '-':
                                newPositions[i-1] += positions[i];
                                break;
                            default:
                                newPositions[i+1] += positions[i];
                                newPositions[i-1] += positions[i];
                                break;
                        }
                    }
                }
                positions = newPositions;
            }
            
            double result = positions[actualEnd]*1.0/Arrays.stream(positions).sum();
            
            System.out.println(result);
        }
    }
    
    static class position{
        int pos;
        int index;
        public position(int pos, int index){
            this.pos = pos;
            this.index = index;
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
