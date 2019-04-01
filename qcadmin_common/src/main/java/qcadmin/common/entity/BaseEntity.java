package qcadmin.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @program: springboot-qcadmin
 * @description: 公共基础实体类
 * @author: NieMiao
 * @create: 2019-03-20 11:13
 **/
@Data
@MappedSuperclass //实体类通用字段，父类抽取
public class BaseEntity {

    @Id
    @Column(name = "ID",nullable = false)
    private String id;

    @Column(name = "DELETE_FLAG")
    private int deleteFlag;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "CREATOR_ID")
    private String createId;

    @Column(name = "CREATOR_NAME")
    private String createName;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "UPDATOR_ID")
    private String updatorId;

    @Column(name = "UPDATOR_NAME")
    private String updatorName;

}
