package consent.service;

import com.pb.consensus.dto.client.consent.ParamCodeDTO;
import com.pb.consensus.no.sql.mongo.client.consent.dao.ParamCodeDataDAO;
import com.pb.consensus.no.sql.mongo.config.db.ClientConsentConfig;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ConditionalOnBean(ClientConsentConfig.class)
public class ParamCodeDataService {

    private final ParamCodeDataDAO paramCodeDAO;

    public ParamCodeDTO getParamCodeByClientID(Integer clientID) {
        return paramCodeDAO.get(clientID);
    }

    public void saveParamCodeClientConsentList(ParamCodeDTO dto) {
        paramCodeDAO.save(dto);
    }
}