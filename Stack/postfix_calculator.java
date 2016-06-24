import java.util.*;


class postfixCalculator {
	/** class for reporting a syntax error */
	public static class SyntaxErrorException extends Exception {
		/** Constructor that prompts the specified message */
		SyntaxErrorException(String message) {
			super(message);
		}
	}
	/** OPERATORS */
	private static final String OPERATORS = "+-*/";

	private Stack <Integer> operands; 

	/** Calculates the current operation */
	private int calOps(char operator) {
		int result = 0; 
		int right = operands.pop();
		int left = operands.pop();
		// calculates the operator 
		switch (operator) {
			case '+' : result = left + right; break;
			case '-' : result = left - right; break;
			case '/' : result = left / right; break;
			case '*' : result = left * right; break;
		}
		return result;
	}

	private boolean isOperator(char ch) {
		return OPERATORS.indexOf(ch) != -1; 
	}

	public int cal(String input) throws SyntaxErrorException {
		// initiates the empty stack 
		operands = new Stack <Integer> ();
		// tokenizes the input by space 
		String [] tokens = input.split("\\s+");

		try {
			for (String eachToken : tokens) {
				char first = eachToken.charAt(0);
				if(Character.isDigit(first)) {
					int value = Integer.parseInt(eachToken);
					operands.push(value);
				} else if (isOperator(first)) {
					int result = calOps(first); 
					operands.push(result);
				} else {
					throw new SyntaxErrorException("Invalid character ! " + first);
				}
			} // end of for loop

			// the case of no more tokens - pop result from stack 
			int answer = operands.pop();
			if(operands.empty()) {
				return answer;
			} else {
				throw new SyntaxErrorException("Stack is not empty...");
			}	
		} catch (EmptyStackException ex) {
			throw new SyntaxErrorException("It attempts to pop the empty stack .. ");
		}
	}
}