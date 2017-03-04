package codeforces.round706;

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
            int numStrings = in.nextInt();
            long[] energy = new long[numStrings];
            String[] strings = new String[numStrings];
            for(int i=0;i<numStrings;i++){
                energy[i] = in.nextInt();
            }
            
            for(int i=0;i<numStrings;i++){
                strings[i] = in.next();
            }
            
            Long[] results = new Long[2];
            
            results[0] = (long)0;
            results[1] = energy[0];
            
            for(int i=1;i<numStrings;i++){
                Long[] newResults = new Long[2];
                newResults[0] = null;
                newResults[1] = null;
                String reverse = new StringBuilder(strings[i]).reverse().toString();
                
                if(results[0] != null && strings[i].compareTo(strings[i-1])>=0){
                    newResults[0] = results[0];
                }
                
                if(results[1]!= null && strings[i].compareTo(new StringBuilder(strings[i-1]).reverse().toString()) >= 0){
                    newResults[0] = (newResults[0] == null ? results[1] : Math.min(newResults[0],results[1]));
                }
                
                
                if(results[0] != null && reverse.compareTo(strings[i-1])>=0){
                    newResults[1] = results[0] + energy[i];
                }
                
                if(results[1] != null && reverse.compareTo(new StringBuilder(strings[i-1]).reverse().toString()) >= 0){
                    newResults[1] = (newResults[1] == null ? results[1]+energy[i] : Math.min(newResults[1],results[1] + energy[i]));
                }
                
                if(newResults[0] == null  &&  newResults[1] == null){
                    System.out.println(-1); return;
                }
                
                
                results[0] = newResults[0];
                results[1] = newResults[1];
            }
            
            if(results[0] == null){
                System.out.println(results[1]);
            }else if(results[1] == null){
                System.out.println(results[0]);
            }else{
                System.out.println(Math.min(results[0], results[1]));
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
