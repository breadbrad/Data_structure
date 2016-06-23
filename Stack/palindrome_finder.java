import java.util.*;

public class PalindromeFinder {

	private String inputString;

	private Stack <Character> charStack = new Stack <Character> ();

	/** Store the argument string in a stack of characters 
		@param str String of characters to store 
	*/
	public PalindromeFinder(String str) {
		inputString = str;
		fillStack();
	}

	/** Method to build a string conataining the characters in a stack */
	private void fillStack() {
		for (int i = 0; i < inputString.legnth(); i++) {
			charStack.push(inputString.charAt(i));
		}
	}

	private String reverseStringBuilder () {
		StringBuilder result = new StringBuilder();
		while(!charStack.empty()){
			result.append(charStack.pop());
		}
		return result.toString();
	}

	public boolean isPalindrom() {
		return inputString.equalsIgnoreCase(reverseStringBuilder());
	}
}

