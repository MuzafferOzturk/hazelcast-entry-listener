package tr.example;

public class Main {

    public static void main(String[] args) {
        String key = "KEY1";
        String key_ttl = "KEY_TTL";
        String value = "value1";
        String ttl_value = "value_ttl";
        int ttl = 1;

        HazelcastAccessor.getInstance().put(key, value);
        HazelcastAccessor.getInstance().getMap().delete(key);
        HazelcastAccessor.getInstance().put(key, value);
        HazelcastAccessor.getInstance().put(key, "updated value");
        HazelcastAccessor.getInstance().getMap().evict(key);
        HazelcastAccessor.getInstance().getMap().clear();
        HazelcastAccessor.getInstance().put(key_ttl, ttl_value, ttl);
    }

}
