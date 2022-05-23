package model;

import com.pb.consensus.dto.directory.DirType;
import com.pb.consensus.dto.directory.TRefPersonalDataParamsDTO;
import com.pb.consensus.no.sql.mongo.directory.entity.TRefPersonalDataParamsEntity;


public class TRefPersonalDataParamsModel extends AbstractMongoModel<TRefPersonalDataParamsDTO, TRefPersonalDataParamsEntity> {

    @Override
    public String getKey() {
        return DirType.PERSONAL_DATA_PARAMS.name();
    }

    @Override
    public TRefPersonalDataParamsDTO entityToDTO(TRefPersonalDataParamsEntity entity) {
        return TRefPersonalDataParamsDTO.builder()
                .groupPersonalData(entity.getGroupPersonalData())
                .paramCode(entity.getParamCode())
                .description(entity.getDescription())
                .editorLogin(entity.getEditorLogin())
                .state(entity.getState())
                .remark(entity.getRemark())
                .dtm(entity.getDtm())
                .build();
    }

    @Override
    public TRefPersonalDataParamsEntity dtoToEntity(TRefPersonalDataParamsDTO dto) {
        TRefPersonalDataParamsEntity entity = new TRefPersonalDataParamsEntity();

        entity.setGroupPersonalData(dto.getGroupPersonalData());
        entity.setParamCode(dto.getParamCode());
        entity.setDescription(dto.getDescription());
        entity.setEditorLogin(dto.getEditorLogin());
        entity.setState(dto.getState());
        entity.setRemark(dto.getRemark());

        entity.setDtm(dto.getDtm());

        return entity;
    }
}


