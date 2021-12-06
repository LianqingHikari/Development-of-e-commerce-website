package domain;

public class Product {
    private static final long serialVersionUID = 1L;
	private String ProductName; // 名称
	private double ProductPrice; // 价格
	private String ProductDescription; // 描述
	private String ProductType;//类型
	private String ProductPictureName;//类型
	private int ProductSale;//类型

	public Product(String productName, double productPrice, String productDescription, String productType, String productPictureName, int productSale) {
		ProductName = productName;
		ProductPrice = productPrice;
		ProductDescription = productDescription;
		ProductType = productType;
		ProductPictureName = productPictureName;
		ProductSale = productSale;
	}

	public Product() {
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public double getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}

	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}

	public String getProductType() {
		return ProductType;
	}

	public void setProductType(String productType) {
		ProductType = productType;
	}

	public String getProductPictureName() {
		return ProductPictureName;
	}

	public void setProductPictureName(String productPictureName) {
		ProductPictureName = productPictureName;
	}

	public int getProductSale() {
		return ProductSale;
	}

	public void setProductSale(int productSale) {
		ProductSale = productSale;
	}

	@Override
	public String toString() {
		return "Product{" +
				"ProductName='" + ProductName + '\'' +
				", ProductPrice=" + ProductPrice +
				", ProductDescription='" + ProductDescription + '\'' +
				", ProductType='" + ProductType + '\'' +
				", ProductPictureName='" + ProductPictureName + '\'' +
				", ProductSale='" + ProductSale + '\'' +
				'}';
	}

}
