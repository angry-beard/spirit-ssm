package org.angrybeard.spiritssm.service.user;

import org.angrybeard.spiritssm.annotation.GenericService;
import org.angrybeard.spiritssm.bo.User;
import org.angrybeard.spiritssm.mapper.UserMapper;
import org.angrybeard.spiritssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by angry_beary on 2019/6/30.
 */
@Service
@GenericService
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserInfo(String name) {
        return userMapper.queryUserInfo(name);
    }
}