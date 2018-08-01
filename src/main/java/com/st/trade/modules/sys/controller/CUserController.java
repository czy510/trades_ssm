package com.st.trade.modules.sys.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.st.trade.common.utils.BaseController;
import com.st.trade.common.utils.PageUtils;
import com.st.trade.common.utils.R;
import com.st.trade.common.validator.ValidatorUtils;
import com.st.trade.modules.sys.entity.CUserEntity;
import com.st.trade.modules.sys.entity.ParamData;
import com.st.trade.modules.sys.service.CUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-27 10:33:23
 */
@RestController
@RequestMapping("sys/cuser")
public class CUserController extends BaseController {
    @Autowired
    private CUserService cUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:cuser:list")
    public R list(@RequestParam Map<String, Object> params){
        ParamData pd = this.getParamData();
        System.out.println(params+"========"+pd);

        Page page= new Page(pd.getInt("page"),pd.getInt("limit"));
        PageUtils page1 = cUserService.listPageCuser(page,pd);
        //.queryPage(params);
         System.out.println("page1:"+page1);
        //.queryPage(params);
        return R.ok().put("page", page1);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{ids}")
    @RequiresPermissions("sys:cuser:info")
    public R info(@PathVariable("ids") String ids){
        CUserEntity cUser = cUserService.selectById(ids);

        return R.ok().put("cUser", cUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:cuser:save")
    public R save(@RequestBody CUserEntity cUser){
        cUserService.insert(cUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:cuser:update")
    public R update(@RequestBody CUserEntity cUser){
        ValidatorUtils.validateEntity(cUser);
        cUserService.updateAllColumnById(cUser);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:cuser:delete")
    public R delete(@RequestBody String[] ids){
        cUserService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
