package org.angrybeard.spiritssm.controller;

import org.angrybeard.spiritssm.annotation.AutoChecker;
import org.angrybeard.spiritssm.annotation.ExtService;
import org.angrybeard.spiritssm.annotation.GenericService;
import org.angrybeard.spiritssm.bo.BaseResponse;
import org.angrybeard.spiritssm.bo.User;
import org.angrybeard.spiritssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by angry_beary on 2019/6/30.
 */
@RestController
public class UserController {

    @Autowired
    @GenericService
    private IUserService userService;
    @Autowired
    @ExtService
    private IUserService extService;

    @AutoChecker
    @RequestMapping(value = "/queryuserinfo/{name}", method = RequestMethod.GET)
    public BaseResponse<User> queryUserInfo(@PathVariable(value = "name") String name) {
        try {
            return BaseResponse.success(userService.queryUserInfo(name));
        } catch (Exception e) {
            return BaseResponse.error();
        }
    }

    @RequestMapping(value = "/queryextuserinfo/{name}", method = RequestMethod.GET)
    public BaseResponse<User> queryExtUserInfo(@PathVariable(value = "name") String name) {
        try {
            return BaseResponse.success(extService.queryUserInfo(name));
        } catch (Exception e) {
            throw new RuntimeException("service error");
        }

    }
}
