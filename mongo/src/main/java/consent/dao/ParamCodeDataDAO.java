package consent.dao;

import com.pb.consensus.dto.client.consent.ConsentByParamCodeDTO;
import com.pb.consensus.dto.client.consent.ParamCodeDTO;
import com.pb.consensus.no.sql.mongo.client.consent.entity.ConsentByParamCodeEntity;
import com.pb.consensus.no.sql.mongo.client.consent.entity.ParamCodeDataEntity;
import com.pb.consensus.no.sql.mongo.client.consent.repository.ParamCodeDataRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParamCodeDataDAO extends AbstractConsentListDAO<ParamCodeDataEntity, ParamCodeDTO, Integer> {

    public ParamCodeDataDAO(ParamCodeDataRepository repository) {
        super(repository);
    }

    public ParamCodeDTO get(Integer clientId) {
        return entityToDTO(repository.findById(clientId).orElse(null));
    }

    public void save(ParamCodeDTO dto) {
        repository.save(dtoToEntity(dto));
    }

    public ConsentByParamCodeDTO consentByParamCodeListEntityToDto(ConsentByParamCodeEntity entity) {
        return ConsentByParamCodeDTO.builder()
                .paramCode(entity.getParamCode())
                .paramValue(entity.getParamValue())
                .legalBasis(entity.getLegalBasis())
                .purpose(entity.getPurpose())
                .dtm(entity.getDtm())
                .editorLogin(entity.getEditorLogin())
                .remark(entity.getRemark())
                .sysID(entity.getSysID())
                .build();
    }

    public ConsentByParamCodeEntity consentByParamCodeDtoToEntity(ConsentByParamCodeDTO dto) {
        ConsentByParamCodeEntity entity = new ConsentByParamCodeEntity();

        entity.setLegalBasis(dto.getLegalBasis());
        entity.setParamCode(dto.getParamCode());
        entity.setParamValue(dto.getParamValue());
        entity.setPurpose(dto.getPurpose());
        entity.setEditorLogin(dto.getEditorLogin());
        entity.setState(dto.getState());
        entity.setRemark(dto.getRemark());
        entity.setDtm(dto.getDtm());
        return entity;
    }

    @Override
    public ParamCodeDataEntity dtoToEntity(ParamCodeDTO dto) {
        ParamCodeDataEntity paramCodeEntity = new ParamCodeDataEntity();
        paramCodeEntity.setClientID(dto.getClientID());

        List<ConsentByParamCodeEntity> consentByParamCodeEntityList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(dto.getConsentByParamCodeDTOList())) {
            for (ConsentByParamCodeDTO row : dto.getConsentByParamCodeDTOList()) {
                consentByParamCodeEntityList.add(consentByParamCodeDtoToEntity(row));
            }
        }

        paramCodeEntity.setConsentByParamCodeEntityList(consentByParamCodeEntityList);

        return paramCodeEntity;
    }

    @Override
    public ParamCodeDTO entityToDTO(ParamCodeDataEntity paramCodeEntity) {
        if (paramCodeEntity == null) {
            return null;
        }
        List<ConsentByParamCodeEntity> consentByParamCodeEntityList = paramCodeEntity.getConsentByParamCodeEntityList();
        List<ConsentByParamCodeDTO> consentByParamCodeDTOList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(consentByParamCodeEntityList)) {
            for (ConsentByParamCodeEntity entity : consentByParamCodeEntityList) {
                consentByParamCodeDTOList.add(consentByParamCodeListEntityToDto(entity));
            }
        }

        return ParamCodeDTO.builder()
                .clientID(paramCodeEntity.getClientID())
                .consentByParamCodeDTOList(consentByParamCodeDTOList)
                .build();
    }
}
