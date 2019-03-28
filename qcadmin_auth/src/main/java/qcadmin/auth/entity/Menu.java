package qcadmin.auth.entity;

import qcadmin.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @program: springboot-qcadmin
 * @description: 菜单
 * @author: NieMiao
 * @create: 2019-03-28 16:04
 **/
@Data
@Entity
@ToString
@Table(name = "auth_menu")
public class Menu extends BaseEntity {

    @Column(name = "code")
    private String code;//菜单编码

    @Column(name="p_code")
    private String pCode;//父菜单编码

    @Column(name="p_id")
    private String pId;//父菜单主键id

    @Column(name="menu_name")
    private String menuName;//菜单名称

    @Column(name="url")
    private String url;//菜单url

    @Column(name="level")
    private Integer level;//菜单等级

    @Column(name="sort")
    private Integer sort;//菜单排序

    @Column(name="status")
    private String status;//菜单状态（可用，不可用）

    @Column(name="icon")
    private String icon;//菜单按钮图标
}
