package consent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsentByGroupPersonalDataEntity {

    private String legalBasis;
    private Integer purpose;
    private String groupPersonalData;
    private String sysID;
    private String editorLogin;
    private String state;
    private String remark;

    private Timestamp dtm;
}
