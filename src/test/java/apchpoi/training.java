package apchpoi;

public class training {

	
	public static void main(String[] args) {
		String str="q2b2c3d4";
				for (int i = 0; i < str.length(); i += 2) {
		    	 String letter = str.charAt(i); 
		    	 System.out.println(letter);
		    	 char digitChar = str.charAt(i + 1); 
		    	 System.out.println(digitChar);
		    	 int digit = Character.getNumericValue(digitChar);
		    	 System.out.println(digit);
    
         
		    	        
		    	    }
		    	}

		    }
