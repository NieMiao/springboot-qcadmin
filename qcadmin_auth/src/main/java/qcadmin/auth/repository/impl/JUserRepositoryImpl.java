package qcadmin.auth.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import qcadmin.auth.entity.Menu;

import java.util.List;

/**
 * @program: qcadmin_server
 * @description: userJdbc查询
 * @author: NieMiao
 * @create: 2019-03-29 11:55
 **/
@Repository
public class JUserRepositoryImpl {

    @Autowired
    private NamedParameterJdbcTemplate template;

}
