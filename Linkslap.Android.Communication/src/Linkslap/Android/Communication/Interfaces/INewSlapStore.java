package Linkslap.Android.Communication.Interfaces;

import Linkslap.Android.Communication.Models.Link;

public interface INewSlapStore {
	Iterable<Link> Links(); 
	void AddLink(Link link);
	void RemoveLink(Integer id);
	void Clear();
}
