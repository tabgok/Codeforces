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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
            int numVertices = in.nextInt();
            int maxCats = in.nextInt();
            int count = 0;
            HashMap<Integer, Vertex> vertices = new HashMap<>();
            
            for(int i=1;i<=numVertices;i++){
                
                vertices.put(i, new Vertex(in.nextInt()));
            }
            
            for(int i=0;i<numVertices-1;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                
                vertices.get(a).children.add(vertices.get(b));
                vertices.get(b).children.add(vertices.get(a));
            }
            
            HashSet<Vertex> visited = new HashSet<>();
            LinkedList<Vertex> queue = new LinkedList<>();
            
            queue.addLast(vertices.get(1));
            visited.add(vertices.get(1));
            while(!queue.isEmpty()){
                Vertex next = queue.removeFirst();
                boolean isParent = false;
                
                for(Vertex v : next.children){
                    if(!visited.contains(v)){
                        isParent = true;
                        visited.add(v);
                        if(v.consecutiveCats != 0){
                            v.consecutiveCats += next.consecutiveCats;
                        }
                        
                        if(v.consecutiveCats <= maxCats){
                            queue.addLast(v);
                        }
                    }
                }
                
                if(!isParent){
                    count++;
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

class Vertex{
    int consecutiveCats = 0;
    HashSet<Vertex> children = new HashSet<>();
    
    public Vertex(int numCats){
        this.consecutiveCats = numCats;
    }
}