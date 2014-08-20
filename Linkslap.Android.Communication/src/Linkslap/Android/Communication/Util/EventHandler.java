package Linkslap.Android.Communication.Util;

import java.util.ArrayList;

public class EventHandler <TType> {
	private ArrayList<EventListener<TType>> listeners = new ArrayList<EventListener<TType>>(); 
	
	public Boolean Add(EventListener<TType> listener) {
		return listeners.add(listener);
	}
	
	public Boolean Remove(EventListener<TType> listener) {
		return listeners.remove(listener);
	}
	
	public void Trigger(TType value) {
		for (EventListener<TType> listener : listeners) {
			listener.OnEventFired(value);
		}
	}
}
