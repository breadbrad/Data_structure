import java.util.Stack;
import java.util.EmptyStackException;
import javax.swing.JOptionPane;

class ParenChecker {
	// Constants 
	/** Set of closing, opening parenthesis. */
	private static final String OPEN = "([{";
	private static final String CLOSE = ")]}";
	
	public static boolean isBalanced(String input) {
		Stack <Character> st = new Stack <Character> ();
		boolean balanced = true;
		try {
			int index = 0;
			while (balanced && index < input.length()) {
				char next = input.charAt(index);
				if (isOpen(next)) {
					st.push(next);
				} else if (isClose(next)) {
					char top = st.pop();
					balanced = OPEN.indexOf(top) == CLOSE.indexOf(next);
				}
				index++;
			}
		} catch (EmptyStackException ex) {
			balanced = false;
		}
		return (balanced && st.empty());
	}

	private static boolean isOpen(char ch) {
		return OPEN.indexOf(ch) > -1;
	}

	private static boolean isClose(char ch) {
		return CLOSE.indexOf(ch) > -1;
	}

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter an expression containing parentheses");
		if(ParenChecker.isBalanced(input)) {
			JOptionPane.showMessageDialog(null, input + "is balanced");
		} else {
			JOptionPane.showMessageDialog(null, input + "is not balanced");
		}
		System.exit(0);
	}
}



















