import rx.Observable;
import Linkslap.Android.Communication.Interfaces.ISubscriptionStore;
import Linkslap.Android.Communication.Models.Subscription;


public class SubscriptionStore implements ISubscriptionStore {

	@Override
	public Observable<Subscription> GetSubscriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subscription Add(String streamKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(String streamKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Subscription GetSubscription(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subscription GetSubscription(String streamKey) {
		// TODO Auto-generated method stub
		return null;
	}

}
