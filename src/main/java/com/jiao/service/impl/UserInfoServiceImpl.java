package com.jiao.service.impl;

import com.jiao.bean.UserInfo;
import com.jiao.bean.UserInfoExample;
import com.jiao.dao.UserInfoMapper;
import com.jiao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther coraljiao
 * @date 2018/12/21 22:39
 * @description
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    //    public UserInfo getInfo(String userName) {
//        return userInfoMapper.selectByPrimaryKey(userName);
//    }
    @Override
    public List<UserInfo> getInfoByModel(UserInfoExample userInfo) {
        return userInfoMapper.selectByExample(userInfo);
    }
}
