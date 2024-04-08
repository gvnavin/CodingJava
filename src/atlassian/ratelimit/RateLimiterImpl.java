package atlassian.ratelimit;

import atlassian.ratelimit.algo.AlgoFactory;
import atlassian.ratelimit.algo.RateLimitAlgo;
import atlassian.ratelimit.dao.ConfigDao;
import atlassian.ratelimit.dao.Dao;

public class RateLimiterImpl implements RateLimiter {

    private final Dao<Config> configDao;
    private final IdCreator idCreator;
    private final AlgoFactory algoFactory;

    public RateLimiterImpl() {
        //using DI
        configDao = new ConfigDao();
        idCreator = new IdCreator();
        algoFactory = AlgoFactory.getInstance();

    }

    @Override
    public ConfigRegistrationStatus register(Config config) {
        try {
            configDao.put(config);
            return ConfigRegistrationStatus.SUCCESS;
        } catch (Exception e) {
            return ConfigRegistrationStatus.ERROR;
        }

    }

    @Override
    public RequestStatus isRequestAllowed(Request req) {
        String id = idCreator.getId(req);
        Config config = configDao.get(id);
        RateLimitAlgo algo = algoFactory.getAlgo(config);
        return algo.isAllowed(id);
    }
}
