package qcadmin.auth.repository;

import qcadmin.auth.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * @program: qcadmin_server
 * @description:
 * @author: NieMiao
 * @create: 2019-03-29 11:54
 **/
public interface JUserRepository {

    List<Menu> menuList(Map<String,String> map);

}
