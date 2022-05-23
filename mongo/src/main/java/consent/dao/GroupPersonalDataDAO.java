package consent.dao;


import consent.entity.GroupPersonalDataEntity;
import org.graalvm.compiler.lir.CompositeValue;

import java.util.ArrayList;
import java.util.List;

@CompositeValue.Component
public class GroupPersonalDataDAO extends AbstractConsentListDAO<GroupPersonalDataEntity, GroupPersonalDataDTO, Integer> {

    public GroupPersonalDataDAO(GroupPersonalDataRepository repository) {
        super(repository);
    }

    public GroupPersonalDataDTO get(Integer clientId) {
        return entityToDTO(repository.findById(clientId).orElse(null));
    }

    public void save(GroupPersonalDataDTO dto) {
        repository.save(dtoToEntity(dto));
    }

    public ConsentByGroupPersonalDataDTO consentByGroupPersonalDataListEntityToDto(ConsentByGroupPersonalDataEntity entity) {
        return ConsentByGroupPersonalDataDTO.builder()
                .legalBasis(entity.getLegalBasis())
                .purpose(entity.getPurpose())
                .groupPersonalData(entity.getGroupPersonalData())
                .dtm(entity.getDtm())
                .editorLogin(entity.getEditorLogin())
                .remark(entity.getRemark())
                .sysID(entity.getSysID())
                .build();
    }

    public ConsentByGroupPersonalDataEntity consentByGroupPersonalDataDtoToEntity(ConsentByGroupPersonalDataDTO dto) {
        ConsentByGroupPersonalDataEntity entity = new ConsentByGroupPersonalDataEntity();

        entity.setLegalBasis(dto.getLegalBasis());
        entity.setGroupPersonalData(entity.getGroupPersonalData());
        entity.setPurpose(dto.getPurpose());
        entity.setEditorLogin(dto.getEditorLogin());
        entity.setState(dto.getState());
        entity.setRemark(dto.getRemark());
        entity.setDtm(dto.getDtm());
        return entity;
    }

    @Override
    public GroupPersonalDataEntity dtoToEntity(GroupPersonalDataDTO dto) {
        GroupPersonalDataEntity groupPersonalDataEntity = new GroupPersonalDataEntity();
        groupPersonalDataEntity.setClientID(dto.getClientID());

        List<ConsentByGroupPersonalDataEntity> consentByGroupPersonalDataEntityList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(dto.getConsentByGroupPersonalDataDTOList())) {
            for (ConsentByGroupPersonalDataDTO row : dto.getConsentByGroupPersonalDataDTOList()) {
                consentByGroupPersonalDataEntityList.add(consentByGroupPersonalDataDtoToEntity(row));
            }
        }

        groupPersonalDataEntity.setConsentByGroupPersonalDataEntityList(consentByGroupPersonalDataEntityList);

        return groupPersonalDataEntity;
    }

    @Override
    public GroupPersonalDataDTO entityToDTO(GroupPersonalDataEntity groupPersonalDataEntity) {
        if (groupPersonalDataEntity == null) {
            return null;
        }
        List<ConsentByGroupPersonalDataEntity> consentByGroupPersonalDataEntityList = groupPersonalDataEntity.getConsentByGroupPersonalDataEntityList();
        List<ConsentByGroupPersonalDataDTO> groupPersonalDataDTOList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(consentByGroupPersonalDataEntityList)) {
            for (ConsentByGroupPersonalDataEntity entity : consentByGroupPersonalDataEntityList) {
                groupPersonalDataDTOList.add(consentByGroupPersonalDataListEntityToDto(entity));
            }
        }

        return GroupPersonalDataDTO.builder()
                .clientID(groupPersonalDataEntity.getClientID())
                .consentByGroupPersonalDataDTOList(groupPersonalDataDTOList)
                .build();
    }
}
