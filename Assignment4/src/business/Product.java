package business;

public class Product {
	private int productId;
	private String productName;
	private double listPrice;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getListPrice() {
		return listPrice;
	}
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}
	@Override
	public String toString() {
		return "ID: " + productId + ", name: " + productName + ", price: " + listPrice + "\n";
	}
}
