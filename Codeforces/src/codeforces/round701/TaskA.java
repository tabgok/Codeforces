/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforces.round701;

/**
 *
 * @author teague
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class TaskA{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numCards = scan.nextInt();
        
        Card[] cards = new Card[numCards];
        
        for(int i=0;i<cards.length;i++){
            cards[i] = new Card(i+1,scan.nextInt());
        }
        
        Arrays.sort(cards, new Comparator <Card>(){
            public int compare(Card a, Card b){
                return Integer.compare(a.val, b.val);
            }
        });
        
        for(int i=0;i<cards.length/2;i++){
            System.out.println(cards[i].pos + " " + cards[cards.length-i-1].pos);
        }
        
    }
}


class Card{
    int pos = 0;
    int val = 0;
    
    public Card(int pos, int val){
        this.pos = pos;
        this.val = val;
    }
}