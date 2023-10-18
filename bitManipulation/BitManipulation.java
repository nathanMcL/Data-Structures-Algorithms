// Cracking the Code, pg 116, 5.6 Conversion.

// Write a function to determine the number of bit you need to flip to convert.


package bitManipulation;

public class BitManipulation {

	public static void main(String[] args) {
		int A = 45; // Sample input A, original entry: 29(in binary: 11101)
		int B = 15; // Sample input B, original entry: 15(in binary: 01111)
		System.out.println("Number of bits needed to be flipped: " + bitSwapsRequired(A, B));

	}
	
	// The XOR operation between two bits returns 1 if the bits are different,
	// and 0 if they are the same. 
	// Thus, XORing A and B gives a result where every bit position set to 1
	// indicates a difference between A and B.
	
	public static int bitSwapsRequired(int A, int B) {
		int count = 0;
		// XOR the two numbers
		int xorResult = A ^ B;
		
		// Count the number of set bits
		while (xorResult != 0) {
			count += (xorResult & 1); // If the last bit is 1, add it to the count
			xorResult >>= 1; // Right shift by 1
		}
		
		return count;
	}

}
