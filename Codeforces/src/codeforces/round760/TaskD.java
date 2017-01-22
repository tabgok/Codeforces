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
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class TaskD {
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
            int numTrips = in.nextInt();
            
            int[]trips = new int[numTrips];
            
            for(int i=0;i<numTrips;i++){
                trips[i] = in.nextInt();
            }
            
            int[] minCosts = new int[numTrips];
            long charged = 0;
            
            for(int trip=0;trip<numTrips;trip++){
                int time = trips[trip];
                int ninetyAgo = Arrays.binarySearch(trips,time-90);
                if(ninetyAgo < 0){
                    ninetyAgo++;
                    ninetyAgo*=-1;
                    ninetyAgo--;
                }
                
                int fourteenAgo = Arrays.binarySearch(trips, time-1440);
                if(fourteenAgo < 0){
                    fourteenAgo++;
                    fourteenAgo*=-1;
                    fourteenAgo--;
                }
                
                int ninetyMin = 0;
                if(ninetyAgo >= 0){
                    ninetyMin = minCosts[ninetyAgo];
                }
                int fourteenMin = 0;
                if(fourteenAgo >= 0){
                    fourteenMin = minCosts[fourteenAgo];
                }
                int ninetyCost = 50 + ninetyMin;
                
                int oneCost = 20;
                if(trip!=0){
                    oneCost += minCosts[trip-1];
                }
                int dayCost = 120 + fourteenMin;
                
                
                minCosts[trip] = Math.min(Math.min(ninetyCost, oneCost), dayCost);
                System.out.println(minCosts[trip] - charged);
                charged = minCosts[trip];
            }
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
