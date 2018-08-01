package com.st.trade.modules.sellingTea.service;

import com.st.trade.common.utils.Const;
import com.st.trade.datasources.DataSourceNames;
import com.st.trade.datasources.annotation.DataSource;
import com.st.trade.modules.sellingTea.dao.DaoSupport;
import com.st.trade.modules.sellingTea.entity.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("addressService")
public class AddressService {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**
	 * 
	 * @param ip 客户端IP
	 * @return 省，市,市编码（ProvinceName，CityName,CityCode）
	 * @throws Exception
	 */
	@DataSource(name = DataSourceNames.SECOND)
	public PageData findByIpProvinceAndCity(String ip) throws Exception{
		
		return (PageData) dao.findForObject(Const.ADDRESSMAPPER+".findByIpProvinceAndCity", ip);
	}
	
	/**
	 * 
	 * @return 省 ，省编码（NAME,CODE）
	 * @throws Exception
	 */
	@DataSource(name = DataSourceNames.SECOND)
	public List<PageData> listProvince() throws Exception{
		return (List<PageData>) dao.findForList(Const.ADDRESSMAPPER+".listProvince", null);
	}
	
	/**
	 * 
	 * @param provinceCode 省编码
	 * @return 市 ，市编码（NAME,CODE）
	 * @throws Exception
	 */
	@DataSource(name = DataSourceNames.SECOND)
	public List<PageData> listCityByProvinceCode(String provinceCode) throws Exception{
		
		return (List<PageData>) dao.findForList(Const.ADDRESSMAPPER+".listCityByProvinceCode", provinceCode);
	}
	/**
	  * 
	  * @return 省份
	  * @throws Exception
	  */
	@DataSource(name = DataSourceNames.SECOND)
	public List<PageData> listD_Province() throws Exception{
		
		return (List<PageData>) dao.findForList(Const.ADDRESSMAPPER+".listD_Province",null);
	}
	
	/**
	 * 
	 * @param provinceCode
	 * @return 城市
	 * @throws Exception
	 */
	@DataSource(name = DataSourceNames.SECOND)
	public List<PageData> listD_CITYByPROVINCECODE(String  provinceCode) throws Exception{
		
		return (List<PageData>) dao.findForList(Const.ADDRESSMAPPER+".listD_CITYByPROVINCECODE", provinceCode);
	}
	
	/**
	 * 
	 * @param cityCode
	 * @return 区
	 * @throws Exception
	 */
	@DataSource(name = DataSourceNames.SECOND)
	public List<PageData> listD_AREAByCITYCODE(String cityCode) throws Exception{
		
       return (List<PageData>) dao.findForList(Const.ADDRESSMAPPER+".listD_AREAByCITYCODE", cityCode);
	}
	
	/**
	 * 
	 * @param cityCode
	 * @return 根据市编码获取 省，市
	 * @throws Exception
	 */
	@DataSource(name = DataSourceNames.SECOND)
	public PageData findPCByCityCode(String cityCode) throws Exception{
		
		 return (PageData) dao.findForObject(Const.ADDRESSMAPPER+".findPCByCityCode", cityCode);
	}
	
}
