package com.st.trade.modules.sys.controller;

import com.st.trade.common.utils.R;
import com.st.trade.modules.sys.service.ShopService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class ShopController extends AbstractController {
    @Autowired
    private ShopService shopService;
    /**
     * 所有用户列表
     */
    @RequestMapping("/shoplist")
    @RequiresPermissions("sys:shop:list")
    public R shopList(){
        List<String> shopList= shopService.queryShopList();

        return R.ok().put("shopList", shopList);
    }

}
