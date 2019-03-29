package qcadmin.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcadmin.auth.entity.User;
import qcadmin.auth.model.UserExt;
import qcadmin.auth.repository.UserRepository;

/**
 * @program: qcadmin_server
 * @description: 用户信息查询
 * @author: NieMiao
 * @create: 2019-03-29 11:10
 **/
@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username){

        return userRepository.findByUsername(username);
    }

}
