import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;
import Linkslap.Android.Communication.Interfaces.IAccountStore;
import Linkslap.Android.Communication.Models.Account;
import Linkslap.Android.Communication.Models.RegisterModel;
import Linkslap.Android.Communication.Util.Storage;

public class AccountStore implements IAccountStore {
	
	private AccountRestService accountRestService;
	
	public AccountStore() {
		Rest rest = new Rest();
		this.accountRestService = rest.GetService(AccountRestService.class);
	}
	
	@Override
	public Observable<Account> Authenticate(String userName, String password) {		
		return accountRestService.Login(userName, password, "password");
	}

	@Override
	public Account Get() {
		return Storage.Load("account");
	}

	@Override
	public Observable<?> Register(RegisterModel user) {
		return this.accountRestService.Register(user);
	}

	@Override
	public Observable<Boolean> ResetPassword(String email) {
		return this.accountRestService.ResetPassword(email);
	}

	private interface AccountRestService {
		
		@FormUrlEncoded
		@GET("/token")
		Observable<Account> Login(@Field("username")String username, @Field("password")String password, @Field("grant_type")String grantType);
				
		@POST("/api/account/register")
		Observable<?> Register(@Body RegisterModel model);
		
		@POST("/api/account/resetpassword")
		Observable<Boolean> ResetPassword(@Body String email);
	}
}
