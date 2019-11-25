package cyx.redis1.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer uid;
    private String username;
    private Integer age;
    @JSONField(format = "yyyy-MM-dd")
    private Date date;
    private String address;
    private Integer salary;
}
