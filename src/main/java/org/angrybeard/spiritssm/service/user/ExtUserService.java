package org.angrybeard.spiritssm.service.user;

import org.angrybeard.spiritssm.annotation.ExtService;
import org.angrybeard.spiritssm.bo.User;
import org.angrybeard.spiritssm.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by angry_beary on 2019/7/1.
 */
@Service
@ExtService
public class ExtUserService implements IUserService {

    public User queryUserInfo(String name) {
        throw new RuntimeException();
    }
}
