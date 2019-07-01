package org.angrybeard.spiritssm.service.user;

import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritssm.annotation.ExtService;
import org.angrybeard.spiritssm.bo.User;
import org.angrybeard.spiritssm.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by angry_beary on 2019/7/1.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    @ExtService
    private IUserService service;

    @Test
    public void queryUserInfo() throws Exception {
        User user = service.queryUserInfo("tom");
        log.info("查询到的用户信息为：user={}", user);
    }

}