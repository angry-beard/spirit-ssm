package org.angrybeard.spiritssm.mapper;

import org.angrybeard.spiritssm.bo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by angry_beary on 2019/6/30.
 */
public interface UserMapper {

    User queryUserInfo(@Param(value = "name") String name);
}
