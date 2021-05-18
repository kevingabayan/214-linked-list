/**
* The <code>TrainCarNode</code> class implements <code>TrainCarNode<code>
* objects.
*
*
* @author K. K. G.
*    e-mail: kevin.gabayan@stonybrook.edu
*    Stony Brook ID: 111504873
**/
public class TrainCarNode {
	private TrainCarNode prev;
	private TrainCarNode next;
	private TrainCar car;
	/**
	 * TrainCarNode Variables:
	 * @param prev
	 * A reference for the previous node in the chain.
	 * @param next
	 * A reference for the next node in the chain.
	 * @param car
	 * A reference for the TrainCar variable containing the data.
	 */
	/**
	 * An empty constructor for the creation of a TrainCarNode.
	 */
	public TrainCarNode() {
	}
	/**
	 * A constructor method for creating a TrainCarNode with custom values.
	 */
	public TrainCarNode(TrainCar car) {
		this.car = car;
	}
	/**
	 * A method for obtaining the reference to the previous node in the chain.
	 * @return
	 * The reference for the previous node in the chain.
	 */
	public TrainCarNode getPrev() {
		return prev;
	}
	/**
	 * A method for obtaining the reference to the next node in the chain.
	 * @return
	 * The reference for the next node in the chain.
	 */
	public TrainCarNode getNext() {
		return next;
	}
	/**
	 * A method for obtaining the train car reference variable containing the data.
	 * @return
	 * The reference to the train car variable containing the data.
	 */
	public TrainCar getCar() {
		return car;
	}
	/**
	 * A method for setting the reference to the previous node in the chain.
	 * @param prev
	 * The new reference to the previous node in the train.
	 */
	public void setPrev(TrainCarNode prev) {
		this.prev = prev;
	}
	/**
	 * A method for setting the reference to the next node in the chain.
	 * @param next
	 * The new reference to the next node in the train.
	 */
	public void setNext(TrainCarNode next) {
		this.next = next;
	}
	/**
	 * A method for setting the reference to the train car reference containing the data.
	 * @param car
	 */
	public void setCar(TrainCar car) {
		this.car = car;
	}
}
