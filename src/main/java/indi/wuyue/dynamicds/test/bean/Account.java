package indi.wuyue.dynamicds.test.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {

    private Long id;

    private String userName;

    private Integer type;

    private String loginName;

    private String password;

    private String address;

    private String telephone;

    private Long createTime;

    private Long updateTime;

    private Integer deleted;

}
