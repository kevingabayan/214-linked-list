/**
* The <code>ProductLoad</code> class implements <code>ProductLoad<code>
* objects.
*
*
* @author K. K. G.
*    e-mail: kevin.gabayan@stonybrook.edu
*    Stony Brook ID: 111504873
**/
public class ProductLoad {
	private String productName = "";
	private double weight = 0;
	private double value = 0;
	private boolean isDangerous = true;
	
	/**
	 * ProductLoad Variables
	 * @param productName
	 * The name of the product represented as a string.
	 * @param weight
	 * The weight of the product represented in tons.
	 * @param value
	 * The value of the product in dollars.
	 * @param isDangerous
	 * Whether or not the product contains any dangerous product loads.
	 */
	
	/**
	 * This is a constructor for making a new ProductLoad with default values.
	 */
	public ProductLoad() {
	}
	/**
	 * This is a constructor for making a new ProductLoad with custom values.
	 */
	public ProductLoad(String productName, double weight, double value, boolean isDangerous) {
		this.productName = productName;
		this.weight = weight;
		this.value = value;
		this.isDangerous = isDangerous;
	}
	/**
	 * This method retrieves the product name.
	 * @return
	 * The product name.
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * This method retrieves the product weight.
	 * @return
	 * The weight of the product.
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * This method retrieves the value of the product in dollars.
	 * @return
	 * The value of the product.
	 */
	public double getValue() {
		return value;
	}
	/**
	 * This method tells you if the product is dangerous or not.
	 * @return
	 * If the product is dangerous or not.
	 */
	public boolean getIsDangerous() {
		return isDangerous;
	}
	/**
	 * This is a method for modifying the name of the product.
	 * @param newName
	 * The new name of the product.
	 */
	public void setProductName(String newName) {
		productName = newName;
	}
	/**
	 * This is a method for modifying the weight of the product.
	 * @param newWeight
	 * The new weight of the product.
	 * @throws IllegalArgumentException
	 * Indicates that the weight cannot be negative.
	 */
	public void setWeight(double newWeight) throws IllegalArgumentException {
		if(newWeight >= 0) {
			weight = newWeight;
		}
		else
			throw new IllegalArgumentException("Weight cannot be negative!");
	}
	/**
	 * This is a method for modifying the value of the product.
	 * @param newValue
	 * The new value of the product.
	 * @throws IllegalArgumentException
	 * Indicates that the value cannot be negative.
	 */
	public void setValue(double newValue) throws IllegalArgumentException {
		if(newValue >= 0) {
			value = newValue;
		}
		else
			throw new IllegalArgumentException("Value cannot be negative!");
	}
	/**
	 * This is a method that sets a new value for whether or not the product is dangerous.
	 * @param newDangerous
	 * The new boolean value of the product.
	 */
	public void setIsDangerous(boolean newDangerous) {
		isDangerous = newDangerous;
	}
}
