package codeforces.round467;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class TaskD {
    static boolean print = false;
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
            int numWords = in.nextInt();
            String[] words = new String[numWords];
            HashMap<String, Synonym> synonyms = new HashMap<>();
            
            for(int word =0;word<numWords;word++){
                String w = in.next().toLowerCase();
                words[word] = w;
                if(!synonyms.containsKey(w)){
                    synonyms.put(w, new Synonym(w));
                }
            }
            //Create the graph
            int numPairs = in.nextInt();
            for(int pair=0;pair<numPairs;pair++){
                String parent = in.next().toLowerCase();
                String child = in.next().toLowerCase();
                
                if(!synonyms.containsKey(parent)){
                    synonyms.put(parent, new Synonym(parent));
                }
                
                if(!synonyms.containsKey(child)){
                    synonyms.put(child, new Synonym(child));
                }
                if(!child.equals(parent)){
                    synonyms.get(child).parents.add(synonyms.get(parent));
                    synonyms.get(parent).children.add(synonyms.get(child)); 
                }
            }
            
            
            
            //Find the strongly connected components
            //print = words[0].equals("r") && words[1].equals("r") && words[2].equals("r") && words[3].equals("r") ;
            //Go down by children...
            LinkedList<Synonym> order = new LinkedList<>();
            HashSet<Synonym> visited = new HashSet<>();
            LinkedList<Synonym> queue = new LinkedList<>();
            HashMap<Synonym, Iterator> iters = new HashMap<>();
            
            for(Synonym s : synonyms.values()){
                if(visited.contains(s)){ continue; }
                queue.add(s);
                visited.add(s);
                while(!queue.isEmpty()){
                    Synonym next = queue.getFirst();
                    
                    if(!iters.containsKey(next)){
                        iters.put(next, next.children.iterator());
                    }
                    Iterator<Synonym> iter = iters.get(next);
                    if(iter.hasNext()){
                        Synonym child = iter.next();
                        if(!visited.contains(child)){
                            visited.add(child);
                            queue.addFirst(child);
                            continue;
                        }
                    }else{
                        //We have explored all children
                        order.addFirst(next);
                        queue.removeFirst();
                    }
                    
                }
            }
            
            
            
            LinkedList<HashSet<Synonym>> components = new LinkedList<>();
            visited = new HashSet<>();
            queue = new LinkedList<>();
            iters = new HashMap<>();
            //Then up by parents...
            for(Synonym s : order){
                if(visited.contains(s)){ continue; }
                components.addLast(new HashSet<>());
                queue.add(s);
                visited.add(s);
                while(!queue.isEmpty()){
                    Synonym next = queue.getFirst();
                    components.getLast().add(next);
                    
                    if(!iters.containsKey(next)){
                        iters.put(next, next.parents.iterator());
                    }
                    Iterator<Synonym> iter = iters.get(next);
                    if(iter.hasNext()){
                        Synonym parent = iter.next();
                        if(!visited.contains(parent)){
                            queue.addFirst(parent);
                            visited.add(parent);
                        }
                    }else{
                        queue.removeFirst();
                    }
                }
            }
            
            //Convert the nodes into a super node with minimum value
            for(HashSet<Synonym> h : components){
                int minSize = Integer.MAX_VALUE;
                int minRs = Integer.MAX_VALUE;
                
                for(Synonym s : h){
                    if(s.minRs < minRs){
                        minRs = s.minRs;
                        minSize = s.minSize;
                    }else if(s.minRs == minRs){
                        minSize = Math.min(minSize, s.minSize);
                    }
                }
                
                Synonym replace = h.iterator().next();
                
                for(Synonym s : h){
                    if(s == replace){ continue; }
                    replace.parents.addAll(s.parents);
                    replace.children.addAll(s.children);
                    synonyms.put(s.word, replace);
                }
                replace.children.remove(replace);
                replace.parents.remove(replace);
            }
            
            //Now do depth-first search and update
            visited = new HashSet<>();
            queue = new LinkedList<>();
            iters = new HashMap<>();
            
            //Update from child on the way down and update parent on the return
            for(Synonym s : synonyms.values()){
                if(visited.contains(s)){ continue; }
                
                queue.addFirst(s);
                visited.add(s);
                while(!queue.isEmpty()){
                    Synonym next = queue.getFirst();
                    if(!iters.containsKey(next)){
                        iters.put(next, next.children.iterator());
                    }
                    Iterator<Synonym> iter = iters.get(next);
                    if(iter.hasNext()){
                        Synonym child = iter.next();
                        if(!visited.contains(child)){
                            visited.add(child);
                            queue.addFirst(child);                            
                        }else{
                            if(child.minRs < next.minRs){
                                next.minRs = child.minRs;
                                next.minSize = child.minSize;
                            }else if(child.minRs == next.minRs){
                                next.minSize = Math.min(next.minSize, child.minSize);
                            }
                        }
                    }else{
                        queue.removeFirst();
                        
                        //Update all the parents
                        for(Synonym parent : next.parents){
                            if(next.minRs < parent.minRs){
                                parent.minRs = next.minRs;
                                parent.minSize = next.minSize;
                            }else if(next.minRs == parent.minRs){
                                parent.minSize = Math.min(parent.minSize, next.minSize);
                            }
                        }
                    }   
                }
            }
            
            long rCount = 0;
            long length = 0;
            for(String w : words){
                rCount += synonyms.get(w).minRs;
                length += synonyms.get(w).minSize;
            }
            
            
            System.out.println(rCount + " " + length);
        }
    }
    private static void println(Object s){
        if(print){
            System.out.println(s.toString());
        }
    }
    
    private static void print(Object s){
        if(print){
            System.out.println(s.toString());
        }
    }
    private static void println(){
        if(print){
            System.out.println();
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

class Synonym{
    HashSet<Synonym> children = new HashSet<>();
    HashSet<Synonym> parents = new HashSet<>();
    String word;
    int minSize = 0;
    int minRs = 0;
    
    public Synonym(String word){
        this.word = word;
        minSize = word.length();
        for(char c : word.toCharArray()){
            if(c == 'r' || c== 'R'){
                minRs++;
            }
        }
    }
    
    @Override
    public String toString(){
       return word + " " + minSize + " " + minRs;
    }
}