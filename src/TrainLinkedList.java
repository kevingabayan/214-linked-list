/**
* The <code>TrainLinkedList</code> class implements <code>TrainLinkedList<code>
* objects.
*
*
* @author K. K. G.
*    e-mail: kevin.gabayan@stonybrook.edu
*    Stony Brook ID: 111504873
**/
public class TrainLinkedList {
	private TrainCarNode head = null;
	private TrainCarNode tail = null;
	private TrainCarNode cursor = null;
	private int totalSize = 0;
	private double totalWeight = 0;
	private double totalValue = 0;
	private double totalLength = 0;
	private int totalDangerous = 0;
	/**
	 * TrainLinkedList variables:
	 * @param head
	 * The head of the Double-Linked ADT. Its default is set to null.
	 * @param tail
	 * The tail of the Double-Linked ADT. Its default is set to null.
	 * @param cursor
	 * The cursor of the Double-Linked ADT. Its default is set to null.
	 * @param size
	 * @param totalWeight
	 * @param totalValue
	 * @param totalLength
	 * @param totalDangerous
	 */
	
	/**
	 * This method constructs an instance of TrainLinkedList with no TrainCar objects.
	 * <dt><b>Postconditions:</b><dd>
	 * This TrainLinkedList has been initialized to an empty linked list.
	 * Head, tail, and cursor are all set to null.
	 */
	public TrainLinkedList() {
	}
	
	/**
	 * This method returns a reference to the TrainCar at the node currently referenced
	 * by the cursor.
	 * <dt><b>Preconditions:</b><dd>
	 * The list is not empty(cursor is not null).
	 * @return
	 * The reference to the TrainCar at the node currently referenced by the cursor.
	 */
	public TrainCar getCursorData() {
		return cursor.getCar();
	}
	
	/**
	 * This method places car in the node currently referenced by the cursor.
	 * <dt><b>Preconditions:</b><dd>
	 * The list is not empty(cursor is not null).
	 * <dt><b>Postconditions:</b><dd>
	 * The cursor node now contains a reference to car as its data.
	 */
	public void setCursorData(TrainCar car) {
		cursor.setCar(car);
	}
	
	/**
	 * This method moves the cursor to point at the next TrainCarNode.
	 * <dt><b>Preconditions:</b><dd>
	 * The list is not empty(cursor is not null) and cursor doesn't reference the tail of the list.
	 * <dt><b>Postconditions:</b><dd>
	 * The cursor has been advanced to the next TrainCarNode, or has remained at the tail of the list.
	 */
	public void cursorForward() {
		if(cursor == null) {
			System.out.println("There's nowhere to move forwards!");
			System.out.println(); }
		else if(cursor != tail) {
			cursor = cursor.getNext();
			System.out.println("Cursor moved forwards.\n");
		}
		else {
			System.out.println("There's nowhere to move forwards!");
			System.out.println();
		}
	}
	
	/**
	 * This method moves the cursor to point at the previous TrainCarNode.
	 * <dt><b>Preconditions:</b><dd>
	 * The list is not empty (cursor is not null) and the cursor does not currently reference the head
	 * of the list.
	 * <dt><b>Postconditions:</b><dd>
	 * The cursor has been moved back to the previous TrainCarNode, or has remained at the head of the list.
	 */
	public void cursorBackward() {
		if(cursor == null) {
			System.out.println("There's nowhere to move backwards!");
			System.out.println(); }
		else if(cursor != head) {
			cursor = cursor.getPrev();
			System.out.println("Cursor moved backwards.\n");
		}
		else {
			System.out.println("There's nowhere to move backward!");
			System.out.println();
		}
			
	}
	
	/**
	 * This method inserts a car into the train after the cursor position.
	 * @param newCar
	 * The new TrainCar to be inserted into the train.
	 * <dt><b>Preconditions:</b><dd>
	 * This TrainCar object has been instantiated.
	 * <dt><b>Postconditions:</b><dd>
	 * The new TrainCar has been inserted into the train after the position of the cursor.
	 * All TrainCar objects previously on the train are still on the train, and their order has been preserved.
	 * The cursor now points to the inserted car.
	 * @throws IllegalArgumentException
	 * Indicates that newCar is null.
	 */
	public void insertAfterCursor(TrainCar newCar) throws IllegalArgumentException {
		if(newCar == null) 
			throw new IllegalArgumentException("Your new train car is null!");
		else {
			TrainCarNode newNode = new TrainCarNode();
			newNode.setCar(newCar);
			if(cursor == null) {
				head = newNode;
				tail = newNode;
				cursor = newNode;
			}
			else if (cursor == head && cursor == tail) {
				cursor.setNext(newNode);
				newNode.setPrev(cursor);
				tail = newNode;
				cursor = newNode;
			}
			else if(cursor == head && cursor != tail) {
				newNode.setNext(cursor.getNext());
				newNode.setPrev(head);
				(newNode.getNext()).setPrev(newNode);
				head.setNext(newNode);
				cursor = newNode;
			}
			else if(cursor != head && cursor == tail) {
				newNode.setPrev(cursor);
				cursor.setNext(newNode);
				tail = newNode;
				cursor = newNode;
			}
			else {
				newNode.setNext(cursor.getNext());
				newNode.setPrev(cursor);
				(cursor.getNext()).setPrev(newNode);
				cursor.setNext(newNode);
				cursor = newNode;
			}
			totalSize++; //Increments Size for the Train
			totalLength += newCar.getCarLength(); // Adds to Total Length
			totalWeight += newCar.getCarWeight(); // Adds to Total Weight
			}
		}
	/**
	 * This extra method increments Total Length, Total Value, and Total Weight for respective product loads.
	 * @param newLoad
	 * The product load to be used.
	 */
	public void incrementProductLoad(ProductLoad newLoad) {
		totalValue += newLoad.getValue(); // Adds to Total Value
		totalWeight += newLoad.getWeight(); // Adds to Total Weight
		if(newLoad.getIsDangerous() == true)
			totalDangerous++; // Increments totalDangerous for the Train if it is.
	}
	/**
	 * This method removes the TrainCarNode referenced by the cursor and returns the 
	 * TrainCar contained within the node.
	 * <dt><b>Preconditions:</b><dd>
	 * The cursor is not null.
	 * <dt><b>Postconditions:</b><dd>
	 * The TrainCarNode referenced by the cursor has been removed from the train.
	 * The cursor now references the next node, or the previous node if no next node exists.
	 */
	public TrainCar removeCursor() {
		TrainCarNode tempRemove = cursor;
		if(cursor == null) {
			System.out.println("What are you trying to remove???");
			System.out.println();
			return null;
		}
		else {
			if (cursor == head && cursor == tail) {
				head = null;
				tail = null;
				cursor = null;
			}
			else if(cursor == head && cursor != tail) {
				head = cursor.getNext();
				cursor = cursor.getNext();
				cursor.setPrev(null);
			}
			else if(cursor != head && cursor == tail) {
				tail = cursor.getPrev();
				cursor = cursor.getPrev();
				cursor.setNext(null);
			}
			else {
				cursor.getPrev().setNext(cursor.getNext());
				cursor.getNext().setPrev(cursor.getPrev());
				cursor = cursor.getNext();
			}
			totalSize--; // Decrements Size for the train
			totalLength -= tempRemove.getCar().getCarLength(); // Removes from Total Length
			totalWeight -= tempRemove.getCar().getCarWeight(); // Removes from Total Weight
			if(tempRemove.getCar().getProductLoad() != null) {
				decrementProductLoad(tempRemove.getCar().getProductLoad());
			}
		}
		return tempRemove.getCar();
	}
	/**
	 * This extra method decrements Total Length, Total Value, and Total Weight for the respective product loads.
	 * @param NewLoad
	 * The product load to be used.
	 */
	public void decrementProductLoad(ProductLoad newLoad) {
		totalValue -= newLoad.getValue();
		totalWeight -= newLoad.getWeight();
		if(newLoad.getIsDangerous() == false)
			totalDangerous--;
	}
	/**
	 * This method determines the number of TrainCar objects currently on the train.
	 * @return
	 * The number of TrainCar objects on the train.
	 * This function should complete in O(1) time.
	 */
	public int size() {
		return totalSize;
	}
	
	/**
	 * Returns the total length of the train in meters.
	 * @return
	 * The sum of the lengths of each TrainCar in the train.
	 * This function should complete in O(1) time.
	 */
	public double getLength() {
		return totalLength;
	}
	
	/**
	 * Returns the total value of the product carried by the train/
	 * @return
	 * The sum of the values of each TrainCar in the train.
	 * Note: This function should complete in O(1) time.
	 */
	public double getValue() {
		return totalValue;
	}
	
	/**
	 * Returns the total weight of the product carried by the train.
	 * Note that the weight of the train is the sum of the weights of each empty TrainCar,
	 * and the weight of the ProductLoad carried by the car.
	 * @return
	 * The sum of the weight of each TrainCar plus the sum of the ProductLoad by the car.
	 * Note: This function should complete in O(1) time.
	 */
	public double getWeight() {
		return totalWeight;		
	}
	
	/**
	 * Whether or not there is a dangerous product on one of the TrainCar objects on the train.
	 * @return
	 * Returns true if the train contains at least one TrainCar carrying a dangerous ProductLoad. False otherwise
	 * Note: This function should complete in O(1) time.
	 */
	public boolean isDangerous() {
		if(totalDangerous > 0)
			return true;
		else
			return false;
	}
	/**
	 * Searches the list for all ProductLoad objects with the indicated name and sums together
	 * their weight and value, then prints a single ProductLoad record to the console.
	 * @param name
	 * The name of the ProductLoad to find on the train.
	 */
	public void findProduct(String name) {
		TrainCarNode findProductNode = head;
		if(size() == 0) {
			System.out.println("There are no cars on the train.");
			System.out.println();
		}
		else {
			int productNumber = 0;
			boolean findDangerous = false;
			double findWeight = 0;
			double findValue = 0;
			while(findProductNode != null) {
				if(findProductNode.getCar().getProductLoad() != null) {
					if(findProductNode.getCar().getProductLoad().getProductName().equals(name)) {
						productNumber++;
						findWeight += findProductNode.getCar().getProductLoad().getWeight();
						findValue += findProductNode.getCar().getProductLoad().getValue();
						if(findProductNode.getCar().getProductLoad().getIsDangerous() == true)
							findDangerous = true;
					}
				}
				findProductNode = findProductNode.getNext();
			}
			if(productNumber == 0) {
				System.out.println("No record of " + name + " on board train.");
				}
			else {
				System.out.println("        Name      Weight (t)     Value ($)   Dangerous");
				System.out.println("    ===================================================");
				System.out.printf("%14s%14.1f%14.2f", name, findWeight, findValue);
				if(findDangerous)
					System.out.print("         YES");
				else
					System.out.print("          NO");
			}
			System.out.println();
		}
					
	}
	/**
	 * Prints a neatly formatted table of the car number, length, name, weight, etc. for all 
	 * the cars on the train.
	 * Note: There should be a record for each TrainCar printed to the console.
	 */
	public void printManifest() {
		TrainCarNode printAllNode = head;
		if(size() == 0) {
			System.out.println("There are no cars on the train.");
			System.out.println();
		}
		else {
			System.out.println("    CAR:                               LOAD:");
			System.out.println("      Num   Length (m)    Weight (t)  |    Name      Weight (t)     "
					+ "Value ($)   Dangerous");
			System.out.println("    ==================================+===================================================");
			int size = 1;
			while(printAllNode != null) {
				String toPrint = "";
				if(printAllNode == cursor)
					toPrint += " ->   ";
				else
					toPrint += "      ";
				toPrint += String.format(" %-11d%-12.1f  %-6.1f",size,printAllNode.getCar().getCarLength()
				  ,printAllNode.getCar().getCarWeight());
				if(printAllNode.getCar().getProductLoad() == null)
					toPrint += "|    Empty           0.0          0.00           NO";
				else {
					toPrint += String.format("|     %-13s%-11.1f%-19.2f",printAllNode.getCar().getProductLoad().getProductName(),
					  printAllNode.getCar().getProductLoad().getWeight(), printAllNode.getCar().getProductLoad().getValue()); 
					if(printAllNode.getCar().getProductLoad().getIsDangerous() == true)
						toPrint += "YES";
					else
						toPrint += "NO";
				}
				System.out.println(toPrint);
				printAllNode = printAllNode.getNext();
				size++;
			}
			System.out.println();
		}
	}
	/**
	 * Removes all dangerous cars from the train, maintaining its oder.
	 * <dt><b>Postconditions:</b><dd>
	 * All dangerous cars have been removed from the train.
	 * The order of all non-dangerous cars must be maintained upon the completion of the 
	 * method.
	 * Note: All dangerous cars may be discarded after calling this method.
	 */
	public void removeDangerousCars() {
		TrainCarNode removeDangerousNode = head;
		if(size() == 0) {
			System.out.println("There are no cars on the train.");
			System.out.println();
		}
		else {
			int removedOrNot = 0;
			while(removeDangerousNode != null) {
				if(removeDangerousNode.getCar().getProductLoad() != null) {
					if(removeDangerousNode.getCar().getProductLoad().getIsDangerous()) {
						if (removeDangerousNode == head && removeDangerousNode == tail) {
							head = null;
							tail = null;
							cursor = null;
						}
						else if(removeDangerousNode  == head && removeDangerousNode  != tail) {
							head = head.getNext();
							head.setPrev(null);
						
						}
						else if(removeDangerousNode  != head && removeDangerousNode  == tail) {
							tail = tail.getPrev();
							tail.setNext(null);						
						}
						else {
							removeDangerousNode.getPrev().setNext(removeDangerousNode.getNext());
							removeDangerousNode.getNext().setPrev(removeDangerousNode.getPrev());
						}
						totalSize--; //Decrements Total Size for the Train
						totalLength -= removeDangerousNode.getCar().getCarLength(); // Removes from Total Length
						totalWeight -= removeDangerousNode.getCar().getCarWeight(); // Removes from Total Weight
						decrementProductLoad(removeDangerousNode.getCar().getProductLoad());
						removedOrNot++;
					}
				}
				removeDangerousNode = removeDangerousNode.getNext();
			}
			if(removedOrNot == 0) {
				System.out.println("There's nothing dangerous on the train!");
				System.out.println();
			}
			else {
				System.out.println("Dangerous cars successfully removed from the train.");
				System.out.println();
			}
		}
	}
	/**
	 * Returns a neatly formatted String representation of the overall train.
	 * @return
	 * A neatly formatted string containing info about the train, including its size, length,
	 * weight in tons, value in dollars, and whether it is dangerous or not.
	 */
	public String toString() {
		String string = "";
		if(totalDangerous > 0) {
			string += "Train: " + size() + " car(s), " + totalLength + " meters, " + 
					totalWeight + " tons, $" + totalValue + " value, " + "DANGEROUS";
		}
		else {
			string += "Train: " + size() + " car(s), " + totalLength + " meters, " + 
			totalWeight + " tons, $" + totalValue + " value, " + "NOT DANGEROUS"; }
		return string;
}
}
