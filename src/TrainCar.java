/**
* The <code>TrainCar</code> class implements <code>TrainCar<code>
* objects.
*
*
* @author K. K. G.
*    e-mail: kevin.gabayan@stonybrook.edu
*    Stony Brook ID: 111504873
**/
public class TrainCar {
	private double carLength;
	private double carWeight;
	private ProductLoad load;
	/**
	 * TrainCar Variables
	 * @param carLength
	 * The car length of a train car in meters expressed as a double.
	 * @param carWeight
	 * The weight of the car in tons expressed as a double.
	 * @param load
	 * A load reference to the ProductLoad. The load variable may be null.
	 */
	/**
	 * This is a constructor for the creation of a TrainCar.
	 * @param carWeight
	 * @param carLength
	 */
	public TrainCar(double carWeight, double carLength) {
		this.carWeight = carWeight;
		this.carLength = carLength;
	}
	/**
	 * This method retrieves the weight of the car.
	 * @return 
	 * The weight of the car.
	 */
	public double getCarWeight() {
		return carWeight;
	}
	/**
	 * This method retrieves the length of the car.
	 * @return
	 * The length of the car.
	 */
	public double getCarLength() {
		return carLength;
	}
	/**
	 * This method retrieves the product load of the car.
	 * @return
	 * The product load of the car.
	 */
	public ProductLoad getProductLoad() {
		return load;
	}
	/**
	 * This method sets a new load of the product.
	 * @param load
	 * The new load of the product.
	 */
	public void setProductLoad(ProductLoad load) {
		this.load = load;
	}
	/**
	 * This method tells you if the Train Car is empty or not.
	 * @return
	 * If the Train Car is empty or not.
	 */
	public boolean isEmpty() {
		if(load == null)
			return true;
		else
			return false;
	}
}
