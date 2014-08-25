package Linkslap.Android.Communication;

import Linkslap.Android.Communication.Interfaces.IGifStore;
import Linkslap.Android.Communication.Models.GifMeModel;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public class GifStore implements IGifStore {
	private GifRestService gifRestService;
	
	public GifStore() {
		Rest rest = new Rest("http://api.gifme.io");
		this.gifRestService = rest.GetService(GifRestService.class);
	}
	
	public Observable<GifMeModel> Search(String query, Boolean nsfw) {
		return this.Search(query, nsfw, 0);
	}
	public Observable<GifMeModel> Search(String query, Boolean nsfw, Integer page) {
		return this.gifRestService.Search(query, !nsfw, page);
	}
	
	private interface GifRestService {
		
		@GET("/v1/search?key=MNfCaCC9tRAr3yzf&limit=20")
		Observable<GifMeModel> Search(@Query("query")String query, @Query("swf")Boolean sfw, @Query("page")Integer page);
	}
}
