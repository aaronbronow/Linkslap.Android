package Linkslap.Android.Communication.Interfaces;

import Linkslap.Android.Communication.Models.SubscriptionSettings;

public interface ISettingsStore {
	Boolean DisableAllNotifications(Boolean value);
	Boolean DisableAllNotifications();
	Iterable<SubscriptionSettings> SubscriptionSettings();
	Boolean ShowPushNotifications(String streamKey);
	Boolean ShowInNewLinks(String streamKey);
	void SaveSubscriptionSettings();
	void RemoveSubscriptionSetting(Integer subscriptionId);
}
