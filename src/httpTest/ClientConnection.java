package httpTest;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by think on 2015/5/21.
 */

public class ClientConnection {
    private HttpClientBuilder httpClient = null;
    private CloseableHttpClient closeableHttpClient = null;
    //private static HttpPost httpPost = null;
    private static final String URL_RANDOM_CODE = "http://210.42.121.132/servlet/GenImg";
    private static final String URL_LOGIN = "http://210.42.121.132/servlet/Login";
    private static final String URL_GRADE = "http://210.42.121.132/servlet/Svlt_QueryStuScore?year=0&term=";
    private static final String URL_GRADE_MAIN = "http://210.42.121.132/stu/stu_score_parent.jsp/stu_score_parent.jsp";
    private static final String URL_MAIN = "http://210.42.121.132/stu/stu_index.jsp";

    public ClientConnection(){
        httpClient = HttpClientBuilder.create();
        closeableHttpClient = httpClient.build();
    }

    public static void main(String[] args){
        ClientConnection conn = new ClientConnection();
       // HttpGet httpGet = new HttpGet("http://210.42.121.132/servlet/../stu/stu_index.jsp");
        //httpPost = new HttpPost("http://210.42.121.132/");
        String first_cookie = conn.downloadPic("D:\\code.jpg");
        System.out.println("first cookie " + first_cookie);
        System.out.println("please input the random code");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //List<BasicNameValuePair> pair = new ArrayList<BasicNameValuePair>();
        String randomCode = "";
        try {
            randomCode = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----" + randomCode + "----");
        conn.login("2013302480097","19951112",randomCode,first_cookie);
//        conn.getGrade();
        conn.getHome();
        //pair.add(new Bas
        // icNameValuePair());
        //httpPost.setEntity();
//        try {
//            HttpResponse response = closeableHttpClient.execute(httpGet);
//            HttpEntity entity = response.getEntity();
//            //closeableHttpClient.
//            System.out.println(response.getStatusLine());
//            //System.out.println(download(response.getEntity().getContent(), "F:\\1.png"));
//            Header[] headers = response.getAllHeaders();
//            for(Header header : headers){
//                System.out.println(header.toString());
//            }
//            if(entity != null){
//
//                System.out.println("entity: " + EntityUtils.toString(entity));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                closeableHttpClient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }


//返回登陆成功后的cookie
    public String login(String id,String pwd,String code,String first_cookie){
        HttpPost httpPost = new HttpPost(URL_LOGIN);
//        httpPost.setHeader("Cookie",first_cookie);
//        httpPost.setHeader("Host","210.42.121.132");
//        httpPost.setHeader("Referer","http://210.42.121.132/");
        Header[] h = httpPost.getAllHeaders();
//        System.out.println("------------");
//        for(Header header : h){
//            System.out.println(header);
//        }
//        System.out.println("------------");
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("id",id));
        pairs.add(new BasicNameValuePair("pwd",pwd));
        pairs.add(new BasicNameValuePair("xdvfb",code));
        try {
            UrlEncodedFormEntity urlEntity = new UrlEncodedFormEntity(pairs,"GB2312");
            httpPost.setEntity(urlEntity);

            HttpResponse response = closeableHttpClient.execute(httpPost);
//            Header cookie = response.getFirstHeader("Set-Cookie");
//            Header[] headers = response.getAllHeaders();
//            for(Header header : headers){
//                System.out.println(header.toString());
//            }
            Header location = response.getFirstHeader("Location");
//            System.out.println(EntityUtils.toString(response.getEntity()));
            String locations = location.toString();
//            System.out.println(locations.substring(locations.indexOf("http")));
//            System.out.println("second cookie " + cookie);
            return locations.substring(locations.indexOf("http"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String downloadPic(String path){
        HttpGet httpGet = new HttpGet(URL_RANDOM_CODE);
        //httpGet.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,50000);
        try {
            HttpResponse response = closeableHttpClient.execute(httpGet);
            //路径要设置
            download(response.getEntity().getContent(),path);

            String first_cookie =  response.getFirstHeader("Set-Cookie").toString();
            first_cookie = first_cookie.substring(first_cookie.indexOf("JSESSIONID"),first_cookie.indexOf(";"));
//            Header[] headers = response.getAllHeaders();
//            System.out.println("+++++++++++++++++");
//            for(Header header:headers){
//                System.out.println(header.toString());
//            }
            return first_cookie;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
 /*
从网站下载图片的方法
 */
    private static boolean download(InputStream in, String path)
    {
        FileOutputStream out = null;
        try
        {
            out = new FileOutputStream(path);
            byte b[] = new byte[1024];
            int j = 0;
            while ((j = in.read(b)) != -1)
            {
                out.write(b, 0, j);
            }
            out.flush();
            File file = new File(path);
            if(file.exists() && file.length() == 0)
                return false;
            return true;
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            if("FileNotFoundException".equals(e.getClass().getSimpleName()))
                System.err.println("download FileNotFoundException");
            if("SocketTimeoutException".equals(e.getClass().getSimpleName()))
                System.err.println("download SocketTimeoutException");
            else
                e.printStackTrace();
        } finally{

            if(out != null)
                try
                {
                    out.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            if(in != null)
                try
                {
                    in.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
        return false;
    }

    public void getGrade(){
        HttpGet httpGet = new HttpGet(URL_GRADE);
        try {
            HttpResponse response = closeableHttpClient.execute(httpGet);
//            System.out.println("grade cookie : " + httpGet.getFirstHeader("Cookie"));
//            Header[] headers = response.getAllHeaders();
//            for(Header header : headers){
//                System.out.println(header);
//            }
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void getHome(){
        HttpGet httpGet = new HttpGet(URL_MAIN);
        try {
            HttpResponse response = closeableHttpClient.execute(httpGet);
//            System.out.println("grade cookie : " + httpGet.getFirstHeader("Cookie"));
//            Header[] headers = response.getAllHeaders();
//            for(Header header : headers){
//                System.out.println(header);
//            }
            String rawStr = EntityUtils.toString(response.getEntity());
            WriteStringToFile("stu.html",rawStr);
            String[] stuInfo = fetchStudentInfo(rawStr);
            System.out.print(stuInfo[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String[] fetchStudentInfo(String rawStr){
        String nameReg = "<div id=\"nameLable\">([\\s\\S]*)<img";
        String schoolReg = "<span id=\"acade\">([\\s\\S][\\u4e00-\\u9fa5]*)</span>";
        String removeReg = "\\s*|\\t|\\r|\\n";
        String name ="";
        String school = "";
        Matcher nameMatch = Pattern.compile(nameReg).matcher(rawStr);
        while (nameMatch.find()){
            String nameRaw = nameMatch.group(1);
            Matcher removeMatch = Pattern.compile(removeReg).matcher(nameRaw);
            name = removeMatch.replaceAll("");
//            System.out.println(name);
        }
        Matcher schoolMatch = Pattern.compile(schoolReg).matcher(rawStr);
        while (schoolMatch.find()){
            String schoolRaw = schoolMatch.group(1);
            Matcher removeMatch = Pattern.compile(removeReg).matcher(schoolRaw);
            school = removeMatch.replaceAll("");
//            System.out.println(school);
        }
        return new String[]{name,school};
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
}
