package entity;

public class Cart {
	private String username;
	private String image;
	private String namebook;
	private double price;
	
	public Cart(String username, String image, String namebook, double price) {
		super();
		this.username = username;
		this.image = image;
		this.namebook = namebook;
		this.price = price;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNamebook() {
		return namebook;
	}

	public void setNamebook(String namebook) {
		this.namebook = namebook;
	}

	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}	
	

}
