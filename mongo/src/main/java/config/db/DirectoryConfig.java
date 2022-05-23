package config.db;

import com.pb.consensus.no.sql.mongo.config.MongoBase;
import com.pb.consensus.no.sql.mongo.config.MongoConfigHolder;
import com.pb.consensus.no.sql.mongo.config.converter.DateToTimestampConverter;
import com.pb.consensus.no.sql.mongo.config.converter.TimestampToDateConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConditionalOnProperty(value = "mongo.db.holder.configs.DIRECTORY.unable", havingValue = "true")
@EnableMongoRepositories(basePackages = "com.pb.consensus.no.sql.mongo.directory", mongoTemplateRef = "directoriesTemplate")
public class DirectoryConfig {

    private final MongoConfigHolder configHolder;

    public DirectoryConfig(MongoConfigHolder configHolder) {
        this.configHolder = configHolder;
    }

    @Primary
    @Bean
    public MongoTemplate directoriesTemplate() {
        MappingMongoConverter converter = new MappingMongoConverter(
                new DefaultDbRefResolver(directoriesFactory()),
                new MongoMappingContext()
        );

        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new TimestampToDateConverter());
        converters.add(new DateToTimestampConverter());
        MongoCustomConversions customConversions = new MongoCustomConversions(converters);

        converter.setCustomConversions(customConversions);
        converter.afterPropertiesSet();

        return new MongoTemplate(directoriesFactory(), converter);
    }

    @Primary
    @Bean
    public MongoDatabaseFactory directoriesFactory() {
        return new SimpleMongoClientDatabaseFactory(configHolder.getConfig(MongoBase.DIRECTORY).getUri());
    }
}
