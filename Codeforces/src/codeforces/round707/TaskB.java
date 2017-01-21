/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round707;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
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
            int numCities = in.nextInt();
            int numRoads = in.nextInt();
            int numStorehouses = in.nextInt();
            
            if(numStorehouses == 0){
                System.out.println(-1);
                return;
            }
            
            HashMap<Integer, City> cities = new HashMap<>();
            
            for(int i=1;i<=numCities;i++){
                cities.put(i, new City(i));
            }
            
            for(int i=0;i<numRoads;i++){
                City cityA = cities.get(in.nextInt());
                City cityB = cities.get(in.nextInt());
                int distance = in.nextInt();
                
                
                if(!cityA.neighbours.containsKey(cityB.num) || cityA.neighbours.get(cityB.num) > distance){
                    cityA.neighbours.put(cityB.num, distance);
                    cityB.neighbours.put(cityA.num, distance);
                }
            }
            
            long minDistance = Long.MAX_VALUE;
            
            HashSet<City> storehouses = new HashSet<>();
            
            //Move storehouses out
            for(int i=0;i<numStorehouses;i++){
                storehouses.add(cities.remove(in.nextInt()));
            }
            
            for(City c : storehouses){
                for(int d : c.neighbours.keySet()){
                    if(cities.containsKey(d)){
                        minDistance = Math.min(minDistance, c.neighbours.get(d));
                    }
                }
            }
            
            if(minDistance == Long.MAX_VALUE){ minDistance = -1; }
            System.out.println(minDistance);
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


class City{
    int num;
    boolean hasFlour = false;
    
    //City : Distance
    HashMap<Integer, Integer> neighbours = new HashMap<>();
    
    public City(int num){
        this.num = num;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(num);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final City other = (City) obj;
        if (this.num != other.num) {
            return false;
        }
        return true;
    }
}