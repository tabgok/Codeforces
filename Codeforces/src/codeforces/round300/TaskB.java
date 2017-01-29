/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces.round300;

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
            int numStudents = in.nextInt();
            int numPairs = in.nextInt();
            HashSet<Integer> students = new HashSet<>();
            HashMap<Integer, HashSet<Integer>> teams = new HashMap<>();
            
            for(int i=1;i<=numStudents;i++){
                teams.put(i, new HashSet());
                teams.get(i).add(i);
                students.add(i);
            }
            
            for(int i=0;i<numPairs;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                students.remove(a);
                students.remove(b);
                
                HashSet<Integer> newTeam = teams.get(a);
                newTeam.addAll(teams.get(b));
                for(int t : newTeam){
                    teams.put(t, newTeam);
                }
                teams.put(b, newTeam);
                
                if(newTeam.size() > 3){
                    System.out.println(-1); return;
                }
            }
            
            for(int i=1;i<=numStudents;i++){
              //  System.out.println(i+": " + teams.get(i));
            }
            
            
            for(int i=1;i<=numStudents;i++){
                HashSet<Integer>team = teams.get(i);
                if(team != null && team.size() == 2){
                    if(students.isEmpty()){
                        System.out.println(-1); return;
                    }
                    int student = students.iterator().next();
                    team.add(student);
                    students.remove(student);
                    teams.put(student, null);
                }
            }
            
            if(students.size()%3 != 0){
                System.out.println(-1); return;
            }
            
            for(int i=1;i<=numStudents;i++){
                HashSet<Integer>team = teams.get(i);
                if(team != null && team.size() == 3){
                    for(int member : team){
                        System.out.print(member+" ");
                        teams.put(member, null);
                    }System.out.println();
                }
            }
            int counter = 0;
            for(int student : students){
                System.out.print(student+ " " );
                counter++;
                if(counter%3 == 0){
                    System.out.println();
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
        
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
