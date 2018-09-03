package temporary;

class Solution {
	  
	  public static void main(String[] args) {
	    
	    int fabonacciLength=10;
	    for(int i=0 ; i<fabonacciLength ; i++ )
	    	System.out.println(runFabonaci(fabonacciLength));
	    
	  }
	  
	  public static int runFabonaci(int num){
	    int defaultVal=1;
	    
	      if (num==0 || num==1)
	        return defaultVal;
	      else
	    	return runFabonaci(num-1) +  runFabonaci(num-2);
	       
	  }  
	    
	}
