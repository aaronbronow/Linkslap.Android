package Linkslap.Android.Communication.Models;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Account {
	@SerializedName("id")
	public String Id;
	
	@SerializedName("userName")
	public String UserName;
	
	@SerializedName("email")
	public String Email;
	
	@SerializedName("access_token")
	public String BearerToken;
	
	@SerializedName(".issued")
	public Date TokenIssued;
	
	@SerializedName(".expires")
	public Date TokenExpires;
}
