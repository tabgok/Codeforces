/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round558;

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

/**
 *
 */
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
            int numTrees = in.nextInt();
            
            Tree[] trees = new Tree[numTrees+1];
            trees[numTrees] = new Tree(0, 0);
            boolean print = false;
            
            
            for(int i=0;i<numTrees;i++){
                long pos = in.nextInt();
                long apples = in.nextInt();
                trees[i] = new Tree(pos, apples);
                if(numTrees == 92 && i==0 && pos == -99150){
                    print = true;
                }   
            }
            
            Arrays.sort(trees, new Comparator<Tree>(){
                @Override
                public int compare(Tree o1, Tree o2) {
                    return Long.compare(o1.pos, o2.pos);
                } 
            });
            
            int mid = -1;
            for(int i=0;i<=numTrees;i++){
                if(trees[i].pos == 0){
                    mid = i;
                }
            }
            
            int l = mid;
            int r = mid;
            
            long count = 0;
            for(int i=0;i<numTrees;i++){
                if(r < numTrees && l > 0 ){
                    count += trees[++r].count;
                    count += trees[--l].count;
                }else if( r < numTrees){
                    System.out.println(count + trees[r+1].count);
                    return;
                }else if( l > 0){
                    System.out.println(count + trees[l-1].count);
                    return;
                }else{
                    System.out.println(count);
                    return;
                }
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
    }
}

class Tree{
    long pos;
    long count;

    public Tree(long pos, long count){
        this.pos = pos;
        this.count = count;

    }
}
