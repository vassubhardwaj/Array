
public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String bf = "vasu";
		String gf = "uavs" ;
		boolean result = permutation(bf , gf);
		System.out.println("The above texts are permutain of each other(true/false) : " + result );
	}
	static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);

	}
	static boolean permutation (String s, String t) {
		if(s.length() != t.length()) {
			return false ;
		}
		return sort(s).equals(sort(t));
	}

}
