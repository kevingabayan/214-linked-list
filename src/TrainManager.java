/**
* The <code>TrainManager</code> class implements the code that allows one to launch the program successfully
* with all other classes.
*
*
* @author K. K. G.
*    e-mail: kevin.gabayan@stonybrook.edu
*    Stony Brook ID: 111504873
**/
import java.util.InputMismatchException;
import java.util.Scanner;
public class TrainManager {
	/**
	 * This method generates the menu.
	 */
	public static void menuGeneration() {
		System.out.println("(F) Cursor Forward");
		System.out.println("(B) Cursor Backward");
		System.out.println("(I) Insert Car After Cursor");
		System.out.println("(R) Remove Car At Cursor");
		System.out.println("(L) Set Product Load");
		System.out.println("(S) Search For Product");
		System.out.println("(T) Display Train");
		System.out.println("(M) Display Manifest");
		System.out.println("(D) Remove Dangerous Cars");
		System.out.println("(Q) Quit");
		System.out.println();
		System.out.print("Enter a selection: ");
	}
	/**
	 * This is the main method for each option in the menu.
	 */
	public static void main(String[] args) throws InputMismatchException {
		TrainLinkedList trainCar = new TrainLinkedList();
		Scanner input = new Scanner(System.in);
		menuGeneration();
		String selection = input.nextLine();
		System.out.println();
		boolean end = false;
		double carLength;
		double carWeight;
		while(end == false) {
			// Move the Cursor Forward
			if(selection.equals("F") || selection.equals("f")) {
				trainCar.cursorForward();
			}
			// Move the Cursor Backward
			else if(selection.equals("B") || selection.equals("b")) {
				trainCar.cursorBackward();
			}
			// Insert Car After Cursor
			else if(selection.equals("I") || selection.equals("i")) {
				try {
				System.out.print("Enter car length in meters: ");
				carLength = input.nextDouble();
				if(carLength < 0) {
					System.out.println();
					System.out.println("That makes no sense!?? Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
				System.out.print("Enter car weight in tons: ");
				carWeight = input.nextDouble();
				if(carWeight < 0) {
					System.out.println();
					System.out.println("That makes no sense!?? Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				TrainCar newCar = new TrainCar(carWeight, carLength);
				trainCar.insertAfterCursor(newCar);
				System.out.println();
				System.out.println("New train car " + carLength + " meters " + carWeight
				  + " tons inserted into train.");
				input.nextLine();
				System.out.println();
			}
			// Remove Car At Cursor
			else if(selection.equals("R") || selection.equals("r")) {	
				TrainCar toPrint = trainCar.removeCursor();
				if(toPrint != null) {
					System.out.println("Car successfully unlinked. The following load has been"
							+ " removed from the train.");
						System.out.println("        Name      Weight (t)     Value ($)   Dangerous");
						System.out.println("    ===================================================");
						if(toPrint.getProductLoad() != null) {
							System.out.printf("%14s%14.1f%14.2f", toPrint.getProductLoad().getProductName(), toPrint.getProductLoad().getWeight(),
									toPrint.getProductLoad().getValue());
							if(toPrint.getProductLoad().getIsDangerous()) 
								System.out.print("         YES\n");
							else
								System.out.print("          NO\n");
						}
						else {
							System.out.print("        Empty           0.0          0.00           NO\n");
				}
				}
			}
			// Set Product Load
			else if(selection.equals("L") || selection.equals("l")) {
				if(trainCar.size() == 0) {
					System.out.println("There are no cars on the train??");
					System.out.println();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				System.out.print("Enter produce name: ");
				String loadName = input.nextLine();
				double productWeight;
				double productValue;
				boolean booleanDangerous;
				try {
				System.out.print("Enter product weight in tons: ");
				productWeight = input.nextDouble();
				if(productWeight <= 0) {
					System.out.println();
					System.out.println("That makes no sense!?? Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.print("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
				System.out.print("Enter product value in dollars: ");
				productValue = input.nextDouble();
				if(productValue <= 0) {
					System.out.println();
					System.out.println("That makes no sense!?? Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.print("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
				System.out.print("Enter if the product is dangerous or not (y/n): ");
				input.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.print("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				String dangerousOrNot = input.nextLine();
				if(dangerousOrNot.equals("y") || dangerousOrNot.equals("Y"))
					booleanDangerous = true;
				else if(dangerousOrNot.equals("N") || dangerousOrNot.equals("n"))
					booleanDangerous = false;
				else {
					System.out.println("\nInvalid input! Returning to main menu.\n");
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				ProductLoad newLoad = new ProductLoad(loadName, productWeight,productValue, booleanDangerous);
				trainCar.getCursorData().setProductLoad(newLoad);
				trainCar.incrementProductLoad(newLoad);
				System.out.println();
				System.out.println(productWeight + " tons of " + loadName + " added to the curent car.");
				System.out.println();
			}
			// Search For Product 
			else if(selection.equals("S") || selection.equals("s")) {
				System.out.print("Enter product name: ");
				String productName = input.nextLine();
				System.out.println();
				trainCar.findProduct(productName);
			}
			// Display Train
			else if(selection.equals("T") || selection.equals("t")) {
				System.out.println(trainCar.toString());
				System.out.println();
			}
			// Display Manifest
			else if(selection.equals("M") || selection.equals("m")) {
				trainCar.printManifest();
			}
			// Remove Dangerous Cars
			else if(selection.equals("D") || selection.equals("d")) {
				trainCar.removeDangerousCars();
			}
			// Quit The Program
			else if (selection.equals("Q") || selection.equals("q")) {
				end = true;
				System.out.print("Program terminating succesfully...");
				continue;
			}
			else {
				System.out.println("Invalid command. Try again!");
				System.out.println();
			}
			menuGeneration();
			selection = input.nextLine();
			System.out.println();
		}
	}
}
