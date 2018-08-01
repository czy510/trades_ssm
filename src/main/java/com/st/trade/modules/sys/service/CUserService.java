package com.st.trade.modules.sys.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.st.trade.common.utils.PageUtils;
import com.st.trade.modules.sys.entity.CUserEntity;
import com.st.trade.modules.sys.entity.ParamData;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-27 10:33:23
 */
public interface CUserService extends IService<CUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils listPageCuser(Page<ParamData> page, ParamData paramData);
}

