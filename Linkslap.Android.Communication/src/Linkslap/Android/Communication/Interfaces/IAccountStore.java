package Linkslap.Android.Communication.Interfaces;

import rx.Observable;
import Linkslap.Android.Communication.Models.Account;
import Linkslap.Android.Communication.Models.RegisterModel;

public interface IAccountStore {
	Account Authenticate(String userName, String password);
	Account Get();
	Observable<?> Register(RegisterModel user);
	Observable<Boolean> ResetPassword(String email);
}
