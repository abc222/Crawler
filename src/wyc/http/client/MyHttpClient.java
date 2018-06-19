package wyc.http.client;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

public class MyHttpClient {
	/**
	 * 需求L使用HttpClient爬取传智播客官方网站数据
	 * @param args
	 * @throws IOException 
	 * @throws  
	 */
	
	public static void main(String[] args) throws Exception {
		
		//创建HttpClient对象
		HttpClient hClient = new DefaultHttpClient();
		
		
		//设置响应时间，设置传输源码时间，设置代理服务器
		hClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000)
		.setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000)
		.setParameter(ConnRouteParams.DEFAULT_PROXY, new HttpHost("119.41.236.180",8010));
		
		//爬虫URL大部分都是get请求，创建get请求对象
		HttpGet hGet = new HttpGet("http://www.itcast.cn/");	
		//向传智播客官方网站发送请求，获取网页源码
		HttpResponse response = hClient.execute(hGet);
		//EntityUtils工具类把网页实体转换成字符串
		String content = EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println(content);
	}

}
