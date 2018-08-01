package com.st.trade.modules.sellingTea.controller;

import com.st.trade.common.utils.BaseController;
import com.st.trade.modules.sellingTea.entity.PageData;
import com.st.trade.modules.sellingTea.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;


/**
 * 
 * @author czy
 *
 */
@Controller
public class AddressController extends BaseController {

	Logger logger = Logger.getLogger(AddressController.class.getName());
	
	@Resource(name = "addressService")
	private AddressService addressService;


	
	@RequestMapping(value="listP")
	public @ResponseBody
	PageData listProvince() throws Exception{
		logger.info("获取省份");
		PageData  pd = this.getPageData();
		pd.put("listProvince", addressService.listProvince());
		return pd;
	
	}
	
	@RequestMapping(value="listC")
	public @ResponseBody
    PageData listCity() throws Exception{
		logger.info("获取市份");
		PageData  pd = this.getPageData();
		pd.put("listCity", addressService.listCityByProvinceCode(pd.getString("provinceCode")));
		return pd;
	
	}
	
	/*===========================================================*/
	@RequestMapping(value="/addressProvince")
	public @ResponseBody
    List<PageData> addressProvince() throws Exception{
		   logger.info( "省份");
		List<PageData> provinces = addressService.listD_Province();
		System.out.println("provinces:"+provinces);
		return provinces;
	}
	
	@RequestMapping(value="/addressCity")
	public @ResponseBody
    List<PageData> addressCity() throws Exception{
		 logger.info("城市");
		PageData pd = this.getPageData();
		List<PageData> citys = addressService.listD_CITYByPROVINCECODE(pd.getString("provinceCode"));
		System.out.println("citys:"+citys);
		return citys;
	}
	
	@RequestMapping(value="/addressArea")
	public @ResponseBody
    List<PageData> addressArea() throws Exception{
	           logger.info("区");
		PageData pd = this.getPageData();
		List<PageData> areas = addressService.listD_AREAByCITYCODE(pd.getString("cityCode"));
		System.out.println("areas:"+areas);
		return areas;
	}
	
	@RequestMapping(value="/carDefaultAddress")
	public @ResponseBody
    PageData carDefaultAddress() throws Exception{
	           logger.info("区");
		PageData pd = this.getPageData();
		PageData carDefaultAddress = addressService.findPCByCityCode(pd.getString("cityCode"));
		pd.put("carDefaultAddress", carDefaultAddress);
		return pd;
	}
	
	@RequestMapping(value="/PCAddress")
	public @ResponseBody
    PageData ProvinceAndCity() throws Exception{
	           logger.info("搜索页面地区");
		PageData pd = this.getPageData();
		List<PageData> provinces = addressService.listD_Province();
		PageData pc = new PageData();
		for (int i = 0; i < provinces.size(); i++) {
		        pc = provinces.get(i);
		        
		        List<PageData> citys = addressService.listD_CITYByPROVINCECODE(pc.getString("CODE"));
		        PageData c = new PageData();
		        for (int j = 0; j < citys.size(); j++) {
		        	c = citys.get(j);
		        	 
		        	c.put("id", c.getString("CODE"));
				         c.put("name", c.getString("NAME"));
				         c.remove("CODE");
				         c.remove("NAME");
				         c.remove("ID");
				         c.remove("PROVINCECODE");
		        }
		        pc.put("id", pc.getString("CODE"));
		       pc.put("name", pc.getString("NAME"));
		      
		         pc.remove("CODE");
		         pc.remove("NAME");
		         pc.remove("ID");
		        pc.put("city", citys);
		}
		pd.put("provinces", provinces);
		return pd;
	}

}
