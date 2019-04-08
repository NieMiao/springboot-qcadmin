package qcadmin.auth.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import qcadmin.auth.entity.Menu;
import qcadmin.auth.repository.JUserRepository;

import java.util.List;
import java.util.Map;

/**
 * @program: qcadmin_server
 * @description: userJdbc查询
 * @author: NieMiao
 * @create: 2019-03-29 11:55
 **/
@Repository
public class JUserRepositoryImpl implements JUserRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Override
    public List<Menu> menuList(Map<String, String> map) {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from auth_menu where id in ");
        sb.append(" (select menu_id from auth_role_menu where role_id in ");
        sb.append(" (select id from auth_role where id in ");
        sb.append(" (select role_id from auth_user_role where user_id = ");
        sb.append(" (select id from auth_user  where username = '"+map.get("username")+"'))))");
        List<Menu> list = template.query(sb.toString(), new BeanPropertyRowMapper<>(Menu.class));
        return list;
    }
}
