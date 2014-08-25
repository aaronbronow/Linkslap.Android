package Linkslap.Android.Communication;
import java.util.ArrayList;

import Linkslap.Android.Communication.Interfaces.INewSlapStore;
import Linkslap.Android.Communication.Interfaces.ISettingsStore;
import Linkslap.Android.Communication.Models.Link;
import Linkslap.Android.Communication.Util.EventHandler;
import Linkslap.Android.Communication.Util.Storage;

public class NewSlapStore implements INewSlapStore {
	private final String Key = "new-slaps";
	
	private ISettingsStore settingsStore;
	
	public NewSlapStore() {
		this(new SettingsStore());
	}
	
	public NewSlapStore(ISettingsStore settingsStore) {
		this.settingsStore = settingsStore;
	}
	
	public static EventHandler<Link> NewSlapsChanged = new EventHandler<Link>();

	@Override
	public ArrayList<Link> Links() {
		ArrayList<Link> output = Storage.Load(Key);
		
		if (output == null) {
			output = new ArrayList<Link>();
		}
		
		return output;
	}

	@Override
	public void AddLink(Link link) {
		if (!this.settingsStore.ShowInNewLinks(link.StreamKey)) {
			NewSlapsChanged.Trigger(link);
			return;
		}
		
		ArrayList<Link> links = this.Links();
		
		for(Link item : links){
			if (item.Id != link.Id) {
				continue;
			}
			
			NewSlapsChanged.Trigger(link);
			return;
		}
		
		links.add(link);
		Storage.Save(Key, links);
		
		this.UpdateBadge(links);
		NewSlapsChanged.Trigger(link);
	}

	@Override
	public void RemoveLink(Integer id) {
		ArrayList<Link> links = this.Links();
		Link linkToRemove = null;
		
		for (Link link : links) {
			if (link.Id == id) {
				linkToRemove = link;
				break;
			}
		}
		
		links.remove(linkToRemove);
		Storage.Save(Key, links);
		
		this.UpdateBadge(links);
		NewSlapsChanged.Trigger(linkToRemove);
	}

	@Override
	public void Clear() {
		ArrayList<Link> links = new ArrayList<Link>();
        Storage.Save(Key, links);

        this.UpdateBadge(links);

        NewSlapsChanged.Trigger(null);
	}
	
	private void UpdateBadge(ArrayList<Link> links){
		// TODO send toast and stuff....
	}
}
