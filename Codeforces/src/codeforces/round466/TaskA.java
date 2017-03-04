package codeforces.round466;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
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
            int numInts = in.nextInt();
            long[] nums = new long[numInts];
            int[] l = new int[numInts];
            int[] r = new int[numInts];
            
            for(int i=0;i<numInts;i++){
                nums[i] = in.nextLong();
            }
            HashMap<Integer, Integer> indices = new HashMap<>();
            
            l[0] = 0;
            //System.out.print(0+" ");
            for(int i=1;i<numInts;i++){
                if(nums[i] > nums[i-1]){
                    l[i] = l[i-1];
                }else{
                    l[i] = i;
                }
                //System.out.print(l[i]+" ");
            }//System.out.println();
            
            r[numInts-1] = numInts-1;
            //System.out.print((numInts-1)+" ");
            for(int i=numInts-1;i>0;i--){
                if(nums[i] > nums[i-1]){
                    r[i-1] = r[i];
                }else{
                    r[i-1] = i-1;
                }
                //System.out.print(r[i-1]+" ");
            }//System.out.println();
            
            int max = 0;
            
            for(int i=0;i<numInts;i++){
                max = Math.max(max, r[i]-l[i]+1);
                
                if(i+2<numInts && nums[i+2]-nums[i] > 1){
                    max = Math.max(max, r[i+2]-l[i]+1);
                }
                
                if(l[i]>0 || r[i] < numInts-1){
                    max = Math.max(max, r[i]-l[i]+2);
                }
            }
            
            System.out.println(max);

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
