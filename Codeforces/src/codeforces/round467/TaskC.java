package codeforces.round467;

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
        String str = "20 5 3\n" +
"96 46 67 36 59 95 88 43 92 58 1 31 69 35 36 77 56 27 3 23";
        if(str == null){
            inputStream = System.in;
        }else{
            inputStream = new ByteArrayInputStream(str.getBytes());
        }
        //7 11 18
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
            int numElements = in.nextInt();
            int numPairs = in.nextInt();
            
            int[] nums = new int[numInts];
            
            for(int i=0;i<numInts;i++){
                nums[i] = in.nextInt();
            }
            
            int[] sums = new int[numInts+1];
            
            for(int i=1;i<sums.length;i++){
                sums[i] = nums[i-1]+sums[i-1];
            }
            /*
            for(int i : nums){
                System.out.print(i+" " );
            }System.out.println();
            
            for(int i : sums){
                System.out.print(i+" " );
            }System.out.println();
            */
            long total = 0;
            int r = numInts;
            int l = r+1-numElements;
            int[] sums2 = new int[numInts+1];
            
            for(int i=1;i+numElements-1<=numInts;i++){
                sums2[i] = sums[i+numElements-1] - sums[i-1];
                //System.out.println(i+" "+sums2[i]);
            }
            
            
            for(int j=0;j+(numPairs)*numElements<=numInts;j++){
                //System.out.println(j+(numPairs-1)*numElements);
                long temp = 0;
                for(int i=0;i<numPairs;i++){
                    //System.out.print((1+j+i*numElements)+" ");
                    System.out.print(sums2[j+i*numElements+1]+" ");
                    temp += sums2[j+i*numElements+1];
                }System.out.println();
                total = Math.max(total, temp);
                
            }
            
            System.out.println(total);
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
