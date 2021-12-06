package domain;

import java.io.Serializable;

public class User implements Serializable {

	private String UserAccount; //用户账号
	private String UserPassword; //用户密码
	private String UserEmail; //用户邮箱

	public String getUserAccount() {
		return UserAccount;
	}

	public void setUserAccount(String UserAccount) {
		this.UserAccount = UserAccount;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String UserPassword) {
		this.UserPassword = UserPassword;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String UserEmail) {
		this.UserEmail = UserEmail;
	}

	@Override
	public String toString() {
		return "User [UserAccount=" + UserAccount + ", UserPassword=" + UserPassword + ", UserEmail=" + UserEmail + "]";
	}

}
