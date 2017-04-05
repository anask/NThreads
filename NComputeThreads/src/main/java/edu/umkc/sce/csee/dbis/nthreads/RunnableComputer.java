package edu.umkc.sce.csee.dbis.nthreads;

public class RunnableComputer implements Runnable {
  private String myName;
  
  public void run() {
    myName = Thread.currentThread().getName();
    doComputeSomething();
  }
  
  private void doComputeSomething() {
    int p = 0;
    while (Thread.currentThread().isInterrupted() == false){
      //System.out.println(myName);
      isPrime(p++);
    }
  }
  
  // isPrime
  // By meJustAndrew
  // http://stackoverflow.com/questions/38168785/i-have-a-for-loop-to-count-prime-numbers-how-do-i-c
  // ount-the-number-of-primes-be
  public static boolean isPrime(int n) {
    if (n == 1) {
      return false;
    }
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
