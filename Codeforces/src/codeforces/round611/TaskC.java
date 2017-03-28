package codeforces.round611;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
            int numRows = in.nextInt();
            int numCols = in.nextInt();
            
            char[][] grid = new char[numRows][numCols];
            
            for(int i=0;i<numRows;i++){
                grid[i] = in.next().toCharArray();
            }
            
            int[][]rows = new int[numRows][numCols];
            
            for(int row=0;row<numRows;row++){
                for(int col=1;col<numCols;col++){
                    if(grid[row][col-1] == '.' && grid[row][col] == '.'){
                        rows[row][col] = 1+rows[row][col-1];
                    }else{
                        rows[row][col] = rows[row][col-1];
                    }
                }
            }
            
            int[][]cols = new int[numCols][numRows];
            for(int col=0;col<numCols;col++){
                for(int row=1;row<numRows;row++){
                    if(grid[row-1][col] == '.' && grid[row][col] == '.'){
                        cols[col][row] = 1+cols[col][row-1];
                    }else{
                        cols[col][row] = cols[col][row - 1];
                    }
                }
            }
            int numQueries = in.nextInt();
            
            for(int query =0;query<numQueries;query++){
                int r1 = in.nextInt()-1;
                int c1 = in.nextInt()-1;
                int r2 = in.nextInt()-1;
                int c2 = in.nextInt()-1;
                
                long sum = 0;
                
                for(int r=r1;r<=r2;r++){
                    sum += rows[r][c2] - rows[r][c1];
                }
                
                for(int c=c1;c<=c2;c++){
                    sum += cols[c][r2] - cols[c][r1];
                }
                
                System.out.println(sum);
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
