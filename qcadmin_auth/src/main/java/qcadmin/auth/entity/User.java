package qcadmin.auth.entity;

import lombok.Data;
import lombok.ToString;
import qcadmin.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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

    @Column(name = "username")
    private String username;	//用户名

    @Column(name = "password")
    private String password; 	//密码

    @Column(name = "last_login")
    private Date lastLogin;	//最后登录时间

    @Column(name = "ip")
    private String ip;			//用户登录ip地址

    @Column(name = "status")
    private int status;		//状态
}
