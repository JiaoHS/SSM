package com.jiao.service;

import com.jiao.bean.UserInfo;
import com.jiao.bean.UserInfoExample;

import java.util.List;

/**
 * @auther coraljiao
 * @date 2018/12/21 17:09
 * @description
 */

public interface UserInfoService {

    List<UserInfo> getInfoByModel(UserInfoExample user);


}
