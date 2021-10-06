package VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {


    @Id
    private String departmentId;

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
