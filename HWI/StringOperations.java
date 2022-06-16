

public class StringOperations {
    

	public static void main(String[]args) {
		//a
		String name= "MYNAME";
		System.out.println(name);
        
        //b
		int len=name.length();
        
        String firstname= 'A'+ name.substring(1,len-1);
		
		char replacelast = 'Z';
		String lastname= firstname.substring(0,5)+ replacelast ;
		System.out.println(lastname);
        

		//c
		String nameweb= "www.gatech.edu";
        System.out.println(nameweb);
        
        //d
		String substringwebName= nameweb.substring(4, 10);
	    int number= 1331;
	    String completeString=substringwebName+ number;
	    
		System.out.println(completeString);


	}
}
