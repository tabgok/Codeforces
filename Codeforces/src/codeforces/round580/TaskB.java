/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.round580;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TaskB {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
//        String str = "5 100\n" +
//"0 7\n" +
//"11 32\n" +
//"99 10\n" +
//"46 8\n" +
//"87 54";
//        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(1, in, out);
        out.close();
    }
    

    static class Solver {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int numFriends = in.nextInt();
            int maxDiff = in.nextInt();
            
            Friend[] friends = new Friend[numFriends];
            
            for(int i=0;i<numFriends;i++){
                friends[i] = new Friend(in.nextInt(), in.nextInt());
            }
            
            Arrays.sort(friends, new Comparator<Friend>(){
                @Override
                public int compare(Friend o1, Friend o2) {
                    return o1.money - o2.money;
                } 
            });
            
            long maxSum = 0;
            long sum = 0;
            
            int l=0;
            int r=0;
            
            while(r < numFriends){
                
                while(friends[r].money - friends[l].money >= maxDiff){
                    sum -= friends[l].factor;
                    l++;
                }
                sum += friends[r].factor;
                
                maxSum = Math.max(maxSum, sum);
                r++;
            }
            
            System.out.println(maxSum);
        }
    }
    
    static class Friend{
        public int money;
        public int factor;
        
        public Friend(int money, int factor){
            this.money = money;
            this.factor = factor;
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
