package com.st.trade.modules.sys.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.st.trade.modules.sys.entity.ParamData;
import com.st.trade.modules.sys.entity.UserEntity;

import java.util.List;

public interface UserDao extends BaseMapper<UserEntity> {
     List<ParamData> listUsers();

     public void saveC_user(ParamData pd);
}
