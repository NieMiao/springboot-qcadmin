package qcadmin.auth.entity;

import lombok.Data;
import lombok.ToString;
import qcadmin.common.utils.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @program: springboot-qcadmin
 * @description: 用户角色关联表
 * @author: NieMiao
 * @create: 2019-03-28 16:54
 **/
@Data
@ToString
@Entity
@Table(name = "auth_user_role")
public class UseRole extends BaseEntity {

    @Column(name = "user_id")
    private String userId; //用户id

    @Column(name = "role_id")
    private String roleId; //角色id

    @Column(name = "description")
    private String description;//关联描述


}
