package model;

import com.pb.consensus.dto.directory.DirType;
import com.pb.consensus.dto.directory.TRefGroupPersonalDataDTO;
import com.pb.consensus.no.sql.mongo.directory.entity.TRefGroupPersonalDataEntity;

public class TRefGroupPersonalDataModel extends AbstractMongoModel<TRefGroupPersonalDataDTO, TRefGroupPersonalDataEntity> {

    @Override
    public String getKey() {
        return DirType.GROUP_PERSONAL_DATA.name();
    }

    @Override
    public TRefGroupPersonalDataDTO entityToDTO(TRefGroupPersonalDataEntity entity) {
        return TRefGroupPersonalDataDTO.builder()
                .groupPersonalData(entity.getGroupPersonalData())
                .shortName(entity.getShortName())
                .description(entity.getDescription())
                .editorLogin(entity.getEditorLogin())
                .state(entity.getState())
                .remark(entity.getRemark())
                .dtm(entity.getDtm())
                .build();
    }

    @Override
    public TRefGroupPersonalDataEntity dtoToEntity(TRefGroupPersonalDataDTO dto) {
        TRefGroupPersonalDataEntity entity = new TRefGroupPersonalDataEntity();

        entity.setGroupPersonalData(dto.getGroupPersonalData());
        entity.setShortName(dto.getShortName());
        entity.setDescription(dto.getDescription());
        entity.setEditorLogin(dto.getEditorLogin());
        entity.setState(dto.getState());
        entity.setRemark(dto.getRemark());

        entity.setDtm(dto.getDtm());

        return entity;
    }
}
