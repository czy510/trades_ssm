package com.st.trade.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.st.trade.modules.sys.entity.CUserEntity;
import com.st.trade.modules.sys.entity.ParamData;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-27 10:33:23
 */
public interface CUserDao extends BaseMapper<CUserEntity> {

    List<ParamData> listPageCuser(Pagination page, ParamData paramData);
}
