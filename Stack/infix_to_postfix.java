import java.util.*;
import javax.swing.JOptionPane;

public class infix_to_postfix {
	private Stack <Character> operator;

	private static final String OPERATORS = "+-*/";

	private static final int[] PRECEDENCE = {1, 1, 2, 2};

	private StringBuilder postfix;

	public String convert(String infix_exp) throws SyntaxErrorException {
		operator = new Stack <Character>();
		postfix = new StringBuilder();
		String[] tokens = infix_exp.split("\\s+");
		try {
			for (String eachToken : tokens) {
				char firstChar = eachToken.charAt(0);
				if(Character.isJavaIdentifierStart(firstChar)
					|| Character.isDigit(firstChar)) {
					postfix.append(eachToken);
					postfix.append(' ');
				} else if(isOperator(firstChar)) {
					processOperator(firstChar);
				} 
				else {
					throw new SyntaxErrorException ("Unexpected Character.. " + firstChar);
				}
			} // end of for loop

			// Pop remaining operators and append to them to postfix
			while(!operator.empty()) {
				char op = operator.pop();
				postfix.append(op);
				postfix.append(' ');
			}
			return postfix.toString(); // if stack is empty, return result 
		} catch (EmptyStackException ex) {
			throw new SyntaxErrorException ("Empty Stack.. ");
		}
	}
	/** Algorithm for this method 
		if the operator stack is empty 
			 push the current operator onto the stack 
		else 	
			peek the operator stack and let topOp be the top operator 
			if the precdence of the current operator is greath than the precedence of topOp
				Push the current operator onto the stack
			else 
				while the stack is not empty & the precedence of the current operator 
	/** Processing operators */
	private void processOperator (char op) {
		if(operator.empty()) {
			operator.push(op);
		} else {
			// peek the operator stack and let topOp be top operator 
			char topOp = operator.peek();
			if(precedence(op) > precedence(topOp)) {
				operator.push(op);
			} else {
				while(!operator.empty() && precedence(op) <= precedence(topOp)) {
					operator.pop();
					postfix.append(topOp);
					postfix.append(' ');
					if(!operator.empty()) {
						// reset topOp
						topOp = operator.peek();
					}
				}
				operator.push(op);
			}
		}
	}

	private boolean isOperator(char ch) {
		return OPERATORS.indexOf(ch) != -1;
	}	

	private int precedence(char op) {
		return PRECEDENCE[OPERATORS.indexOf(op)];
	}

	public static class SyntaxErrorException extends Exception {
		/** Constructor that prompts the specified message */
		SyntaxErrorException(String message) {
			super(message);
		}
	}

	public static void main(String[] args) throws SyntaxErrorException {
        String input = JOptionPane.showInputDialog("Enter an infix expression");
        infix_to_postfix example = new infix_to_postfix();     
       	String output = example.convert(input);
      	JOptionPane.showMessageDialog(null, "Processed input is : " + output);     
        System.exit(0);
    }
    /** second version of main method 
    	infix_to_postfix example = new infix_to_postfix(); 
    	String infix = JOptionPane.showInputDialog("Enter an infix expression");
    	try {
    		String postfix = example.convert(infix);

    	}
    	catch (SyntaxErrorException e) {
			JOptionPane.showMessageDiglog(null, e.getMessage());
    	}
    	System.exit(0);
    	*/
}