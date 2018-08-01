package com.st.trade.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("e_shop")
public class ShopEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private String shop_id;

    private String shop_name;

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }


    @Override
    public String toString() {
        return "ShopEntity{" +
                "shop_id='" + shop_id + '\'' +
                ", shop_name='" + shop_name + '\'' +
                '}';
    }
}
