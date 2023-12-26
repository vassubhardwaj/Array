
public class Uniquecharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   String testString = "abcdefga";
	        boolean result = isUniquechars(testString);
	        System.out.println("Is the string unique? " + result);


	}
	static boolean isUniquechars(String str) {
		if(str.length() > 128)
			return false;
		boolean[] char_set = new boolean[128];
		for(int i= 0; i < str.length() ; i++) {
			int val = str.charAt(i);
			if(char_set[val]) {
				return false ;
			}
			char_set[val]= true ;
		}
		return true ;
	}

}
