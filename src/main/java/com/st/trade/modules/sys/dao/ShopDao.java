package com.st.trade.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.st.trade.modules.sys.entity.ShopEntity;

import java.util.List;

public interface ShopDao extends BaseMapper<ShopEntity> {
    List<String> queryShopList();
}
