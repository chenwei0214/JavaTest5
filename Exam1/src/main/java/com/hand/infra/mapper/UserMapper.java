package com.hand.infra.mapper;

import java.util.List;

import com.hand.infra.dataobject.UserDO;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<UserDO> {

    int insert(UserDO userDO);

    List<UserDO> selectAll();
}
