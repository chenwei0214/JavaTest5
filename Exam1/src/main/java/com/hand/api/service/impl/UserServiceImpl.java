package com.hand.api.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.api.service.UserService;
import com.hand.infra.dataobject.UserDO;
import com.hand.infra.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

//    @Transactional(readOnly = true)
    @Override
    public void createUser(UserDO userDO) {
        this.userMapper.insert(userDO);
    }

    @Override
    public PageInfo<UserDO> getAll() {
        PageHelper.startPage(0, 10);
        List<UserDO> userDOS = userMapper.selectAll();
        PageInfo<UserDO> pageInfo = new PageInfo<>(userDOS);
        return pageInfo;
    }

    @Override
    public UserDO getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }


}
