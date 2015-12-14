package donggua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

public class Post {
    public static void testPost() throws IOException {
        /**
         * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using   
         *  java.net.URL and //java.net.URLConnection   
         *
         *  使用页面发送请求的正常流程：在页面http://www.faircanton.com/message/loginlytebox.asp中输入用户名和密码，然后按登录， 
         *  跳转到页面http://www.faircanton.com/message/check.asp进行验证 
         *  验证的的结果返回到另一个页面 
         *
         *  使用java程序发送请求的流程：使用URLConnection向http://www.faircanton.com/message/check.asp发送请求 
         *  并传递两个参数：用户名和密码 
         *  然后用程序获取验证结果 
         */
        URL url = new URL("http://www.baidu.com");
        URLConnection connection = url.openConnection();
        /**
         * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。   
         * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：   
         */
        connection.setDoOutput(true);
        /**
         * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...   
         */

        /**
         * 这样就可以发送一个看起来象这样的POST：    
         * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:   
         * text/plain Content-type: application/x-www-form-urlencoded   
         * Content-length: 99 username=bob password=someword   
         */
        // 一旦发送成功，用以下方法就可以得到服务器的回应：     
        String sCurrentLine;
        String sTotalString;
        sCurrentLine = "";
        sTotalString = "";
        InputStream l_urlStream;
        l_urlStream = connection.getInputStream();
        // 传说中的三层包装阿！     
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(
                l_urlStream));
        while ((sCurrentLine = l_reader.readLine()) != null) {
            sTotalString += sCurrentLine + "/r/n";

        }
        //去标签
        String pureText = removeDiv(sTotalString);
        System.out.println(pureText);

    }

    //过滤html标签，creat by pie
    public static String removeDiv(String inputString) {
        String htmlStr = inputString; //含html标签的字符串
        String textStr ="";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
            String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); //过滤script标签

            p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); //过滤style标签

            p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); //过滤html标签

            textStr = htmlStr;

        }catch(Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }

        return textStr;//返回文本字符串
    }

    public static void main(String[] args) throws IOException {
        testPost();
    }
}  