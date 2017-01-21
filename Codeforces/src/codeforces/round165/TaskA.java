/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round165;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
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
            int numPoints = in.nextInt();
            
            HashSet<Point> points = new HashSet<>();
            int[] maxX = new int[2002];
            int[] maxY = new int[2002];
            int[] minX = new int[2002];
            int[] minY = new int[2002];
            
            for(int i=0;i<=2000;i++){
                maxX[i] = Integer.MIN_VALUE;
                minX[i] = Integer.MAX_VALUE;
                maxY[i] = Integer.MIN_VALUE;
                minY[i] = Integer.MAX_VALUE;
            }
            for(int i=0;i<numPoints;i++){
                int x = in.nextInt()+1000;
                int y = in.nextInt()+1000;
                points.add(new Point(x, y));
                maxX[x] = Math.max(y, maxX[x]);
                minX[x] = Math.min(y, minX[x]);
                maxY[y] = Math.max(x, maxY[y]);
                minY[y] = Math.min(x, minY[y]);
            }
            
            HashSet<Point> results = new HashSet<>();
            
            for(Point p : points){
                //System.out.println( "("+p.x+","+p.y+")" + minX[p.x]+"->"+maxX[p.x]+ " " + minY[p.y]+"->"+maxY[p.y]);
                if(p.y < maxX[p.x] && p.y > minX[p.x] && p.x < maxY[p.y] && p.x > minY[p.y]){
                    results.add(p);
                }
            }
            
            System.out.println(results.size());
            
            
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