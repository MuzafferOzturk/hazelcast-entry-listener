package tr.example;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import com.hazelcast.map.MapEvent;

public class EntryListenerTest implements EntryListener<String, String> {
    @Override
    public void entryAdded(EntryEvent<String, String> entryEvent) {
        System.out.println("Added " + entryEvent.getValue());
    }

    @Override
    public void entryEvicted(EntryEvent<String, String> entryEvent) {
        System.out.println("Evicted " + entryEvent.getOldValue());
    }

    @Override
    public void entryExpired(EntryEvent<String, String> entryEvent) {
        System.out.println("Expired " + entryEvent.getOldValue());
    }

    @Override
    public void entryRemoved(EntryEvent<String, String> entryEvent) {
        System.out.println("Removed " + entryEvent.getOldValue());
    }

    @Override
    public void entryUpdated(EntryEvent<String, String> entryEvent) {
        System.out.println("Updated " + entryEvent.getValue());
    }

    @Override
    public void mapCleared(MapEvent mapEvent) {
        System.out.println("Map Cleared " + mapEvent.getName());
    }

    @Override
    public void mapEvicted(MapEvent mapEvent) {
        System.out.println("Map Evicted " + mapEvent.getName());
    }
}
