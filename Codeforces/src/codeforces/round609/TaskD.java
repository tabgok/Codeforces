package codeforces.round609;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


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
            int numDays = in.nextInt();
            int numGadgets = in.nextInt();
            int reqGadgets = in.nextInt();
            long numBurles = in.nextInt();
            ArrayList<Gadget> poundGadgets = new ArrayList<>();
            ArrayList<Gadget> dollarGadgets = new ArrayList<>();
            int[] bPerD= new int[numDays+1];
            int[] bPerL = new int[numDays+1];
            bPerD[0] = Integer.MAX_VALUE;
            bPerL[0] = Integer.MAX_VALUE;
            
            for(int i=1;i<=numDays;i++){
                bPerD[i] = Math.min(in.nextInt(), bPerD[i-1]);
            }
            
            for(int i=1;i<=numDays;i++){
                bPerL[i] = Math.min(in.nextInt(), bPerL[i-1]);
            }
            
            for(int i=1;i<=numGadgets;i++){
                int type = in.nextInt();
                int cost = in.nextInt();
                if(type == 1){
                    dollarGadgets.add(new Gadget(type, cost, i));
                }else{
                    poundGadgets.add(new Gadget(type, cost, i));
                }
            }
            in.clear();
            dollarGadgets.add(new Gadget(0,0,-1));
            poundGadgets.add(new Gadget(0,0,-1));
            Gadget[] dGadgets = dollarGadgets.toArray(new Gadget[0]);
            Gadget[] lGadgets = poundGadgets.toArray(new Gadget[0]);            
            
            Arrays.sort(dGadgets, (Gadget o1, Gadget o2) -> Long.compare(o1.cost, o2.cost));
            
            Arrays.sort(lGadgets, (Gadget o1, Gadget o2) -> Long.compare(o1.cost, o2.cost));
            
            for(int i=1;i<dGadgets.length;i++){
                dGadgets[i].cost = dGadgets[i-1].cost+dGadgets[i].cost;
                //System.out.print(dGadgets[i].cost+" ");
            }//System.out.println();
            for(int i=1;i<lGadgets.length;i++){
                lGadgets[i].cost = lGadgets[i-1].cost+lGadgets[i].cost;
                //System.out.print(lGadgets[i].cost+" ");
            }//System.out.println();
            
            int day = 1;
            int minDday = 0;
            int minLday = 0;
            
            long tmpBurles = 0;
            int dIndex=0;
            int lIndex = 0;
            
            
            for(day=1;day<=numDays;day++){
                boolean recompute = false;
                if(bPerD[day] < bPerD[minDday]){
                    recompute = true;
                    minDday = day;
                }
                if(bPerL[day] < bPerL[minLday]){
                    recompute = true;
                    minLday = day;
                }
                
                tmpBurles = lGadgets[lIndex].cost*bPerL[minLday]+dGadgets[dIndex].cost*bPerD[minDday];
                while(lIndex < lGadgets.length-1 && tmpBurles+(lGadgets[lIndex+1].cost-lGadgets[lIndex].cost)*bPerL[minLday] <= numBurles){
                    lIndex++;
                    tmpBurles = lGadgets[lIndex].cost*bPerL[minLday]+dGadgets[dIndex].cost*bPerD[minDday];
                }
                
                
                //System.out.println(tmpBurles+ " - " + numBurles);
                while(dIndex < dGadgets.length-1 && tmpBurles + (dGadgets[dIndex+1].cost-dGadgets[dIndex].cost)*bPerD[minDday] <= numBurles ){
                    dIndex++;
                    tmpBurles = lGadgets[lIndex].cost*bPerL[minLday]+dGadgets[dIndex].cost*bPerD[minDday];
                }

                //System.out.println(tmpBurles+ " - " + numBurles);
                
                while(lIndex > 0 && dIndex < dGadgets.length-1 && dGadgets[dIndex+1].cost*bPerD[minDday] + lGadgets[lIndex-1].cost*bPerL[minLday] < tmpBurles){

                    lIndex--;
                    tmpBurles = dGadgets[dIndex].cost*bPerD[minDday] + lGadgets[lIndex].cost*bPerL[minLday];
                    while(dIndex < dGadgets.length-1 && tmpBurles + (dGadgets[dIndex+1].cost-dGadgets[dIndex].cost)*bPerD[minDday] <= numBurles ){
                        dIndex++;
                        tmpBurles = dGadgets[dIndex].cost*bPerD[minDday] + lGadgets[lIndex].cost*bPerL[minLday];
                    }
                    
                }
                while(dIndex > 0 && lIndex < lGadgets.length-1 && dGadgets[dIndex-1].cost*bPerD[minDday] + lGadgets[lIndex+1].cost*bPerL[minLday] < tmpBurles){

                    dIndex--;
                    tmpBurles = dGadgets[dIndex].cost*bPerD[minDday] + lGadgets[lIndex].cost*bPerL[minLday];
                    while(lIndex < lGadgets.length-1 && tmpBurles+(lGadgets[lIndex+1].cost-lGadgets[lIndex].cost)*bPerL[minLday] <= numBurles){
                        lIndex++;
                        tmpBurles = dGadgets[dIndex].cost*bPerD[minDday] + lGadgets[lIndex].cost*bPerL[minLday];
                    }
                    
                }
                //System.out.println(tmpBurles+ " - " + numBurles);
                //System.out.println(day+"("+bPerD[minDday]+" " + bPerL[minLday]+"): " + dIndex+" "+lIndex + " :::: " + dGadgets[dIndex].cost + " " + lGadgets[lIndex].cost);
                //System.out.println();
                while(lIndex+dIndex > reqGadgets){
                    if(lIndex>0){lIndex--;}
                    else{dIndex--;}
                }
                if(lIndex+dIndex >= reqGadgets){
                    StringBuilder sb = new StringBuilder();
                    sb.append(day).append("\n");
                    for(int i=1;i<dIndex;i++){
                        sb.append(dGadgets[i].id).append(" ").append(minDday).append("\n");
                    }
                    if(dIndex >= 1){
                        sb.append(dGadgets[dIndex].id).append(" ").append(minDday);
                    }

                    if(lIndex >= 1 && dIndex >=1){
                        sb.append("\n");
                    }
                    for(int i=1;i<lIndex;i++){
                        sb.append(lGadgets[i].id).append(" ").append(minLday).append("\n");
                    }
                    if(lIndex >= 1){
                        sb.append(lGadgets[lIndex].id).append(" ").append(minLday);
                    }
                    System.out.println(sb);
                    return;
                }
            }
            
            System.out.println(-1);
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
        
        public void clear(){
            try {
                while (reader.ready()) {
                    try {
                        tokenizer = new StringTokenizer(reader.readLine());
                    } catch (IOException e) {
                        
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TaskD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class Gadget{
    int type;
    long cost;
    int id;
    public Gadget(int type, long cost, int id){
        this.type = type;
        this.cost = cost;
        this.id = id;
    }
}   