import java.io.IOException;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.microsoft.windowsazure.notifications.NotificationsHandler;
import com.microsoft.windowsazure.notifications.NotificationsManager;

import retrofit.http.Body;
import retrofit.http.POST;
import Linkslap.Android.Communication.Models.PushRegistration;
import Linkslap.Android.Communication.Util.AppSettings;
import Linkslap.Android.Communication.Util.EventHandler;
import Linkslap.Android.Communication.Util.Storage;


public class NotificationStore {
	private static GoogleCloudMessaging gcm;
	private static RegisterRestService registerRestService;
	private static PushRegistration registration;
	
	public static EventHandler<String> PushNotificationReceived;
	
	static {
		NotificationsManager.handleNotifications(AppSettings.Context, AppSettings.SenderId, MyHandler.class);
		gcm = GoogleCloudMessaging.getInstance(AppSettings.Context);
		PushNotificationReceived = new EventHandler<String>();
		Rest rest = new Rest();
		registerRestService = rest.GetService(RegisterRestService.class); 
		
		String regid = null;
		try {
			regid = gcm.register(AppSettings.SenderId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        registration = new PushRegistration();
        registration.InstallationId = Storage.GetInstallationId();
        registration.DeviceToken = regid;
	}
	
	public static void Register(){
		new AsyncTask<Object, Object, Object>() {
		      @Override
		      protected Object doInBackground(Object... params) {
		      	registerRestService.Register(registration);
				return null;
		     }
		   }.execute(null, null, null);
	}
		
	public static void UnRegister(){
		new AsyncTask<Object, Object, Object>() {
		      @Override
		      protected Object doInBackground(Object... params) {
		      	registerRestService.UnRegister(registration);
				return null;
		     }
		   }.execute(null, null, null);
	}
		
	public class MyHandler extends NotificationsHandler {
		 @Override
		 public void onReceive(Context context, Bundle bundle){
			 NotificationStore.PushNotificationReceived.Trigger(bundle.getString("msg"));
		 }
	}
	
	private interface RegisterRestService {
		@POST("/api/push/register")
		void Register(@Body PushRegistration registration);
		
		@POST("/api/push/unregister")
		void UnRegister(@Body PushRegistration registration);
	}
}
