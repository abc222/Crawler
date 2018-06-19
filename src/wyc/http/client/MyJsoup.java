package wyc.http.client;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyJsoup {
	/**
	 * 需求：使用Jsoup解析网页源码
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//使用jsoup向服务器发送请求
		Document doc = Jsoup.connect("http://www.itcast.cn").get();
		//Jsoup使用类似css，Jquery选择器方式获取元素节点
		//Elements elements = doc.getElementsByTag("a");
		//System.out.println(elements.text());
		Elements elements = doc.select("li.w127 a");
		//循环元素
		for (Element element : elements) {
			System.out.println(element.text()+"  :"+element.attr("href"));
		}
	}

}
