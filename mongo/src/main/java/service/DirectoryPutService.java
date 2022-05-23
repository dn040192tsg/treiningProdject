package service;

import com.pb.consensus.dto.directory.*;
import com.pb.consensus.no.sql.mongo.config.db.DirectoryConfig;
import com.pb.consensus.no.sql.mongo.directory.dao.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@ConditionalOnBean(DirectoryConfig.class)
public class DirectoryPutService {

    private final TRefLegalBasisMongoDAO legalBasisDAO;
    private final TRefGroupPersonalDataMongoDAO groupPersonalDataDAO;
    private final TRefPersonalDataParamsMongoDAO personalDataParamsDAO;
    private final TRefPurposeMongoDAO purposeDAO;
    private final TRefRulesGroupPersonalDataMongoDAO rulesGroupPersonalDataDAO;
    private final TRefRulesParamCodeMongoDAO rulesParamCodeDAO;

    public void putLegalBasis(List<TRefLegalBasisDTO> directory) {
        legalBasisDAO.putDirectory(directory);
    }

    public void putPurpose(List<TRefPurposeDTO> directory) {
        purposeDAO.putDirectory(directory);
    }

    public void putGroupPersonalData(List<TRefGroupPersonalDataDTO> directory) {
        groupPersonalDataDAO.putDirectory(directory);
    }

    public void putPersonalDataParams(List<TRefPersonalDataParamsDTO> directory) {
        personalDataParamsDAO.putDirectory(directory);
    }

    public void putRulesGroupPersonalData(List<TRefRulesGroupPersonalDataDTO> directory) {
        rulesGroupPersonalDataDAO.putDirectory(directory);
    }

    public void putRulesParamCode(List<TRefRulesParamCodeDTO> directory) {
        rulesParamCodeDAO.putDirectory(directory);
    }
}
