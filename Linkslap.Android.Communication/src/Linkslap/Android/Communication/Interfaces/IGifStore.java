package Linkslap.Android.Communication.Interfaces;

import Linkslap.Android.Communication.Models.GifMeModel;

public interface IGifStore {
	GifMeModel Search(String query, Boolean nsfw);
	GifMeModel Search(String query, Boolean nsfw, Integer page);
}
