/** Queue -> used in a print queue 
	offer -> inserts an element at the rear of the queue
	-----
	remove / poll -> both remove & return the front element 
	if the queue is empty, 
	remove -> throws an exception 
	poll   -> returns null 
	-----
	peek / element -> both return the element at the front w/o removing it
	element -> throws an exception 
	*/
import java.util.*;
import javax.swing.JOptionPane;

class studentQueue {
	private Queue <String> students;
	/**Constructor for queue */
	public studentQueue() {
		students = new LinkedList <String>(); 
	}  

	public void populateQueue(){ 
		int optionNum = 0;
		String[] choices = {"add", "peek", "remove", "size", "position", "quit"};
		while(optionNum < choices.length - 1){
			optionNum = JOptionPane.showOptionDialog(null, "Select an option for processing students", "Menu",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
								 choices, choices[0]);
		// process an option  
		try{ 
			String name;
			switch(optionNum) {
				case 0 : 
					name = JOptionPane.showInputDialog("Enter new student name");
					students.offer(name);
					JOptionPane.showMessageDialog(null, "Student " + name + " has been added to queue");
					break;
				case 1 : 
					JOptionPane.showMessageDialog(null, students.element());
					break;
				case 2 : 
					JOptionPane.showMessageDialog(null, "Student" + students.remove() + " is removed");
					break;
				case 3 :
					JOptionPane.showMessageDialog(null, "Size is " + students.size());
					break;
				case 4 : 	
					name = JOptionPane.showInputDialog(null, "Enter the student name ");
					int countPosition = 0;
					for (String names : students) {
						if (!names.equals(name)){
							countPosition++;
						} else {
							JOptionPane.showMessageDialog(null, "student name '" + name + "' is at " + countPosition);
							break;
							}}
							if(countPosition == students.size())
								JOptionPane.showMessageDialog(null, name + " was not found..");		
							
							break;
				case 5 : 
					JOptionPane.showMessageDialog(null, "The number of students is " + students.size());
					break;
				default : 
					JOptionPane.showMessageDialog(null, "Invalid option");
			}
		} catch(NoSuchElementException e) {
			JOptionPane.showMessageDialog(null, "Error occured.. " + e.getMessage());
		} 
		}		
	}
	public static void main(String[] args) {
		studentQueue students = new studentQueue();
		students.populateQueue();
	}
}
