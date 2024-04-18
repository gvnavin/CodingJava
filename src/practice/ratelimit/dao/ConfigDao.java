package practice.ratelimit.dao;


import practice.ratelimit.Config;

import java.util.HashMap;

public class ConfigDao implements Dao<Config> {

    HashMap<String, Config> inMemoryDb = new HashMap<>();

    @Override
    public Config get(String id) {
        if (inMemoryDb.containsKey(id)) {
            return inMemoryDb.get(id);

        }

        throw new IllegalArgumentException();
    }

    @Override
    public void put(Config config) {
        inMemoryDb.put(config.getId(), config);
    }
}

