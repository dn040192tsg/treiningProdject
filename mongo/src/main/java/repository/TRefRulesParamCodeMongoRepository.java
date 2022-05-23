package repository;

import com.pb.consensus.no.sql.mongo.config.db.DirectoryConfig;
import com.pb.consensus.no.sql.mongo.directory.model.TRefRulesParamCodeModel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.mongodb.repository.MongoRepository;

@ConditionalOnBean(DirectoryConfig.class)
public interface TRefRulesParamCodeMongoRepository extends MongoRepository<TRefRulesParamCodeModel, String> {

}