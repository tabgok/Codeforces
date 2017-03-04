package codeforces.round129;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class TaskD {
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
            String s = in.next();
            int length = s.length();
            int k = in.nextInt();
            //StringBuilder result = new StringBuilder();
            ArrayList<Integer> indices = new ArrayList<>();
            long current = 0;
            long[] sums = new long[26];

            for(int i=0;i<length;i++){
                indices.add(i);
                sums[s.charAt(i)-'a'] += length-i;
            }
            
            if(k > ((long)length * (length + 1)) / 2) {
                System.out.println("No such line.");
                return;
            }
            
           
            
            while (current < k && !indices.isEmpty()){
                //Find next character
                char i;
                for(i='a';i<='z';i++){
                    long sum = 0;
                    sum = sums[i-'a'];
                    if(current + sum < k){
                        current += sum;
                    }else{
                        break;
                    }
                }
                
                Arrays.fill(sums, 0);
                ArrayList<Integer> tmp = new ArrayList<>();
                if(i <= 'z'){
                    System.out.print(i);
                    
                    //Get next values
                    
                    for(int index : indices){
                        if(s.charAt(index) == i){
                            current++;
                            if(index+1 < length){
                                tmp.add(index+1);
                                sums[s.charAt(index+1)-'a'] += length-(index+1);
                            }
                        }
                    }
                }//System.out.println(i);System.out.println(indices);
                
                indices = tmp;
                //System.out.println(indices);
                //System.out.println(current+"/"+k);
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