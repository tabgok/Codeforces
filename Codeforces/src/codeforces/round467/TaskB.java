package codeforces.round467;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


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
            int types = in.nextInt();
            int opponents = in.nextInt();
            int maxDiff = in.nextInt();
            int numFriends = 0;
            
            int[] armies = new int[opponents];
            
            for(int opponent=0;opponent<opponents;opponent++){
                armies[opponent] = in.nextInt();
            }
            int fedorArmy = in.nextInt();
            
            for(int i=0;i<opponents;i++){
                int diffInt = armies[i] ^ fedorArmy;
                if(countOnes(diffInt) <= maxDiff){
                    numFriends++;
                }
            }
            
            System.out.println(numFriends);
        }
    }
    
    static int countOnes(int i){
        int counter = 0;
        while(i > 0){
            if((i&0x1) == 0x1){
                counter++;
            }
            i=i>>1;
        }
        
        return counter;
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
