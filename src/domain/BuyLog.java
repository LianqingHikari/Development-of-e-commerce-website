package domain;

public class BuyLog {
    private String UserAccount;
    private String ProductName;
    private int ProductNumber;
    private String BrowseTime;

    public BuyLog(String userAccount, String productName, int productNumber, String browseTime) {
        UserAccount = userAccount;
        ProductName = productName;
        ProductNumber = productNumber;
        BrowseTime = browseTime;
    }

    public BuyLog() {
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

    public String getBrowseTime() {
        return BrowseTime;
    }

    public void setBrowseTime(String browseTime) {
        BrowseTime = browseTime;
    }

    public int getProductNumber() {
        return ProductNumber;
    }

    public void setProductNumber(int productNumber) {
        ProductNumber = productNumber;
    }
}
