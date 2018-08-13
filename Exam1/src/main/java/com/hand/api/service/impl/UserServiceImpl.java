package com.hand.api.service.impl;

import javax.annotation.Resource;

import com.hand.api.service.UserService;
import com.hand.infra.dataobject.UserDO;
import com.hand.infra.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public long create(UserDO userDO) {
        userMapper.customInsert(userDO);
        return userDO.getId();
    }

    @Override
    public UserDO update(UserDO userDO) {
        userMapper.updateByPrimaryKeySelective(userDO);
        return userMapper.selectByPrimaryKey(userDO.getId());
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteByExample(id);
    }

    @Override
    public UserDO getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
