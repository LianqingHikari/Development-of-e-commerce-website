package domain;

public class BrowseLog {
        private String UserAccount;
        private String ProductName;
        private String BrowseTime;

    public BrowseLog(String userAccount, String productName, String browseTime) {
        UserAccount = userAccount;
        ProductName = productName;
        BrowseTime = browseTime;
    }

    public BrowseLog() {
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
}
