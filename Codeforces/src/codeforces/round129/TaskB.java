package codeforces.round129;

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
            int numLaces = in.nextInt();
            HashMap<Integer, Student> students = new HashMap<>();
            
            //Create the students
            for(int student=1;student<=numStudents;student++){
                students.put(student, new Student(student));
            }
            
            //Tie the students
            for(int lace=1;lace<=numLaces;lace++){
                int studentA = in.nextInt();
                int studentB = in.nextInt();
                
                students.get(studentA).tie(students.get(studentB));
            }
            
            
            boolean changed = true;
            int numGroups = 0;
            while(changed){
                changed = false;
                LinkedList<Student> toRemove = new LinkedList<>();
                
                //Find all students tied to one other student
                for(Student s : students.values()){
                    if(s.tiedTo.size() == 1){
                        toRemove.add(s);
                        changed = true;
                    }
                }
                
                if(changed){
                    numGroups++;
                }
                //Kick them out and untie them
                while(!toRemove.isEmpty()){
                    Student s = toRemove.remove();     
                    s.untie();
                }
            }
            
            System.out.println(numGroups);
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

class Student{
    int id;
    HashSet<Student> tiedTo = new HashSet<>();
    public Student(int id){
        this.id = id;
    }
    
    public void tie(Student otherStudent){
        tiedTo.add(otherStudent);
        otherStudent.tiedTo.add(this);
    }
    
    public void untie(){
        for(Student s : tiedTo){
            s.tiedTo.remove(this);
            tiedTo.remove(s);
        }
        tiedTo = new HashSet<>();
    }
}