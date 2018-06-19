package wyc.http.client;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HttpClientVsJsoup {
	/**
	 * 需求：使用httpClient和jsoup共同实现爬虫程序
	 *     httpClient负责发送请求，获取网页源码
	 *     Jsoup负责解析网页
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	
	public static void main(String[] args) throws Exception {
		//创建HttpClient对象
		HttpClient hClient = new DefaultHttpClient();
		//爬虫URL大部分都是get请求，创建get请求对象
		HttpGet hGet = new HttpGet("http://www.itcast.cn/");	
		//向传智播客官方网站发送请求，获取网页源码
		HttpResponse response = hClient.execute(hGet);
		//EntityUtils工具类把网页实体转换成字符串
		String content = EntityUtils.toString(response.getEntity(),"utf-8");
		//使用Jsoup解析网页
		Document doc = Jsoup.parse(content);
		//使用元素选择器选择网页内容
		Elements elements = doc.select("li.lione a");
		System.out.println(elements.text());
	}
	
}
