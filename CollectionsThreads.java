/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsthreads;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Jon
 */
public class CollectionsThreads {

    int indexNum = 0;
    public static int i = 0, j = 0, k = 0, l = 0;

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        CollectionsThreads.i = i;
    }

    public static int getJ() {
        return j;
    }

    public static void setJ(int j) {
        CollectionsThreads.j = j;
    }

    public static int getK() {
        return k;
    }

    public static void setK(int k) {
        CollectionsThreads.k = k;
    }

    public static int getL() {
        return l;
    }

    public static void setL(int l) {
        CollectionsThreads.l = l;
    }
    
    public static void addRange(int i) {
        range.add(i);
    }
    
    public static void removeRange(int i){
        range.remove(i);
    }
    
    public static int getEvensLength(){
        return evens.size();
    }
    
    public static int getEvens(int i){
        return evens.get(i);
    }

    public static void addEvens(int i) {
        evens.add(i);
    }
    
    public static boolean getRange(int i){
        return range.contains(i);
    }
    
    public static void setOdds(int i, int j){
        odds.put(i,j);
    }
    
    static ArrayList<Integer> evens = new ArrayList<Integer>();
    static HashSet<Integer> range = new HashSet<Integer>();
    static TreeMap<Integer, Integer> odds = new TreeMap<Integer, Integer>();

    public static void main(String[] args) throws InterruptedException {
        //Fill Range with two Threads
        buildRange bldrange1 = new buildRange();
        bldrange1.start();
        TimeUnit.MILLISECONDS.sleep(5);
        buildRange bldrange2 = new buildRange();
        bldrange2.start();
        
        //Fill Evens with two Threads
        buildEvens bldevens1 = new buildEvens();
        bldevens1.start();
        TimeUnit.MILLISECONDS.sleep(5);
        buildEvens bldevens2 = new buildEvens();
        bldevens2.start();
        
        TimeUnit.SECONDS.sleep(2);
        //Remove Evens from Range using two Threads started with Runnables
        Thread t1 = new Thread(new removeEvens());
        t1.start();
        TimeUnit.MILLISECONDS.sleep(5);
        Thread t2 = new Thread(new removeEvens());
        t2.start();
        
        TimeUnit.SECONDS.sleep(2);
        //Add remainging range values to odds for sorting in table using executors
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 3; i++){
            Runnable worker = new sortOdds();
            TimeUnit.MILLISECONDS.sleep(5);
            executor.execute(worker);
        }
        executor.shutdown();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("All Odd Numbers between 0 and 100 " + odds);
    }
    
}

class buildRange extends Thread {
    
    int rcnt;
    public void run(){
        for(rcnt = CollectionsThreads.getI(); rcnt < 101;){
            CollectionsThreads.addRange(rcnt);
            System.out.println(Thread.currentThread().getId() + " added number " + rcnt + " to range");
            rcnt = rcnt +1;
            CollectionsThreads.setI(rcnt);
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
            }
            rcnt = CollectionsThreads.getI();
        }
    }
   
}

class buildEvens extends Thread {
        int ecnt;
    public void run(){
        for(ecnt = CollectionsThreads.getJ(); ecnt < 101;){
            CollectionsThreads.addEvens(ecnt);
            System.out.println(Thread.currentThread().getId() + " added number " + ecnt + " to evens");
            ecnt = ecnt +2;
            CollectionsThreads.setJ(ecnt);
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
            }
            ecnt = CollectionsThreads.getJ();
        }
    }
}
    
class removeEvens implements Runnable {

    @Override
    public void run() {
        int val;
        int length = CollectionsThreads.getEvensLength();
        for(int k = CollectionsThreads.getK(); k < length;){
            val = CollectionsThreads.getEvens(k);
            CollectionsThreads.removeRange(val);
            System.out.println(Thread.currentThread().getId() + " removed number " + val + " from range");
            k = k + 1;
            CollectionsThreads.setK(k);
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
            }
            k = CollectionsThreads.getK();
        }
    }    
}

class sortOdds implements Runnable {
 
    
    @Override
    public void run() {
        boolean val;
        for(int l = CollectionsThreads.getL(); l < 101;){
            val = CollectionsThreads.getRange(l);
            if(val == true ){
                CollectionsThreads.setOdds(l, l);
                System.out.println(Thread.currentThread().getId() + " added number " + l + " to odds");
            }
            l = l + 1;
            CollectionsThreads.setL(l);
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
            }
            l = CollectionsThreads.getL();
        }
    }
    
}

