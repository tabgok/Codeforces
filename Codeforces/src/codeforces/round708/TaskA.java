/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round708;

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
            int numRows = in.nextInt();
            int numCols = in.nextInt();
            int numMoves = in.nextInt();
            
            HashSet<Point> points = new HashSet<>();
            
            for(int move=1;move<=numMoves;move++){
                Point p = new Point(in.nextInt(), in.nextInt());
                points.add(p);
                
                if(
                        (points.contains(new Point(p.x+1,p.y)) &&
                        points.contains(new Point(p.x+1,p.y+1)) && 
                        points.contains(new Point(p.x,p.y+1)) )
                        ||
                        (points.contains(new Point(p.x-1,p.y)) &&
                        points.contains(new Point(p.x-1,p.y-1)) && 
                        points.contains(new Point(p.x,p.y-1)) )
                        ||
                        (points.contains(new Point(p.x-1,p.y)) &&
                        points.contains(new Point(p.x-1,p.y+1)) && 
                        points.contains(new Point(p.x,p.y+1)) )
                        ||
                        (points.contains(new Point(p.x,p.y-1)) &&
                        points.contains(new Point(p.x+1,p.y-1)) && 
                        points.contains(new Point(p.x+1,p.y)) )
                        ){
                    System.out.println(move);return;
                }
            }
            
            System.out.println(0);
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
