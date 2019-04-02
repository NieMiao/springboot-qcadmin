package qcadmin.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcadmin.auth.entity.Menu;
import qcadmin.auth.entity.User;
import qcadmin.auth.repository.JUserRepository;
import qcadmin.auth.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private JUserRepository jUserRepository;

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<Menu> findMenuByUsername(String username){
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        return jUserRepository.menuList(map);

    }

}
