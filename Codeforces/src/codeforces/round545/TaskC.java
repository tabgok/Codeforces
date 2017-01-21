/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round545;

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
            int numTrees = in.nextInt();
            
            Tree[] trees = new Tree[numTrees];
            
            for(int i=0;i<numTrees;i++){
                trees[i] = new Tree(in.nextInt(), in.nextInt());
            }
            
            int count = Math.min(numTrees, 2);
            trees[0].left = trees[0].right-trees[0].height;
            trees[numTrees-1].right = trees[numTrees-1].right+trees[numTrees-1].height;
            
            //Looking at the spaces in-between
            for(int tree=1;tree<numTrees-1;tree++){
                int treeFallLeft = trees[tree].left - trees[tree].height;
                int treeFallRight = trees[tree].right + trees[tree].height;
                
                //Try to fall left (if you can, do so)
                if(treeFallLeft > trees[tree-1].right){
                    trees[tree].left = trees[tree].right-trees[tree].height;
                    count++;
                }else if(treeFallRight < trees[tree+1].left){
                    //Try to fall right (if you can, do so)
                    trees[tree].right = trees[tree].left + trees[tree].height;
                    count++;
                }else{
                    //Do nothing - don't fall!
                }
            }
            
            System.out.println(count);
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
    int height;
    int left;
    int right;
    
    public Tree(int loc, int height){
        this.height = height;
        this.left = loc;
        this.right = loc;
    }
}