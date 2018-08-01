package com.st.trade.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.st.trade.modules.sys.entity.ShopEntity;

import java.util.List;

public interface ShopService extends IService<ShopEntity> {
    List<String> queryShopList();
}
