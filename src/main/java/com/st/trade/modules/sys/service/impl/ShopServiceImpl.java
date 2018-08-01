package com.st.trade.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.st.trade.datasources.annotation.DataSource;
import com.st.trade.modules.sys.dao.ShopDao;
import com.st.trade.modules.sys.entity.ShopEntity;
import com.st.trade.modules.sys.service.ShopService;

import java.util.List;

public class ShopServiceImpl extends ServiceImpl<ShopDao,ShopEntity> implements ShopService{

    @Override
    @DataSource(name ="second")
    public List<String> queryShopList() {
        return baseMapper.queryShopList();
    }
}
