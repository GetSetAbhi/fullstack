
/**
 * https://www.youtube.com/watch?v=UKG1xgh_tbQ
 * 
 * **/
public class StringsConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * This will create two objects.
		 * One in heap memory and one in String Constant Pool
		 * **/
		String s = new String("abc");
		
		/**
		 * This will create only one object in heap
		 * and not in SCP because that already exists at this point
		 * **/
		String s1 = new String("abc");
		System.out.println("s==s1 " + (s==s1));
		
		/**
		 * This will only create an object in SCP if it 
		 * doesn't exist already
		 * **/
		String s2 = "abc";
		System.out.println("s==s2 " + (s==s2));
		
		/**
		 * This will only create an object in SCP if it 
		 * doesn't exist already
		 * **/
		String s3 = "abc";
		/**
		 * Since s2 and s3 are pointing to the same object in SCP 
		 * therefore output is true
		 * **/
		System.out.println("s2==s3 " + (s2==s3));
		
		String s4 = s.intern();
		/**
		 * Since s2 and s3 are pointing to the same object in SCP 
		 * therefore output is true
		 * **/
		System.out.println("s3==s4 " + (s3==s4));

	}

}
