package codeforces.round467;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
            int numValues = in.nextInt();
            int segmentSize = in.nextInt();
            int numPairs = in.nextInt();
            
            long[] values = new long[numValues+1];
            
            for(int i=1;i<=numValues;i++){
                values[i] = in.nextLong();
            }
            
            long[][]maxValues = new long[numPairs+1][numValues+1];
            
            for(int k=1;k<=numPairs;k++){
                long rollingSum = 0;
                for(int i=1;i<segmentSize;i++){
                    rollingSum += values[i];
                }
                
                for(int i=segmentSize;i<=numValues;i++){
                    rollingSum += values[i];
                    maxValues[k][i] = Math.max(rollingSum + maxValues[k-1][i-segmentSize], maxValues[k][i-1]);
                    rollingSum -= values[i-segmentSize+1];
                }
                
                //System.out.print(k+": ");
                //Arrays.stream(maxValues[k]).forEach(s -> System.out.print(s+" "));
                //System.out.println();
            }
            
            System.out.println(maxValues[numPairs][numValues]);
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
