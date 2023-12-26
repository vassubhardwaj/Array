
public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String  input = "aaaabbbbbbdddddtttttttttt" ;
		StringCompression sc= new StringCompression();
		System.out.println("compressed string for input :" +  input + " is "+ sc.compressBad(input) );
		
        System.out.println("----------------------------------------------------------");
        System.out.println("Using the String Builder Method to optimize the class :");
        System.out.println("below is the result from it");
		System.out.println("compressed string for input :" +  input + " is "+ sc.compress(input) );

        System.out.println("----------------------------------------------------------");

        System.out.println("----------------------------------------------------------");
        System.out.println("now using the most optimized method to make an argument for it");
        System.out.println("the third but the best method to solve is : " +  sc.compressing(input));

	}
	String compressBad(String str) {
		String compressedString= "";
		int countConsecutive =0 ;
		for(int i=0 ;i <str.length() ; i++) {
			countConsecutive++;
			/*if next character is different than the current, append this char to result*/
			if(i+1 >=str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressedString += "" + str.charAt(i)+ countConsecutive ;
				countConsecutive = 0;
			}
		}
		return compressedString.length() <str.length() ? compressedString : str ;
	}
	
	String compress(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for(int i=0 ;  i< str.length() ; i++) {
			countConsecutive++;
			/*if next character is different than the current , append this char to result*/
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive =0 ;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str ;
	}
	
	String compressing(String str) {
		int finalLength = countCompression(str);
		if(finalLength >= str.length())
			return str ;
		StringBuilder compressed = new StringBuilder(finalLength); //initialCapacity .
		int countConsecutive =0 ;
		for(int i=0 ; i<str.length(); i++) {
			countConsecutive++ ;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}
	
	int countCompression(String str) {
		int compressedLength = 0;
		int countConsecutive = 0 ;
		
		for(int i =0 ; i <str.length(); i++) {
			countConsecutive++;
			/*if next character is different than current, increase the length*/
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1) ) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive =0 ;
			}
		}
		return compressedLength;
		
	}

}
