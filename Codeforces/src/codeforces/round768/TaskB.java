package codeforces.round768;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class TaskB {
    public static void main(String[] args) {
        InputStream inputStream;
        String str = "903316762502 354723010040 354723105411";
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
            LinkedList<Long> chain = new LinkedList<>();
            chain.add(in.nextLong());
            long l = in.nextLong();
            long r = in.nextLong();
            long i = 1;
            long count = 0;
            
            while(i <= r){
                LinkedList<Long> tmp = new LinkedList<>();
                
                while(!chain.isEmpty() && tmp.size() <= r){
                    long next = chain.remove();

                    if( next<= 1 && tmp.isEmpty() && tmp.size() <= (r-l+1)){
                        if(next==1 && i>=l && i<= r){
                            count++;
                        } 
                        
                        i++;
                    }else{
                        if(next ==1 || next == 0){
                            tmp.add(next);
                        }else{
                            tmp.addLast(next/2);
                            tmp.addLast(next%2);
                            tmp.addLast(next/2);
                        }
                    }
                }
                chain = tmp;
            }
            
            System.out.println(count);
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
