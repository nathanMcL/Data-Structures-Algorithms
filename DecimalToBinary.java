// Binary to String; chpt 5, pg.116, 5.2

// The Java program is designed to convert a decimal number between 0 and 1 (exclusive) to its binary representation.
// The program multiplies the fractional part of the number by 2 to determine each subsequent binary digit. 
// If the result of this multiplication is 1 or greater, 
// it appends a '1' to the binary representation,
// and the process continues with the new fractional part (after subtracting 1 from the result).
// If the result is less than 1, it appends a '0' to the binary representation,
// and the process continues with the entire result.
// The conversion stops when the fractional part becomes zero or when the binary representation exceeds 32 characters.
// If the representation becomes too long,
// the program returns "Error". Otherwise,
// it outputs the binary representation of the given decimal number,
// prefixed with "0.".

// Class to convert a decimal number between 0 and 1 to its binary representation
public class DecimalToBinary {
    
    // Main method
    public static void main(String[] args) {
        double num = 0.72; // example number
        // Print the binary representation of the given number
        System.out.println(getBinaryRepresentation(num));
    }

    // Method to get the binary representation of a decimal number between 0 and 1
    public static String getBinaryRepresentation(double num) {
        // If the number is less than 0 or greater than 1, return "Error"
        if (num <= 0 || num >= 1) {
            return "Error";
        }

        // StringBuilder to construct the binary representation
        StringBuilder binary = new StringBuilder();
        // Start the binary representation with "0."
        binary.append("0.");

        // While there is a fractional part to the number
        while (num > 0) {
            // If the representation has become too long, return "Error"
            if (binary.length() > 32) {
                return "Error";
            }

            // Multiply the number by 2 to get the next binary digit
            double r = num * 2;
            // If the result is 1 or more
            if (r >= 1) {
                // Add 1 to the binary representation
                binary.append(1);
                // Subtract 1 from the result to get the next fractional number
                num = r - 1;
            } else {
                // Add 0 to the binary representation
                binary.append(0);
                // Use the result as the next fractional number
                num = r;
            }
        }
        // Return the constructed binary representation
        return binary.toString();
    }
}
