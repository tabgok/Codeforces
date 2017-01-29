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
import java.util.Arrays;
import java.util.Comparator;
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
            int numBeacons = in.nextInt();
            Beacon[] beacons = new Beacon[numBeacons];
            
            for(int beacon=0;beacon<numBeacons;beacon++){
                beacons[beacon] = new Beacon(in.nextInt(), in.nextInt());
            }
            
            Arrays.sort(beacons, new Comparator<Beacon>(){
                @Override
                public int compare(Beacon o1, Beacon o2) {
                    return Integer.compare(o1.loc, o2.loc);
                }
            });
            
            int[] destroyed = new int[numBeacons+1];
            int minDestroyed = Integer.MAX_VALUE;
            
            for(int i=1;i<destroyed.length;i++){
                int power = beacons[i-1].power;
                int loc = beacons[i-1].loc;
                int index = Arrays.binarySearch(beacons, new Beacon(loc-power,0), new Comparator<Beacon>(){
                    @Override
                    public int compare(Beacon o1, Beacon o2) {
                        return Integer.compare(o1.loc, o2.loc);
                    }
                    
                });
                if(index < 0){index = -1*(index+1);}index++;
               // System.out.println(loc+","+power+" => " + (loc-power) + " " + index);
                int numDestroyed = (i-index)+destroyed[index-1];
                destroyed[i] = numDestroyed;
                
            }
            
            /*for(int i=0;i<destroyed.length;i++){
                System.out.print(destroyed[i]+ " " );
            }System.out.println();*/
            
            for(int i=0;i<destroyed.length;i++){
                //System.out.print((numBeacons-i)+" ");
                minDestroyed = Math.min(minDestroyed, numBeacons-i + destroyed[i]);
            }//System.out.println();
            
            System.out.println(minDestroyed);
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

class Beacon{
    int loc;
    int power;
    
    public Beacon(int loc, int power){
        this.loc = loc;
        this.power = power;
    }
}
