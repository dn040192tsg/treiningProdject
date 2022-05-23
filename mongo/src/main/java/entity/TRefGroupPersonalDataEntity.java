package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TRefGroupPersonalDataEntity {

    private String groupPersonalData;
    private String shortName;
    private String description;
    private String editorLogin;
    private String state;
    private String remark;

    private Timestamp dtm;
}
