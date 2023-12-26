public class Urlify {

    public static void main(String[] args) {
        String inputString = "Vasu Vasu Joshi Master ";
        
        // Calculate the true length by excluding trailing spaces
        int trueLength = calculateTrueLength(inputString);

        // Convert the input string to a character array
        char[] inputCharArray = inputString.toCharArray();

        // Create an instance of the class
        Urlify urlify = new Urlify();

        // Call the replaceSpaces method
        urlify.replaceSpaces(inputCharArray, trueLength);

        // Print the modified string
        System.out.println("Input String: " + new String(inputCharArray));
    }

    // Helper method to calculate the true length by excluding trailing spaces
    private static int calculateTrueLength(String str) {
        int trueLength = str.length();
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                break;
            }
            trueLength--;
        }

        // Ensure that at least one space is preserved at the end
        if (trueLength < str.length()) {
            trueLength++;
        }

        return trueLength;
    }


    void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;

        // Count the number of spaces in the original string
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        // Calculate the new length after replacing spaces
        int newIndex = trueLength + spaceCount * 2 - 1;

        // Check if the array is large enough to accommodate the modified string
        if (newIndex >= str.length) {
            // If not, resize the array to twice the required size
            char[] newStr = new char[newIndex + 1];
            System.arraycopy(str, 0, newStr, 0, trueLength);
            str = newStr;
        }

        // Iterate through the original string from end to start
        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex--) {
            if (str[oldIndex] == ' ') {
                // Insert %20
                str[newIndex--] = '0';
                str[newIndex--] = '2';
                str[newIndex--] = '%';
            } else {
                str[newIndex--] = str[oldIndex];
            }
        }

        // Print the modified string
        System.out.println("Modified String: " + new String(str));
    }
    
}

