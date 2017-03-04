package codeforces.round129;

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
            char[][] board = new char[8][];
            
            for(int i=0;i<8;i++){
                board[i] = in.next().toCharArray();
            }
            
            //The goal is getting to any cell (0,X)
            
            HashSet<Point> nextLocations = new HashSet<>();
            nextLocations.add(new Point(7,0));
            int step = 1;
            
            while(step <= 8 & !nextLocations.isEmpty()){
                HashSet<Point> tmp = new HashSet<>();
                
                while(!nextLocations.isEmpty()){
                    Point current = nextLocations.iterator().next();

                    Point[] points = new Point[9];
                    points[0]= new Point(Math.max(current.x-1,0),Math.max(current.y-1,0));
                    points[1] = new Point(Math.max(current.x-1,0),Math.max(current.y,0));
                    points[2] = new Point(Math.max(current.x-1,0),Math.min(current.y+1,7));
                    points[3]= new Point(Math.max(current.x,0),Math.max(current.y-1,0));
                    points[4] = new Point(Math.max(current.x,0),Math.max(current.y,0));
                    points[5] = new Point(Math.max(current.x,0),Math.min(current.y+1,7));
                    points[6]= new Point(Math.min(current.x+1,7),Math.max(current.y-1,0));
                    points[7] = new Point(Math.min(current.x+1,7),Math.max(current.y,0));
                    points[8] = new Point(Math.min(current.x+1,7),Math.min(current.y+1,7));

                    for(Point p : points){
                        if(isValid(p, board)){
                            //System.out.println(p);
                            tmp.add(p);
                        }
                    }
                    nextLocations.remove(current);
                }
                step++;
                nextLocations = tmp;
                
                //Adjust the board
                for(int row=7;row>0;row--){
                    board[row] = board[row-1];
                }
                board[0] = "........".toCharArray();
            }
            
            if(step==9 && !nextLocations.isEmpty()){
                System.out.println("WIN");
            }else{
                System.out.println("LOSE");
            }
            
        }
        
        static boolean isValid(Point p, char[][] board){
            
            if(board[p.x][p.y] == 'S'){
                return false;
            }
            if(p.x<0 || p.y<0 || p.x>7 || p.y>7){
                return false;
            }
            
            if(p.x>0 && board[p.x-1][p.y] == 'S'){
                return false;
            }
            
            return true;
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
