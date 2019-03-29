package qcadmin.auth.model;

import lombok.Data;
import lombok.ToString;
import qcadmin.auth.entity.Menu;
import qcadmin.auth.entity.User;

import java.util.List;

/**
 * @program: qcadmin_server
 * @description: 用户扩展信息
 * @author: NieMiao
 * @create: 2019-03-29 11:36
 **/
@Data
@ToString
public class UserExt extends User {

    //权限信息
    private List<Menu> permissions;

}
