package qcadmin.auth.entity;

import lombok.Data;
import lombok.ToString;
import qcadmin.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @program: springboot-com.qcadmin
 * @description: 系统用户
 * @author: NieMiao
 * @create: 2019-03-21 10:58
 **/
@Data
@ToString
@Entity
@Table(name = "auth_user")
public class User extends BaseEntity {

    @Column(name = "user_name")
    private String userName;	//用户名

    @Column(name = "password")
    private String password; 	//密码

    @Column(name = "client_id")
    private String clientId;		//客户端id

    @Column(name = "last_login")
    private String lastLogin;	//最后登录时间

    @Column(name = "ip")
    private String ip;			//用户登录ip地址

    @Column(name = "status")
    private String status;		//状态
}
