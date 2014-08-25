package Linkslap.Android.Communication;
import rx.Observable;
import Linkslap.Android.Communication.Interfaces.ISettingsStore;
import Linkslap.Android.Communication.Interfaces.ISubscriptionStore;

import Linkslap.Android.Communication.Models.Subscription;
import Linkslap.Android.Communication.Models.SubscriptionSettings;

public class SettingsStore implements ISettingsStore {
	
	private final static String Key = "SettingsStore";
	
	private ISubscriptionStore subscriptionStore;
	
	public SettingsStore()
	{
		this(new SubscriptionStore());
	}
	
	public SettingsStore(ISubscriptionStore subscriptionStore)
	{
		this.subscriptionStore = subscriptionStore;
		
		// Observable<Subscription> allSubscriptions = this.subscriptionStore.GetSubscriptions();
		
	}
	
	@Override
	public Boolean DisableAllNotifications(Boolean value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean DisableAllNotifications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<Iterable<SubscriptionSettings>> SubscriptionSettings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean ShowPushNotifications(String streamKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean ShowInNewLinks(String streamKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SaveSubscriptionSettings() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveSubscriptionSetting(Integer subscriptionId) {
		// TODO Auto-generated method stub
		
	}
}
