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
         * ����Ҫ��URL�µ�URLConnection�Ի��� URLConnection���Ժ����׵Ĵ�URL�õ������磺 // Using   
         *  java.net.URL and //java.net.URLConnection   
         *
         *  ʹ��ҳ�淢��������������̣���ҳ��http://www.faircanton.com/message/loginlytebox.asp�������û��������룬Ȼ�󰴵�¼�� 
         *  ��ת��ҳ��http://www.faircanton.com/message/check.asp������֤ 
         *  ��֤�ĵĽ�����ص���һ��ҳ�� 
         *
         *  ʹ��java��������������̣�ʹ��URLConnection��http://www.faircanton.com/message/check.asp�������� 
         *  �����������������û��������� 
         *  Ȼ���ó����ȡ��֤��� 
         */
        URL url = new URL("http://www.baidu.com");
        URLConnection connection = url.openConnection();
        /**
         * Ȼ���������Ϊ���ģʽ��URLConnectionͨ����Ϊ������ʹ�ã���������һ��Webҳ��   
         * ͨ����URLConnection��Ϊ���������԰����������Webҳ���͡��������������   
         */
        connection.setDoOutput(true);
        /**
         * ���Ϊ�˵õ�OutputStream�������������Լ����Writer���ҷ���POST��Ϣ�У����磺 ...   
         */

        /**
         * �����Ϳ��Է���һ����������������POST��    
         * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:   
         * text/plain Content-type: application/x-www-form-urlencoded   
         * Content-length: 99 username=bob password=someword   
         */
        // һ�����ͳɹ��������·����Ϳ��Եõ��������Ļ�Ӧ��     
        String sCurrentLine;
        String sTotalString;
        sCurrentLine = "";
        sTotalString = "";
        InputStream l_urlStream;
        l_urlStream = connection.getInputStream();
        // ��˵�е������װ����     
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(
                l_urlStream));
        while ((sCurrentLine = l_reader.readLine()) != null) {
            sTotalString += sCurrentLine + "/r/n";

        }
        //ȥ��ǩ
        String pureText = removeDiv(sTotalString);
        System.out.println(pureText);

    }

    //����html��ǩ��creat by pie
    public static String removeDiv(String inputString) {
        String htmlStr = inputString; //��html��ǩ���ַ���
        String textStr ="";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //����script��������ʽ{��<script[^>]*?>[\\s\\S]*?<\\/script> }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //����style��������ʽ{��<style[^>]*?>[\\s\\S]*?<\\/style> }
            String regEx_html = "<[^>]+>"; //����HTML��ǩ��������ʽ

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); //����script��ǩ

            p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); //����style��ǩ

            p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); //����html��ǩ

            textStr = htmlStr;

        }catch(Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }

        return textStr;//�����ı��ַ���
    }

    public static void main(String[] args) throws IOException {
        testPost();
    }
}  