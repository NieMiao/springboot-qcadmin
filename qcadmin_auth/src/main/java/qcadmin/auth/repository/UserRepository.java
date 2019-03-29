package qcadmin.auth.repository;

import qcadmin.auth.entity.User;

/**
 * @program: qcadmin_server
 * @description:
 * @author: NieMiao
 * @create: 2019-03-29 11:11
 **/
public interface UserRepository extends CommonRepository<User> {

    User findByUsername(String username);
}
