package config.db;
import config.MongoConfigHolder;

import java.util.ArrayList;

@Configuration
@ConditionalOnProperty(value = "mongo.db.holder.configs.CLIENT_CONSENT_SET.unable", havingValue = "true")
@EnableMongoRepositories(basePackages = "com.pb.consensus.no.sql.mongo.client", mongoTemplateRef = "clientConsentTemplate")
public class ClientConsentConfig {

    private final MongoConfigHolder configHolder;

    public ClientConsentConfig(MongoConfigHolder configHolder) {
        this.configHolder = configHolder;
    }

    @Bean
    public MongoTemplate clientConsentTemplate() {
        MappingMongoConverter converter = new MappingMongoConverter(
                new DefaultDbRefResolver(clientConsentFactory()),
                new MongoMappingContext()
        );

        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new TimestampToDateConverter());
        converters.add(new DateToTimestampConverter());
        MongoCustomConversions customConversions = new MongoCustomConversions(converters);

        converter.setCustomConversions(customConversions);
        converter.afterPropertiesSet();

        return new MongoTemplate(clientConsentFactory(), converter);
    }

    @Bean
    public MongoDatabaseFactory clientConsentFactory() {
        return new SimpleMongoClientDatabaseFactory(configHolder.getConfig(MongoBase.CLIENT_CONSENT_SET).getUri());
    }
}
