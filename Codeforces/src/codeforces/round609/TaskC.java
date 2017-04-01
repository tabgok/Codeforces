package codeforces.round609;

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
            int numServers = in.nextInt();
            int[] taskCount = new int[numServers];
            long numSeconds = 0;
            
            long sum =0;
            for(int i=0;i<numServers;i++){
                taskCount[i] = in.nextInt();
                sum += taskCount[i];
            }
            
            long min = sum/numServers;
            
            long above = 0;
            long below = 0;
            
            for(int i=0;i<numServers;i++){
                if(taskCount[i] < min){
                    below += min - taskCount[i];
                }else if(taskCount[i] > min+1){
                    above += taskCount[i] - (min+1);
                }
            }
            
            numSeconds += below;
            above  = Math.max(0, above-below);
            numSeconds += above;
            System.out.println(numSeconds);
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
