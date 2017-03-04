package codeforces.round129;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class TaskE {
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
            int n = in.nextInt();
            int m = in.nextInt();
            int numMoves = in.nextInt();
            
            
            if(n < 3 || m < 3){
                System.out.println(0); return;
            }
            
            long[] memory = new long[1001];
            long[][]dp = new long[numMoves+1][1001];
            
            for(int i=1;i<memory.length;i++){
                memory[i] = ((i*(i+1)/2)%1000000007 + memory[i-1])%1000000007;
            }
            for(int i=0;i<1001;i++){
                dp[0][i] = 1;
            }
            
            for(int move=1;move<=numMoves;move++){
                long sum = 0;
                for(int size=3;size<1001;size++){
                    sum += dp[move-1][size-2]%1000000007;
                    dp[move][size] = (sum+dp[move][size-1])%1000000007;
                }
            }
            
            long moveCount = (dp[numMoves][n]*dp[numMoves][m])%1000000007;
            System.out.println(moveCount);
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
