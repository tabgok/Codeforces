/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round546;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
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
            int numCards = in.nextInt();
            String playerA = "";
            String playerB = "";
            HashSet<String> visitedStates = new HashSet<>();

            int count = in.nextInt();
            for(int i=0;i<count;i++){
                playerA += (in.nextInt()-1);
            }

            count = in.nextInt();
            for(int i=0;i<count;i++){
                playerB += (in.nextInt()-1);
            }
           
            int moves = 0;//System.out.println(playerA + " " + playerB);
            while(playerA.length() > 0 && playerB.length() > 0 && !visitedStates.contains(playerA+" "+playerB)){
                visitedStates.add(playerA+" "+playerB);
                if(playerA.charAt(0) > playerB.charAt(0)){
                    playerA += playerB.charAt(0);
                    playerA += playerA.charAt(0);
                }else{
                    playerB += playerA.charAt(0);
                    playerB += playerB.charAt(0);
                }//System.out.println(playerA + " " + playerB);
               
                playerB = playerB.substring(1);
                playerA = playerA.substring(1); 
                moves++;
           }
        
            if(playerA.length() != 0 && playerB.length() != 0){
                System.out.println(-1); return;
            }
            
            System.out.println(moves+ " " + (playerA.length() == 0 ? 2 : 1));
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
