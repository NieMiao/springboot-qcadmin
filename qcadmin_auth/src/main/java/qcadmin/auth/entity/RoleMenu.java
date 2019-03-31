package qcadmin.auth.entity;

import lombok.Data;
import lombok.ToString;
import qcadmin.common.utils.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @program: springboot-qcadmin
 * @description: 角色菜单关联表
 * @author: NieMiao
 * @create: 2019-03-28 17:00
 **/
@Data
@ToString
@Entity
@Table(name = "auth_role_menu")
public class RoleMenu extends BaseEntity {

    @Column(name = "role_id")
    private String roleId; //角色id

    @Column(name = "menu_id")
    private String menuId; //用户id

    @Column(name = "description")
    private String description;//关联描述
}
