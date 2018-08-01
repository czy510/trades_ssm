package com.st.trade.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("c_user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    @TableId(value = "ids",type = IdType.INPUT)
    private String  ids;

    private  String name;



    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "ids='" + ids + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
