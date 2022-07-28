package com.interview.learning.examples;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CompletableFuture4 {
	
	public static void main(String[] args) {
		
		//Integer[] array = {1,2,3,4,5,6};
		
		System.out.println( -1 < 1);
		
		method1();
		
//		method2();
		
		sample();
		 
	}
	
	public static void method1()
	{
		ExecutorService executor1 = Executors.newFixedThreadPool(50);
		ExecutorService executor2 = Executors.newFixedThreadPool(50);
		
//		ExecutorService executor1 = Executors.newCachedThreadPool();
//		ExecutorService executor2 = Executors.newCachedThreadPool();
		
		IntStream.range(1, 101).forEach(num -> {
			
			CompletableFuture<Void> findOddNumbers = CompletableFuture.completedFuture(num).thenAcceptAsync(x -> {
				if(num %2 != 0)
				{
					System.out.println(num + " is odd number");
				}
			}, executor1);
			
			
			
			CompletableFuture<Void> findEvenNumbers = CompletableFuture.completedFuture(num).thenAcceptAsync(x -> {
				if(num %2 == 0)
				{
					System.out.println(num + " is even number");
				}
			}, executor2);
			
			/* Combination 1 */
//			findOddNumbers.join(); //->Uncommenting this will run asynchronously and the output will not be in order
//			findEvenNumbers.join();   //->Uncommenting this will run asynchronously and the output will not be in order
			
			/* Combination 2 */
			//CompletableFuture.allOf(findOddNumbers, findEvenNumbers).join(); //->Uncommenting this will run asynchronously and the output will not be in order
			
			
			/* Combination 3 */
//			findOddNumbers.join();
//			findEvenNumbers.join();
//			boolean result = CompletableFuture.allOf(findOddNumbers, findEvenNumbers).isDone();
//			System.out.println(result);
		});
		
	executor1.shutdown();
	executor2.shutdown();
	
//	List<Runnable> runnables = executor1.shutdownNow();
//	runnables.stream().forEach(x -> System.out.println(x));
	
	/* Example for RejectionException */
//	executor1.submit(() -> System.out.println("Submitting Task After the Shutdown of Executor"));
	}
	
	
	public static void method2()
	{	
		CompletableFuture<Integer> squareOfNumber = CompletableFuture.completedFuture(2).thenApplyAsync(x -> {
			int retValue = x*x;
			System.out.println(retValue);
			return retValue;
		});
		
		
		CompletableFuture<Integer> squareOfNumberMultByThree = CompletableFuture.completedFuture(3).thenApplyAsync(x -> {
			try {
				int retVal = squareOfNumber.get() * 3;
				System.out.println(retVal);
				return retVal;
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return 0;
		});

		CompletableFuture.allOf(squareOfNumberMultByThree,squareOfNumber).join(); //->Uncommenting this will run asynchronously and the output will not be in order
	}
	
	
	static void applyToEitherExample() {
	    String original = "Message";
	    CompletableFuture<String> cf1 = CompletableFuture.completedFuture(original)
	            .thenApplyAsync(s -> s.toUpperCase());
	    
	    CompletableFuture<String> cf2 = cf1.applyToEither(
	            CompletableFuture.completedFuture(original).thenApplyAsync(s -> s.toLowerCase()),
	            s -> s + " from applyToEither");
	    
	    System.out.println(cf2.join().endsWith(" from applyToEither"));
	}
	
	static void sample()
	{
		String original = "Message";
	    CompletableFuture<String> cf = CompletableFuture.completedFuture(original).thenApply(s -> s.toLowerCase())
	            .thenCombine(CompletableFuture.completedFuture(original).thenApply(s -> s.toUpperCase()),
	                    (s1, s2) -> s1 + s2);
	    System.out.println(cf.join());
//	   System.out.println(cf.getNow(original));
	}

}
