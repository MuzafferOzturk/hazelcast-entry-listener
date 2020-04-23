package tr.example;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.concurrent.TimeUnit;

public class HazelcastAccessor {
    HazelcastInstance hazelcastInstance;
    public static HazelcastAccessor instance;
    private static final String CACHE_NAME = "DEFAULT";

    private HazelcastAccessor(){
        hazelcastInstance = Hazelcast.newHazelcastInstance();
        hazelcastInstance.getMap(CACHE_NAME).addEntryListener(new EntryListenerTest(), true);
    }

    public static HazelcastAccessor getInstance() {
        if(instance == null)
            instance = new HazelcastAccessor();
        return instance;
    }

    public void put(String key, String value){
        hazelcastInstance.getMap(CACHE_NAME).put(key, value);
    }

    public void put(String key, String value, int ttl){
        hazelcastInstance.getMap(CACHE_NAME).put(key, value, ttl, TimeUnit.SECONDS);
    }

    public IMap<String, String> getMap(){
        return hazelcastInstance.getMap(CACHE_NAME);
    }
}
