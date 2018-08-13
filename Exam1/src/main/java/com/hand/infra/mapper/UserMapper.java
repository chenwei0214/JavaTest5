package com.hand.infra.mapper;

import com.hand.infra.dataobject.UserDO;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<UserDO> {

    int customInsert(UserDO userDO);
}
