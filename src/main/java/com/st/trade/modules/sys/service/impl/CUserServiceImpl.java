package com.st.trade.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.st.trade.common.annotation.DataFilter;
import com.st.trade.common.utils.PageUtils;
import com.st.trade.common.utils.Query;
import com.st.trade.modules.sys.dao.CUserDao;
import com.st.trade.modules.sys.entity.CUserEntity;
import com.st.trade.modules.sys.entity.ParamData;
import com.st.trade.modules.sys.service.CUserService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("cUserService")
public class CUserServiceImpl extends ServiceImpl<CUserDao, CUserEntity> implements CUserService {

   @Override
    public PageUtils queryPage(Map<String, Object> params) {

       Page<CUserEntity> page = this.selectPage(new Query<CUserEntity>(params).getPage(),new EntityWrapper<CUserEntity>());
        return new PageUtils(page);
    }

    public PageUtils listPageCuser(Page<ParamData> page, ParamData paramData) {

         page.setRecords(baseMapper.listPageCuser(page,paramData));
        return new PageUtils(page);
    }
}
