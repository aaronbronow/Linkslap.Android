package Linkslap.Android.Communication;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import Linkslap.Android.Communication.Models.Account;
import Linkslap.Android.Communication.Util.AppSettings;
import Linkslap.Android.Communication.Util.Storage;

public class Rest {
	private String baseUrl;
	
	private String bearerToken; 
	
	private RestAdapter restAdapter;
	
	public Rest() {
		this(AppSettings.BaseUrl);
		
		Account account = Storage.Load("account");
		
		if (account != null)
		{
			this.bearerToken = account.BearerToken;
		}
	}
	
	public Rest(String baseUrl) {
		this.baseUrl = baseUrl;
		
		RestAdapter.Builder builder = new RestAdapter.Builder()
	    								.setEndpoint(this.baseUrl);
		
		if (this.bearerToken != null && this.bearerToken != "") {
			RequestInterceptor requestInterceptor = new RequestInterceptor() {
				  @Override
				  public void intercept(RequestFacade request) {
				    request.addHeader("Authorization", "Bearer " + Rest.this.bearerToken);
				  }
				};
			
			builder.setRequestInterceptor(requestInterceptor);
		}
		
		this.restAdapter = builder.build();
	}
	
	public <TType> TType GetService(Class<TType> clazz) {
		return this.restAdapter.create(clazz);
	}
}
