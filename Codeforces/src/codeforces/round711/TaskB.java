/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round711;

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
            int size = in.nextInt();
            
            if(size == 1){
                System.out.println(1); return;
            }
            int[][] matrix = new int[size][size];
            long[] rowSums = new long[size];
            long[] colSums = new long[size];
            
            long targetSum = 0;
            int emptyRow = 0;
            int emptyCol = 0;
            long primeDiagSum = 0;
            long secondaryDiagSum = 0;
            
            for(int row=0;row<size;row++){
                for(int col=0;col<size;col++){
                    int val = in.nextInt();
                    matrix[col][row] = val;
                    if(val == 0){
                        emptyRow = row;
                        emptyCol = col;
                    }
                    if(row == col){
                        primeDiagSum += val;
                    }
                    
                    if(row == size-col-1){
                        secondaryDiagSum += val;
                    }
                    colSums[col]+=val;
                    rowSums[row]+=val;
                }
            }
            
            targetSum = rowSums[(emptyRow+1)%size];
            
            long neededRow = targetSum - rowSums[emptyRow];
            long neededCol = targetSum - colSums[emptyCol];
            long neededPrimeDiag = 0;
            long neededSecondaryDiag = 0;
            //Check the rows
            for(int row=0;row<size;row++){
                if(row!=emptyRow && rowSums[row]!=targetSum){
                    //System.out.println("1: " + neededRow + " " + neededCol + " " + neededPrimeDiag + " " + neededSecondaryDiag);
                    //System.out.println(emptyRow + " " + emptyCol);
                    
                    System.out.println(-1);return; 
                }
            }
            
            //Check the cols
            for(int col=0;col<size;col++){
                if(col!=emptyCol && colSums[col]!=targetSum){
                    //System.out.println("2: " + neededRow + " " + neededCol + " " + neededPrimeDiag + " " + neededSecondaryDiag);
                    //System.out.println(col + " " + emptyRow + " " + emptyCol);
                    System.out.println(-1);return; 
                }
            }
            
            //Check the main diag
            if(emptyRow == emptyCol){
                neededPrimeDiag = targetSum - primeDiagSum;
            }else if(targetSum != primeDiagSum){System.out.println(-1); return;}
            else{neededPrimeDiag = neededRow;}
            //System.out.println(emptyRow + " " + emptyCol);
            if(emptyRow == size - emptyCol - 1){
                neededSecondaryDiag = targetSum - secondaryDiagSum;
                //System.out.println(targetSum + " " + primeDiagSum);
            }else if(targetSum != secondaryDiagSum){System.out.println(-1); return;}
            else{
                neededSecondaryDiag = neededRow;
            }
            
            if(neededRow > 0 && neededRow == neededCol && neededRow == neededPrimeDiag && neededRow == neededSecondaryDiag){
                System.out.println(neededRow);
            }else{
                //System.out.println("3: " + neededRow + " " + neededCol + " " + neededPrimeDiag + " " + neededSecondaryDiag);
                //System.out.println(emptyRow + " " + emptyCol);
                System.out.println(-1);
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
