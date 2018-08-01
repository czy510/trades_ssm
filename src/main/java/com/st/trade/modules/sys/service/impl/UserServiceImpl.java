package com.st.trade.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.st.trade.datasources.DataSourceNames;
import com.st.trade.datasources.annotation.DataSource;
import com.st.trade.modules.sys.dao.UserDao;
import com.st.trade.modules.sys.entity.ParamData;
import com.st.trade.modules.sys.entity.UserEntity;
import com.st.trade.modules.sys.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {


   @DataSource(name = DataSourceNames.SECOND)
   public List<ParamData> listUser() {
        return baseMapper.listUsers();
    }



    public void saveC_user(ParamData pd){
        baseMapper.saveC_user(pd);
    }
}