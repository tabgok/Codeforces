/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round546;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 */
public class TaskE {
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
            int numRoads = in.nextInt();
            HashMap<Integer, City> cities = new HashMap<>();
            
            for(int i=1;i<=numCities;i++){
                City city = new City(i);
                city.numWarriors = in.nextInt();
                cities.put(i, city);
            }
            
            for(int i=1;i<=numCities;i++){
                cities.get(i).targetWarriors = in.nextInt();
            }
            
            for(int i=0;i<numRoads;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                cities.get(a).edges.add(b);
                cities.get(b).edges.add(a);
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


class City{
    int numWarriors;
    int targetWarriors;
    int id;
    HashSet<Integer> edges = new HashSet<>();
    
    public City(int id){
        this.id = id;
    }
}