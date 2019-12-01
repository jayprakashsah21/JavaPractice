package locks;

public class DeadLoackDemo {
	public static void main(String[] args) {
		String s1="BC";
		String s2="DE";
		
		Runnable r=()->{
		  	synchronized(s1) {
		  		 System.out.println("Thread 1: locked resource 1");  
		  		synchronized (s2) {
		  			 System.out.println("Thread 1: locked resource 2");  
					
				}
		  	}
		  	
		};
		
		Runnable r2=()->{
			synchronized(s2) {
				 System.out.println("Thread 2: locked resource 2");  
			
		  		synchronized (s1) {
		  
		  			 System.out.println("Thread 2: locked resource 1");  
				}
		  	}
		};
		
		Thread t1=new Thread(r);
		Thread t2=new Thread(r2);
		t1.start();
		t2.start();
		
	}
}
