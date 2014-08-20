package Linkslap.Android.Communication.Interfaces;

import Linkslap.Android.Communication.Models.Link;
import Linkslap.Android.Communication.Models.Stream;

public interface IStreamStore {
	Stream NewStream(String streamName);
	Iterable<Link> GetStreamLinks(String streamKey);
	Link SlapLink(String streamKey, String comment, String url);
}
