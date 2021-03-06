package ssm.mybatis;

import lombok.Data;

/**
 * @ClassName MapperInfo
 * @Description
 * @Data 2018/12/8
 * @Author Yien
 */
@Data
public class MapperInfo {

    private String interfaceName;
    private String sqlContent;
    private String methodName;
    private String resultClassName;
}
