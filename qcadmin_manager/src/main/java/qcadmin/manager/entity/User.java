package qcadmin.manager.entity;

import lombok.Data;
import qcadmin.common.entity.BaseEntity;

/**
 * @program: springboot-qcadmin
 * @description: 系统用户
 * @author: NieMiao
 * @create: 2019-03-21 10:58
 **/
@Data
public class User extends BaseEntity {
    private String USERNAME;	//用户名
    private String PASSWORD; 	//密码
    private String NAME;		//姓名
    private String RIGHTS;		//权限
    private String ROLE_ID;		//角色id
    private String ROLE_IDS;	//副职角色id
    private String LAST_LOGIN;	//最后登录时间
    private String IP;			//用户登录ip地址
    private String STATUS;		//状态
    private String SKIN;		//皮肤
}
