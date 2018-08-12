package com.hand.api.service;

import com.github.pagehelper.PageInfo;
import com.hand.infra.dataobject.UserDO;

public interface UserService {

    void createUser(UserDO userDO);

    PageInfo<UserDO> getAll();

    UserDO getById(Long id);
}
