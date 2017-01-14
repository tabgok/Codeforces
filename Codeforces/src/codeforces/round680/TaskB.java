/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.round680;

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
            int numCities = in.nextInt();
            int residence = in.nextInt();
            
            int[] cities = new int[numCities+2];
            
            for(int i=1;i<=numCities;i++){
                cities[i] = in.nextInt();
            }
            
            int caught = 0;
            
            for(int distance = 0;distance <= numCities;distance++){
                int badGuys = 0;
                int l = residence - distance;
                int r = residence + distance;
                if(l > 0 && cities[l] == 1){
                    badGuys++;
                }
                
                if( r <= numCities && cities[r] == 1){
                    badGuys++;
                }
                
                if( (l == r || l<=0 || r > numCities) && badGuys >= 1){
                    caught++;
                }else if(badGuys == 2){
                    caught += 2;
                }
            }
            
            System.out.println(caught);
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
