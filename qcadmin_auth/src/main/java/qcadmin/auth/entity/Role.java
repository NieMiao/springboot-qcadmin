package qcadmin.auth.entity;

import lombok.Data;
import lombok.ToString;
import qcadmin.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @program: springboot-qcadmin
 * @description: 角色
 * @author: NieMiao
 * @create: 2019-03-28 15:55
 **/
@Data
@Entity
@ToString
@Table(name = "auth_role")
public class Role extends BaseEntity {

    @Column(name="role_name")
    private String roleName;//角色名称

    @Column(name="role_code")
    private String roleCode;//角色编码

    @Column(name="description")
    private String description;//描述

    @Column(name="status")
    private String status;//角色状态（可用，不可用）

}
