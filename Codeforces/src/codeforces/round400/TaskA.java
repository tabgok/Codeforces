package codeforces.round400;

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
            int numTests = in.nextInt();
            int[] indices = {1,2,3,4,6,12};
            int[] abc = {0b111111111111,0b111111,0b1111,0b111,0b11,0b1};
            for(int test=0;test<numTests;test++){
                char[] vals = in.next().toCharArray();
                
                int count = 0;
                String result = "";
                for(int x=0;x<indices.length;x++){
                    int h = indices[x];
                    int v = abc[x];
                    for(int i=0;i<h;i++){
                        int t = 0;
                        for(int j=0;j<12/h;j++){
                            t= t << 1;
                            t += vals[(12/h)*i+j] == 'X' ? 1 : 0;
                            //System.out.print(((12/h)*i+j)+" ");
                        }//System.out.println();
                        v = t&v;
                    }//System.out.println();
                    
                    if(v!=0){
                        count++;
                        result += h+"x"+(12/h)+" ";
                    }
                }
                System.out.println(count+ " " + result);
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
