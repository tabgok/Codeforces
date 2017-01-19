/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.round2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 */
public class TaskA {

    public static void main(String[] args) {
        InputStream inputStream;
        String str = null;
        if (str == null) {
            inputStream = System.in;
        } else {
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
            int numScores = in.nextInt();

            HashMap<String, Person> scores = new HashMap<>();

            String winnner;

            for (int i = 0; i < numScores; i++) {
                String p = in.next();
                int s = in.nextInt();

                if (!scores.containsKey(p)) {
                    scores.put(p, new Person());
                    scores.get(p).name = p;
                }

                scores.get(p).scores.add(new Score(s, i));
                scores.get(p).score += s;
            }

            Integer max = Integer.MIN_VALUE;
            for (Person p : scores.values()) {
                max = Math.max(p.score, max);
            }

            int minPos = Integer.MAX_VALUE;
            String winner = null;

            for (Person p : scores.values()) {
                if (p.score == max) {
                    int tempScore = 0;
                    for (Score s : p.scores) {
                        tempScore += s.value;
                        if (tempScore >= max && s.time < minPos) {
                            minPos = s.time;
                            winner = p.name;
                        }
                    }
                }
            }
            System.out.println(winner);
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

class Person {

    String name;
    int score = 0;
    LinkedList<Score> scores = new LinkedList<>();

}

class Score {

    int value;
    int time;

    public Score(int value, int time) {
        this.value = value;
        this.time = time;
    }
}
