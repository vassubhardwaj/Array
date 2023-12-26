
public class OneEditAway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input1 = "Vasu";
		String input2 = "Jasu";
		
		OneEditAway o = new OneEditAway();
		
		System.out.println("the given two string are one Edit away (yes or no) :");
		System.out.println("first input is:  " +input1);
		System.out.println("second input is: " +  input2);
		
		System.out.println("========================================================================================");
		System.out.println("now lets check for both the strings (one Edit Away) :" + o.oneEditAway(input1, input2));
		System.out.println("now lets check for both the strings (one replace away) :" + o.oneEditReplace(input1, input2));
		System.out.println("now lets check for both the strings :(one edit insert)" + o.oneEditInsert(input1, input2));

	}
	
	boolean oneEditAway(String first, String second) {
		if(first.length() == second.length()) {
			return oneEditReplace(first, second) ;
		}
		else if(first.length() +1 == second.length()) {
			return oneEditInsert(first, second) ;
		}
		else if(first.length() -1 == second.length()) {
			return oneEditInsert(second , first);
		}
		return false ;
	}
	boolean oneEditReplace(String s1 ,String s2) {
		boolean foundDifference = false ;
		for(int i =0 ; i <s1.length() ; i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(foundDifference) {
					return false;
				}
				foundDifference = true; 
			}
		}
		return true ;
	}
	/*check if you insert a character into s1 to make s2*/
	boolean oneEditInsert(String s1, String s2) {
		int index1 = 0 ;
		int index2 = 0 ;
		while(index2 <s2.length() && index1 <s1.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++ ;
			}
			else {
				index1++ ;
				index2++;
			}
		}
		return true ;
	}

}
