package Linkslap.Android.Communication.Models;

import com.google.gson.annotations.SerializedName;

public class RegisterModel {
	@SerializedName("email")
	public String Email;
	
	@SerializedName("userName")
	public String UserName;
	
	@SerializedName("password")
	public String Password;
	
	@SerializedName("confirmPassword")
	public String ConfirmPassword;
}
