package com.st.trade.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.st.trade.modules.sys.entity.ParamData;
import com.st.trade.modules.sys.entity.UserEntity;

import java.util.List;

public interface UserService extends IService<UserEntity> {


      public List<ParamData> listUser();

     public void saveC_user(ParamData pd);

}
