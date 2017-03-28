package codeforces.round446;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class TaskA {
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
            long[] nums = new long[n+1];
            
            for(int i=0;i<n;i++){
                nums[i] = in.nextInt();
            }
            nums[n] = Long.MAX_VALUE;
            if(n==2 && nums[1] != 1){
                System.out.println(2);
            }else if(n==1){
                System.out.println(1);
            }else if(n==2){
                System.out.println(1);
            }
            
            int l=0;
            int r=2;
            int badCount =0;
            int maxRange = 0;
            int badPos =0;
            while(l < n){
                badCount = 0;
                badPos = n;
               
                while(r<n){
                    if(nums[l] >= nums[l+1] && nums[r] <= nums[r-1] ){
                        maxRange = Math.max(r-l, maxRange);
                        badPos = r-1;
                        break;
                    }else if(badCount == 0 && nums[r] <= nums[r-1] && nums[r+1]-nums[r-1] > 1){
                        badCount = 1;
                        badPos = r;
                    }else if((badCount == 0 && nums[r] <= nums[r-1] && nums[r+1]-nums[r-1] <= 1)){
                        maxRange = Math.max(r-l+1, maxRange);
                        break;
                    }else if(badCount == 1 && nums[r] <= nums[r-1]){
                        maxRange = Math.max(r-l, maxRange);
                        break;
                    }
                   
                    //System.out.println(l+" " + r +" ("+badCount+")");
                    maxRange = Math.max(maxRange, r-l+1);
                    r++;
                }
                l = badPos;
                //System.out.println(l);
                r=l+2;
            }
            
            System.out.println(maxRange);
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
/**
 * 424238336 
 * 649760493 
 * 681692778 
 * 714636916 
 * 719885387 
 * 804289384 
 * 846930887 
 * 957747794 
 * 596516650 
 * 189641422
 */