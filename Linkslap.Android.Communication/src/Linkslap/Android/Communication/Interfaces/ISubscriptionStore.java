package Linkslap.Android.Communication.Interfaces;

import Linkslap.Android.Communication.Models.Subscription;

public interface ISubscriptionStore {
	Iterable<Subscription> GetSubscriptions();
	Subscription Add(String streamKey);
	void Delete(String streamKey);
	Subscription GetSubscription(Integer id);
	Subscription GetSubscription(String streamKey);
}
