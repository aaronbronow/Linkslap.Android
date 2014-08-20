package Linkslap.Android.Communication.Models;

import java.util.Date;

import android.R.bool;

public class GifMeModel {
	public int Status;
	public GifMeMeta Meta;
	public Iterable<GifMeResult> Results;
		
	public class GifMeMeta
	{
		public String Term;
		public int Limit;
		public int Page;
		public int TotalPages;
		public int Total;
		public String Timing;
	}
	
	public class GifMeResult
	{
		public int Id;
		public String Score;
		public bool NSFW;
		public String Link;
		public String Thumb;
		public Date CreatedAt;
	}
}
