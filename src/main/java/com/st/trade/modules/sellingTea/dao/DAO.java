package com.st.trade.modules.sellingTea.dao;

public interface DAO {
	
	
	/**
	 * 
	 * @param str
	 * @param str1
	 * @return
	 */
	public Integer findForInteger(String str, Object obj);
	/**
	 * 保存对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	/**
	 * 保存对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int findForInt(String str, Object obj)throws Exception;
	
	/**
	 * 保存对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object save(String str, Object obj) throws Exception;
	
	/**
	 * 修改对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object update(String str, Object obj) throws Exception;
	
	/**
	 * 删除对象 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object delete(String str, Object obj) throws Exception;

	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForObject(String str, Object obj) throws Exception;

	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForList(String str, Object obj) throws Exception;
	
	/**
	 * 查找对象封装成Map
	 * @param s
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForMap(String sql, Object obj, String key, String value) throws Exception;
	
}
