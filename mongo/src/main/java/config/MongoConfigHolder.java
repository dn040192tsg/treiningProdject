package config;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties("mongo.db.holder")
public class MongoConfigHolder {

    private Map<String, MongoConfig> configs = new HashMap<>();

    public MongoProperties getConfig(MongoBase base) {
        return configs.get(base.name()).getMongoProperties();
    }
}
