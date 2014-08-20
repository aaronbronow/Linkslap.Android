import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
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
	public Account Authenticate(String userName, String password) {		
		return accountRestService.Login(userName, password, "password");
	}

	@Override
	public Account Get() {
		return Storage.Load("account");
	}

	@Override
	public void Register(RegisterModel user) {
		this.accountRestService.Register(user);
	}

	@Override
	public Boolean ResetPassword(String email) {
		return this.accountRestService.ResetPassword(email);
	}

	private interface AccountRestService {
		
		@FormUrlEncoded
		@GET("/token")
		Account Login(@Field("username")String username, @Field("password")String password, @Field("grant_type")String grantType);
				
		@POST("/api/account/register")
		void Register(@Body RegisterModel model);
		
		@POST("/api/account/resetpassword")
		Boolean ResetPassword(@Body String email);
	}
}
