/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round300;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 */
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
        long a = in.nextInt();
            long b = in.nextInt();
            long length = in.nextInt();
            
            long numA = length, numB = 0;
            long count = 0;
            setupFactorials((int)length);
            
            for(long i=0;i<=length;i++){
                //System.out.println("Checking: " + (a*(numA-i)+b*(numB+i)));
                if(isGood(a*(numA-i)+b*(numB+i), a, b)){
                    //System.out.println(length + " " + a + " " +(numA-i) + " " + b + " " + (numB+i) + " " + getFactorial((int)(numA-i)));
                    count += getFactorial((int)(numA-i));
                    count %= 1000000007;
                }
            }
            System.out.println(count);
        }
    }
    
    static long[] chooses;
    static long[] factorials;
    static void setupFactorials( int N ) {
        //System.out.println(N+1);
        
        chooses = new long[N+1];
        factorials = new long[N+1];
        factorials[0] = 1;
        long n = 1;
        int mod = 1000000007;
        for(int i=1;i<=N;i++){
            n = (n*i) % mod;
            factorials[i] = n;
        }
        //System.out.println(factorials[N]);
        for (int k = 0; k <= N;k++){//(N+1)/2; k++) {
            //System.out.print(factorials[N] + " " + factorials[k] + " " + factorials[N-k]);
            //System.out.println(" " + modPow((factorials[k]*factorials[N-k])%mod, mod-2));
            chooses[k] = (factorials[N]*modPow((factorials[k]*factorials[N-k])%mod, mod-2))%mod;
            chooses[N-k] = chooses[k];
        }
    }

    static int modPow(long base, int exp){
        long r = 1;
        
        while(exp > 0){
            if((exp&1) == 1){
                r = r*base % 1000000007;
                //System.out.println("R: " + r);
            }
            base = base*base % 1000000007;
            exp >>=  1;
        }
        return (int)r;
    }
    
    static long getFactorial(int n){
        return chooses[n];
    }

    static boolean isGood(long num, long a, long b){
        while(num > 0){
            if(num%10 != a && num%10 != b){
                return false;
            }
            num/=10;
        }
        return true;
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
