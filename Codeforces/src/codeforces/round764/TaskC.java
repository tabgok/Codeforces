/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round764;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
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
            int numVertices = in.nextInt();
            HashMap<Integer, Node> nodes = new HashMap<>();
            HashMap<Integer, Integer> colors = new HashMap<>();
            
            for(int i=1;i<=numVertices;i++){
                nodes.put(i, new Node(i));
            }
            
            for(int i=0;i<numVertices-1;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                nodes.get(a).edges.add(b);
                nodes.get(b).edges.add(a);
            }
            
            int minColor = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            int minNode = 0;
            for(int i=1;i<=numVertices;i++){
                int color = in.nextInt();
                if(!colors.containsKey(color)){
                    colors.put(color, 0);
                }
                colors.put(color, colors.get(color)+1);
                if(colors.get(color) < min){
                    minColor = color;
                    min = colors.get(color);
                    minNode = i;
                }
                nodes.get(i).color = color;
            }
            
            //We need exactly one node which branches to all colors
            if(colors.size() == 1){
                System.out.println("YES\n1"); return;
            }
            
            HashSet<Node> rootset = new HashSet<>();
            for(Node n : nodes.values()){
                for(int edge : n.edges){
                    if(nodes.get(edge).color != n.color){
                        if(rootset.size() == 0){
                            rootset.add(n);
                            rootset.add(nodes.get(edge));
                        }else{
                            if(!rootset.contains(n) && !rootset.contains(nodes.get(edge))){
                                System.out.println("NO"); return;
                            }else{
                                if(rootset.contains(n)){
                                    rootset = new HashSet<>();
                                    rootset.add(n);
                                }else{
                                    rootset = new HashSet<>();
                                    rootset.add(nodes.get(edge));
                                }
                            }
                        }
                    }
                }
            }
            
            
            
            System.out.println("YES");
            System.out.println(rootset.iterator().next().id);
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

class Node{
    HashSet<Integer> edges = new HashSet<>();
    int id;
    int color;
    
    public Node(int id){
        this.id = id;
    }
}