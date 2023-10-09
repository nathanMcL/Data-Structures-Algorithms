// Pages. 88 - 95, attempt 2 problems

// 1.2: Check Permutation. 

import java.util.Arrays;

public class PermutationChecker {

 

       public static void main(String[] args) {

 

         System.out.println(arePermutations("abc", "bca"));   //True

System.out.println(arePermutations("hello", "olleh")); //True

System.out.println(arePermutations("test", "taste")); //False

}

 

public static boolean arePermutations(String str1, String str2) {

// If the length of the strings are not equal, they cannot be permutations of each other

if (str1.length() != str2.length()) {

 

return false;

 

}

 

// Convert strings to char arrays

char[] chars1 = str1.toCharArray();

char [] chars2 = str2.toCharArray();

 

// Sort the char arrays

Arrays.sort(chars1);

Arrays.sort(chars2);

 

// Compare the sorted arrays

return Arrays.equals(chars1, chars2);

 

}

}