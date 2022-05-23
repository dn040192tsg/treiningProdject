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
public class DirectoryGetService {

    private final TRefLegalBasisMongoDAO legalBasisDAO;
    private final TRefPurposeMongoDAO purposeDAO;
    private final TRefPersonalDataParamsMongoDAO personalDataParamsDAO;
    private final TRefGroupPersonalDataMongoDAO groupPersonalDataDAO;
    private final TRefRulesGroupPersonalDataMongoDAO rulesGroupPersonalDataDAO;
    private final TRefRulesParamCodeMongoDAO rulesParamCodeDAO;

    public List<TRefLegalBasisDTO> getLegalBasis() {
        return legalBasisDAO.getDirectory();
    }

    public List<TRefPurposeDTO> getPurpose() {
        return purposeDAO.getDirectory();
    }

    public List<TRefPersonalDataParamsDTO> getPersonalDataParams() {
        return personalDataParamsDAO.getDirectory();
    }

    public List<TRefGroupPersonalDataDTO> getGroupPersonalData() {
        return groupPersonalDataDAO.getDirectory();
    }

    public List<TRefRulesGroupPersonalDataDTO> getRulesGroupPersonalData() {
        return rulesGroupPersonalDataDAO.getDirectory();
    }

    public List<TRefRulesParamCodeDTO> getRulesParamCode() {
        return rulesParamCodeDAO.getDirectory();
    }

    public Directories get(List<DirType> types) {
        Directories directories = new Directories();

        for (DirType type : types) {
            switch (type) {
                case LEGAL_BASIS:
                    directories.setLegalBasis(legalBasisDAO.getDirectory());
                    break;
                case PURPOSE:
                    directories.setPurpose(purposeDAO.getDirectory());
                    break;
                case GROUP_PERSONAL_DATA:
                    directories.setGroupPersonalData(groupPersonalDataDAO.getDirectory());
                    break;
                case PERSONAL_DATA_PARAMS:
                    directories.setPersonalDataParams(personalDataParamsDAO.getDirectory());
                    break;
                case RULES_GROUP_PERSONAL_DATA:
                    directories.setRulesGroupPersonalData(rulesGroupPersonalDataDAO.getDirectory());
                    break;
                case RULES_PARAM_CODE:
                    directories.setRulesParamCode(rulesParamCodeDAO.getDirectory());
                    break;
            }
        }

        return directories;
    }
}
