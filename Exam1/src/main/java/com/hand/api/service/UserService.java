package com.hand.api.service;

import com.github.pagehelper.PageInfo;
import com.hand.infra.dataobject.UserDO;

public interface UserService {

    long create(UserDO userDO);

    UserDO update(UserDO userDO);

    void delete(Long id);

    UserDO getById(Long id);
}
