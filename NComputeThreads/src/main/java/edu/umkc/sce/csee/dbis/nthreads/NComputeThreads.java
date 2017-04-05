package edu.umkc.sce.csee.dbis.nthreads;

import java.util.ArrayList;
import java.util.List;

/**
 * NComputeThreads
 * 
 * Starts N threads that perform a computation then stop after T seconds.
 * 
 * Usage: java -jar NComputeThreads-1.0-SNAPSHOT.jar <N> <T>
 *     N (+int) : number of threads to run. 
 *     T (+int) : the runtime duration.
 * 
 */
public class NComputeThreads {
  public static void main(String[] args) {
    //args = new String[] {"3","6"};
    if (args.length != 2){
      String usage = "Usage: java -jar NComputeThreads-1.0-SNAPSHOT.jar <N> <T>\n"+
          "\tN (+int) : number of threads to run.\n"+"\tT (+int) : the runtime duration.";
      System.err.println(usage);
      System.exit(0);
    }
    
    final int numberOfThreads = Integer.valueOf(args[0]);
    final int duration = Integer.valueOf(args[1]);
    
    System.out.println("Creating "+numberOfThreads+ " thread(s) that will run for "+duration+"s.");
   
    List<Thread> threadList = new ArrayList<Thread>();
    for (int t = 0; t < numberOfThreads; t++ ){
      Thread thread = new Thread(new RunnableComputer());
      thread.setName("Thread-"+t);
      threadList.add(thread);
      thread.start();
    }
    
    try {
      Thread.sleep(duration*1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    
    System.out.println("Stopping "+numberOfThreads+ " thread(s).");
    for (int t = 0; t < numberOfThreads; t++ ){
      threadList.get(t).interrupt();
    }
  }
}
