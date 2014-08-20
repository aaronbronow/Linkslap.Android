package Linkslap.Android.Communication.Interfaces;

import rx.Observable;
import Linkslap.Android.Communication.Models.GifMeModel;

public interface IGifStore {
	Observable<GifMeModel> Search(String query, Boolean nsfw);
	Observable<GifMeModel> Search(String query, Boolean nsfw, Integer page);
}
