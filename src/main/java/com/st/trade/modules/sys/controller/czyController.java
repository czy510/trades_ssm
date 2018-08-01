package com.st.trade.modules.sys.controller;

import com.st.trade.common.utils.R;
import com.st.trade.modules.sys.entity.ParamData;
import com.st.trade.modules.sys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//允许跨域访问
@CrossOrigin(origins = "*", maxAge = 30000)
@RestController
@RequestMapping("/api")
@Api(tags="用户模块")
public class czyController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveC_user")
    @ApiOperation("用户添加")
    public R saveC_user(@RequestBody ParamData pd ){
        userService.saveC_user(pd);
        return R.ok().put("users", pd);
    }
}
