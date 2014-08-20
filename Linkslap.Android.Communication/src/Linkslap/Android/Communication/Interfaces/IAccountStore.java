package Linkslap.Android.Communication.Interfaces;

import Linkslap.Android.Communication.Models.Account;
import Linkslap.Android.Communication.Models.RegisterModel;

public interface IAccountStore {
	Account Authenticate(String userName, String password);
	Account Get();
	void Register(RegisterModel user);
	Boolean ResetPassword(String email);
}
