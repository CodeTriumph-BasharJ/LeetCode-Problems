/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.multi_threading;

/**
 *
 * @author basha
 */
import java.lang.Thread;
import java.lang.Runnable;
import java.lang.InterruptedException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class Multi_Threading extends Thread  {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
       Multi_Threading thread = new Multi_Threading();
       
       thread.start();
       Runnable runnable = () -> {
           System.out.println("runnable");
       };
        Thread thread1 = new Thread(runnable);
        
        Thread thread2= new Thread(){
            @Override
            public void run(){
          
           for(int i = 0; i < 500 * 10000 ; ++i);
           System.out.println("finished thread2  " +getName());
            
        }
            
            
        };
        
      thread1.start();
      
      thread2.start();
      
      try{
      Thread.sleep(20L); //Stops threads after 10 seconds. Dangerous!!
      }catch (InterruptedException e){
          
          System.out.println(e);
      }
      System.out.println(thread1.isAlive() + "  " + thread2.isAlive());
      
      ExecutorService exc = Executors.newSingleThreadExecutor();
      Future ftr = exc.submit(new Runnable() {
          
          @Override
          public void run() {
              System.out.println("Future ");
              
          }
        
      });
      
      exc.execute(new Runnable(){;
      @Override
      public void run()
      {
          
          System.out.println("executor");
           
      } 
      
     
    });
      
   
   System.out.println(ftr.get());
   
  List<Callable<String>> list = new ArrayList<>();
  list.add(new Callable(){
     public String call(){
        
         return "task_1";
     } 
      
  });
   list.add(new Callable(){
     public String call(){
         return "task_2";
     } 
      
  });
   
   System.out.println(exc.invokeAny(list));
   List<Future<String>> list2 = exc.invokeAll(list);
   for(Future f : list2){
       System.out.println(f.get());
   }
   exc.shutdownNow(); //Program won't terminate without this.
   exc.awaitTermination(10L*1000L, TimeUnit.MICROSECONDS);
    }
}
