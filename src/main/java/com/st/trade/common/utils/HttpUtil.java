package com.st.trade.common.utils;

import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author 马弦
 * @date 2017年10月23日 下午2:49
 * HttpClient工具类
 */
public class HttpUtil {



    /**
     * post请求(用于key-value格式的参数)
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, Map params){

        BufferedReader in = null;
        try {
            // 定义HttpClient
            HttpClient client = new DefaultHttpClient();
            // 实例化HTTP方法
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));

            //设置参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));

                //System.out.println(name +"-"+value);
            }
            request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));

            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if(code == 200){    //请求成功
                in = new BufferedReader(new InputStreamReader(response.getEntity()
                        .getContent(),"utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }

                in.close();

                return sb.toString();
            }
            else{   //
                System.out.println("状态码：" + code);
                return null;
            }
        }
        catch(Exception e){
            e.printStackTrace();

            return null;
        }
    }

    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, String params) throws Exception {

        CloseableHttpClient httpclient = null;
        HttpPost  httpPost=null;
        CookieStore cookieStore = new BasicCookieStore();
        httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
          httpPost = new HttpPost(url);// 创建httpPost
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Cookie", "JSESSIONID=" + "fe72dec7-6790-44dc-8f0f-3ad6271cf883");
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params, charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        //String JSESSIONID = null;
        try {


         //"JSESSIONID=F9C282A568AF66DC3CBC2D22A18100D7;"

            response = httpclient.execute(httpPost);

            StatusLine status = response.getStatusLine();
            // 获得登陆后的 Cookie

            int state = status.getStatusCode();
                System.out.println("state:"+state);

            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            }
            else{
                String  newuri="";//重定向的url
                 if(state==302){
                    System.out.println("请求返回:"+state+"("+url+")");
                     Header header = response.getFirstHeader("location"); // 跳转的目标地址是在 HTTP-HEAD 中的
                     newuri = header.getValue(); // 这就是跳转后的地址，再向这个地址发出新申请，以便得到跳转后的信息是啥。
                 }
                 System.out.println("重定向的url:"+newuri);
                 String[] urls = newuri.split(";");
                return   doPost("http://192.168.1.121:8080"+urls[0],params);


            }

        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //return null;
    }

    public static void main(String[] args) {
        String url="http://localhost:8080/renren-admin/sys/user/listUsers";//
        /*JSONObject pa = new  JSONObject();
        pa.put("shop_id","shop001");*/
        String params = "";

        try {
        String   data = doPost(url, params);
        System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}