package codeforces.round208;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class TaskE {
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
            int numPeople = in.nextInt();
            Person[] people = new Person[numPeople+1];
            int[] idMap= new int[numPeople+1];
            people[0] = null;
            boolean print = false;
            long time = Instant.now().toEpochMilli();
            
            LinkedList<Person> roots = new LinkedList<>();
            
            for(int i=1;i<=numPeople;i++){
                people[i] = new Person(i);
                people[i].max = 1;
            }
            
            for(int i=1;i<=numPeople;i++){ 
               people[i].setParent(people[in.nextInt()]);
                if(people[i].parent == null){
                    roots.add(people[i]);
                }
                
            }
            print = false && (numPeople == 100000) && 
                    (people[1].parent == null) && 
                    (people[2].parent == people[1]) && 
                    (people[3].parent == people[1]) && 
                    (people[5].parent == people[3]) && 
                    (people[4].parent == people[2]);
            if(print){
                long time2 = Instant.now().toEpochMilli();
                System.out.println(time2-time);
                time = time2;
            }
            int counter = 0;
            LinkedList<Person> toVisit = new LinkedList<>();
            ArrayList<ArrayList<Integer>> heights = new ArrayList<>();
            
            for(Person p : roots){
                toVisit.add(p);
                p.height = 0;
                HashSet<Person> visited = new HashSet<>();
                while(!toVisit.isEmpty()){
                    Person current = toVisit.getFirst();
                    if(visited.contains(current)){
                        toVisit.removeFirst();
                        if(current.parent != null){
                            current.parent.max += current.max;
                        }
                        continue;
                    }
                    if(current.parent!=null){
                        current.height = current.parent.height+1;
                    }
                    visited.add(current);
                    if(heights.size() <= current.height){
                        heights.add(new ArrayList<>());
                    }
                    idMap[counter] = current.ID;
                    current.ID = counter++;
                    
                    heights.get(current.height).add(current.ID);
                    
                    toVisit.addAll(0,current.children);
                    
                }
            }
            
            //Arrays.stream(idMap).forEach(s -> System.out.print(s+" "));System.out.println();
            if(print){
                long time2 = Instant.now().toEpochMilli();
                System.out.println(time2-time);
                time = time2;
            }
            int questions = in.nextInt();
            StringBuilder sb = new StringBuilder();
            for(int question=0;question<questions;question++){
                int index = in.nextInt();
                Person person = people[index];
                int level = in.nextInt();
                //System.out.println("level: " + level + " vs " + person.height);
                if(level > person.height){
                    sb.append("0 ");
                    continue;
                }
                if(print && question%10000 == 0){
                    long time2 = Instant.now().toEpochMilli();
                    System.out.println(question+": " + (time2-time));
                    time = time2;
                }
                
                //int i;
                //for(i=0;i<level && person != null;i++){
                //    person = person.parent;
                //}
                index = Collections.binarySearch(heights.get(person.height-level), person.ID);
                //System.out.println("index: " + index);
                if(index < 0){
                    index = (index+1)*-1-1;
                }else{
                    index++;
                }
                //System.out.print(person.ID+" ");
                person = people[idMap[heights.get(person.height-level).get(index)]];
                //System.out.println(person.ID);
                level = person.height+level;
                
                int l = person.ID;
                int r = person.ID+person.max+1;
                
                
                int left = Collections.binarySearch(heights.get(level), l);
                int right = Collections.binarySearch(heights.get(level), r);

                if(left < 0){
                    left = (left+1)*-1;
                }
                if(right < 0){
                    right = (right+1)*-1;
                }
               sb.append(Math.max(0,right-left-1));
               sb.append(" ");
            }
            
            System.out.println(sb);
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


class Person{
    int ID;
    int height;
    int max=0;
    Person parent;
    LinkedList<Person> children = new LinkedList<>();
    public Person(int ID){
        this.ID = ID;
    }
    
    public void setParent(Person p){
        parent = p;
        if(parent != null){
            parent.children.add(this);
        }
        
    }
}