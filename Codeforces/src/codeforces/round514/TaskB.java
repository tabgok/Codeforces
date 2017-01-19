/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round514;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 *
 */
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
            int numSoldiers = in.nextInt();
            int gunX = in.nextInt();
            int gunY = in.nextInt();
            
            HashSet<Slope> slopes = new HashSet<>();
            int vertical = 0;
            
            for(int i=0;i<numSoldiers;i++){
                int soldierX = in.nextInt()-gunX;
                int soldierY = in.nextInt()-gunY;
                
                if(soldierX == 0){
                    vertical = 1;
                }else{
                    Slope s = new Slope(soldierY, soldierX);
                    slopes.add(s);
                }
            }
            
            System.out.println(slopes.size() + vertical);
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
    }
}

class Slope{
    int rise;
    int run;
    public Slope(int rise, int run){
        
        if(rise == 0){
            run = 1;
        }else if(run == 0){
            rise = 1;
        }
        int d = gcd(Math.abs(rise), Math.abs(run));
        this.rise = rise / d;
        this.run = run / d;
        if(this.rise < 0){
            this.run *= -1;
            this.rise *= -1;
        }
    }
    
    private static int gcd(int a, int b) {
        while (b > 0)
        {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    

    @Override
    public int hashCode(){
        return Objects.hash(rise, run);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Slope other = (Slope) obj;
        if (this.rise != other.rise) {
            return false;
        }
        if (this.run != other.run) {
            return false;
        }
        return true;
    }
    
    
}