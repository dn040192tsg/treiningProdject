package consent.service;

import com.pb.consensus.dto.client.consent.GroupPersonalDataDTO;
import com.pb.consensus.no.sql.mongo.client.consent.dao.GroupPersonalDataDAO;
import com.pb.consensus.no.sql.mongo.config.db.ClientConsentConfig;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ConditionalOnBean(ClientConsentConfig.class)
public class GroupPersonalDataService {

    private final GroupPersonalDataDAO groupPersonalDataDAO;

    public GroupPersonalDataDTO getGroupPersonalDataByClientID(Integer clientID) {
        return groupPersonalDataDAO.get(clientID);
    }

    public void saveGroupPersonalDataClientConsentList(GroupPersonalDataDTO dto) {
        groupPersonalDataDAO.save(dto);
    }
}
