package domain;

import java.io.Serializable;

public class Cart implements Serializable {

    private String UserAccount;
    private String ProductName;
    private double ProductPrice;
    private int ProductNumber;

    public Cart(String userAccount, String productName, double productPrice, int productNumber) {
        UserAccount = userAccount;
        ProductName = productName;
        ProductPrice = productPrice;
        ProductNumber = productNumber;
    }

    public Cart() {
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String userAccount) {
        UserAccount = userAccount;
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

    public int getProductNumber() {
        return ProductNumber;
    }

    public void setProductNumber(int productNumber) {
        ProductNumber = productNumber;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "UserAccount='" + UserAccount + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", ProductPrice=" + ProductPrice +
                ", ProductNumber=" + ProductNumber +
                '}';
    }
}
