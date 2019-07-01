package org.angrybeard.spiritssm.service;

import org.angrybeard.spiritssm.bo.User;

/**
 * Created by angry_beary on 2019/6/30.
 */
public interface IUserService {

    User queryUserInfo(String name);
}
