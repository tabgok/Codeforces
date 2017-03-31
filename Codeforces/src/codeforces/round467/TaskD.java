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
import java.util.LinkedList;
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
            int numWords = in.nextInt();
            String[] words = new String[numWords];
            HashMap<String, Synonym> synonyms = new HashMap<>();
            
            for(int word=0;word<numWords;word++){
                words[word] = in.next().toLowerCase();
                if(!synonyms.containsKey(words[word])){
                    synonyms.put(words[word], new Synonym(words[word]));
                }
            }
            
            int numPairs = in.nextInt();
            
            //Read in the synonyms and created a bi-directional graph (parent/child)
            for(int pair=0;pair<numPairs;pair++){
                String word = in.next().toLowerCase();
                String synonym = in.next().toLowerCase();
                
                if(!synonyms.containsKey(word)){
                    synonyms.put(word, new Synonym(word));
                }
                
                if(!synonyms.containsKey(synonym)){
                    synonyms.put(synonym, new Synonym(synonym));
                }
                
                if(word.equals(synonym)){ continue; }
                Synonym s = synonyms.get(synonym);
                Synonym w = synonyms.get(word);
                
                s.parents.add(w);
                w.children.add(s);
            }
            
            
            
            LinkedList<Synonym> visitedOrder = new LinkedList<>();
            HashSet<Synonym> visited = new HashSet<>();
            
            for(Synonym r : synonyms.values()){
                LinkedList<Synonym> toVisit = new LinkedList<>();
                if(visited.contains(r)){continue; }
                toVisit.add(r);
                visited.add(r);
                
                while(!toVisit.isEmpty()){
                    Synonym next = toVisit.getFirst();
                    
                    //If I am a leaf or the end of a cycle...
                    if(visited.containsAll(next.children)){
                        visitedOrder.addFirst(next);
                        toVisit.removeFirst();
                        continue;
                    }
                    
                    for(Synonym child : next.children){
                        if(!visited.contains(child)){
                            toVisit.addFirst(child);
                            visited.add(child);
                        }
                    }
                }
                
            }
            
            //System.out.println(visitedOrder);
            visited = new HashSet<>();
            LinkedList<HashSet<Synonym>> connectedSets = new LinkedList<>();
            
            for(Synonym s : visitedOrder){
                LinkedList<Synonym> toVisit = new LinkedList<>();
                if(visited.contains(s)){ continue; }
                //System.out.println(s);
                toVisit.add(s);
                visited.add(s);
                connectedSets.add(new HashSet<>());
                connectedSets.getLast().add(s);
                
                while(!toVisit.isEmpty()){
                    Synonym next = toVisit.getFirst();
                    
                    boolean added = false;
                    for(Synonym parent : next.parents){
                        if(!visited.contains(parent)){
                            //System.out.println("\t"+parent);
                            added = true;
                            visited.add(parent);
                            toVisit.addFirst(parent);
                            connectedSets.getLast().add(parent);
                        }
                    }
                    if(added){continue;}
                    toVisit.removeFirst();
                }
            }
            
            HashMap<Synonym, Synonym> replacements = new HashMap<>();
            
            for(HashSet<Synonym> s : connectedSets){
                //System.out.println(s);
                int minSize = Integer.MAX_VALUE;
                int minRs = Integer.MAX_VALUE;
                for(Synonym syn : s){
                    if(syn.minRs < minRs){
                        minRs = syn.minRs;
                        minSize = syn.minSize;
                    }else if(syn.minRs == minRs){
                        minSize = Math.min(syn.minSize, minSize);
                    }
                }
                Synonym replacement = s.iterator().next();
                //System.out.println("The replacement is: " + replacement);
                for(Synonym syn : s){
                    replacements.put(syn, replacement);
                    syn.minSize = minSize;
                    syn.minRs = minRs;
                    for(Synonym parent : syn.parents){
                        parent.children.removeAll(s);
                        if(parent!=replacement){
                            replacement.parents.add(parent);
                            parent.children.add(replacement);
                        }
                    }
                    
                    for(Synonym child : syn.children){
                        child.parents.removeAll(s);
                        if(replacement != child){
                            replacement.children.add(child);
                            child.parents.add(replacement);
                        }
                    }
                }
                //System.out.println(s+"\n");
            }
            
            
            
            visited = new HashSet<>();
            for(Synonym r : synonyms.values()){
                LinkedList<Synonym> toVisit = new LinkedList<>();
                if(visited.contains(r)){ continue; }
                toVisit.add(r);
                visited.add(r);
                
                while(!toVisit.isEmpty()){
                    Synonym next = toVisit.getFirst();
                    //System.out.println(toVisit);
                    //System.out.println("\n"+next);
                    //System.out.println(next.children);
                    
                    //If I am a leaf or the end of a cycle...
                    if(visited.containsAll(next.children)){
                        for(Synonym parent : next.parents){
                            if(parent.minRs > next.minRs){
                                parent.minRs = next.minRs;
                                parent.minSize = next.minSize;
                                //System.out.println( parent + " a-> " + next);
                            }else if(parent.minRs == next.minRs){
                                parent.minSize = Math.min(next.minSize, parent.minSize);
                                //System.out.println( parent + " b-> " + next);
                            }
                        }
                        toVisit.removeFirst();
                        continue;
                    }
                    
                    for(Synonym child : next.children){
                        if(!visited.contains(child)){
                            toVisit.addFirst(child);
                            visited.add(child);
                        }else{
                            if(next.minRs > child.minRs){
                                next.minRs = child.minRs;
                                next.minSize = child.minSize;
                                //System.out.println(next  + " c-> " + child);
                            }else if(next.minRs == child.minRs){
                                next.minSize = Math.min(child.minSize, next.minSize);
                                //System.out.println(next + " d-> " + child);
                            }
                        }
                    }
                }
            }
            
            long numRs = 0;
            long size = 0;
            visited.clear();
            connectedSets.clear();
            
            
            for(String word : words){
                Synonym w = synonyms.get(word);
                if(replacements.containsKey(w)){
                    w = replacements.get(w);
                }
                numRs += w.minRs;
                size += w.minSize;
            }
            
            System.out.println(numRs + " " + size);
            
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