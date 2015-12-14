package httpTest;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by pie on 2015-12-13.
 */
public class GetImg {
    public static String sendGet(DefaultHttpClient httpclient) throws Exception {
        int max = 1111;
        int min = 9999;
        Random random = new Random();
        int rand = random.nextInt(max) % (max - min + 1) + min;
        String imgUrl = "http://210.42.121.241/servlet/GenImg?r=0." + rand;
        HttpGet httpget = new HttpGet(imgUrl);
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        BASE64Encoder encoder = new BASE64Encoder();
        String imgStr = encoder.encode( EntityUtils.toByteArray(entity));
        return imgStr;
    }
    public static String sendPost(DefaultHttpClient httpclient,String url, String id, String pwd,String imgStr) {
        // 根据url获得HttpPost对象
        HttpPost httpRequest = new HttpPost(url);
        // 取得默认的HttpClient
        String ref = "http://210.42.121.241/stu/stu_index.jsp";
        String strResult = null;

        // NameValuePair实现请求参数的封装
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("id", id));
        params.add(new BasicNameValuePair("pwd", pwd));
        params.add(new BasicNameValuePair("xdvfb", imgStr));

        httpRequest.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");
        httpRequest.addHeader("Host", "210.42.121.241");
        httpRequest.addHeader("Referer", ref);
        httpRequest.addHeader("Connection","keep-alive");
        httpRequest.addHeader("X-Requested-With", "XMLHttpRequest");
        httpRequest.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1736.2 Safari/537.36");

        try {
            // 添加请求参数到请求对象
            httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            // 获得响应对象
            HttpResponse httpResponse = httpclient.execute(httpRequest);
            // 判断是否请求成功
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                // 获得响应返回Json格式数据
                strResult = EntityUtils.toString(httpResponse.getEntity());
                return strResult;
            } else {
                strResult = "错误响应:" + httpResponse.getStatusLine().toString();
            }
        } catch (ClientProtocolException e) {
            strResult = "错误响应:" + e.getMessage().toString();
            e.printStackTrace();
            return strResult;
        } catch (IOException e) {
            strResult = "错误响应:" + e.getMessage().toString();
            e.printStackTrace();
            return strResult;
        } catch (Exception e) {
            strResult = "错误响应:" + e.getMessage().toString();
            e.printStackTrace();
            return strResult;
        }
        return strResult;
    }
    public static void WriteStringToFile(String filePath,String fileContent) {
        try {
            File file = new File(filePath);
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println(fileContent);// 往文件里写入字符串
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String args[]) throws Exception {
        DefaultHttpClient httpclient = new DefaultHttpClient();
       String imgStr = sendGet(httpclient);
        WriteStringToFile("pie.txt","data:image/gif;base64,"+imgStr);

        String url = "http://210.42.121.241/servlet/Login";
        Scanner scan = new Scanner(System.in);
        System.out.println("please input student number");
        String id = scan.next();
        System.out.println("please input student pwd");
        String pwd = scan.next();
        System.out.println("please input img code");
        String imgCode = scan.next();
        String res = sendPost(httpclient,url,id,pwd,imgCode);
        WriteStringToFile("res.txt",res);
    }
}
