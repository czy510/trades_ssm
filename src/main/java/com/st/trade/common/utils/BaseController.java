package com.st.trade.common.utils;


import com.st.trade.modules.sellingTea.entity.PageData;
import com.st.trade.modules.sys.entity.ParamData;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


public class BaseController {



    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        return request;
    }
    /**
     * 得到PageData
     */
    public PageData getPageData(){
        return new PageData(this.getRequest());
    }
    /**
     * 得到ParamData
     */
    public ParamData getParamData(){
        return new ParamData(this.getRequest());
    }
    /**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
}
