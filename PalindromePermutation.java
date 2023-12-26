
public class PalindromePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String input = "tactcoapapa";
		String input2 = "kushwa" ;
		
		PalindromePermutation pc = new PalindromePermutation();
		
		System.out.println("input first -------" +  pc.isPermutationOfPalindrome(input));
		System.out.println("input second ------" +  pc.isPermutationOfPalindrome(input2));
		
		
		System.out.println("-----------------------------------------------------------------");
		
		System.out.println( "My first second attempt : " + pc.isPermutationOfPalindromee(input));
		
		

	}
	boolean isPermutationOfPalindrome(String Phrase) {
		int[] table = buildCharFrequencyTable(Phrase);
		return checkMaxOneOdd(table);
	}
	/*check that no more than one character has an odd count*/
	boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for(int count : table) {
			if(count % 2 == 1) {
				if(foundOdd) {
					return false ;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	boolean isPermutationOfPalindromee(String Phrase) {
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z')- Character.getNumericValue('a') +1 ];
		for(char c : Phrase.toCharArray()) {
			int x= getCharNumber(c);
			if (x != -1) {
				table[x]++;
				if(table[x] % 2 ==1) {
					countOdd++ ;
				}
				else {
					countOdd--;
				}
			}
		}
		return countOdd <=1 ;
	}

	/*Map each character to a number  . a ->0 ,  b->1 , c ->2
	 * This is case insensitive , non-letter characters map to -1 */
	int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <=z) {
			return val - a;
		}
		return -1;
	}
	
	/*Count how many times each character appears*/
	int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1];
		
		for (char c : phrase.toCharArray()) {
			int x= getCharNumber(c);
			if (x != -1) {
				table[x]++ ;
			}
		}
		return table ;
	}
}
