package JavaCrawler;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
* @author ��fuwenbin   
* @Email: 185723075@qq.com	
* @created at ��2017��9��5�� ����10:54:54 
* ��˵��
*/

public class Main {

    // ��ַ
    private static final String URL = "http://www.ali213.net/";
//    http://www.baidu.com
//    http://www.tooopen.com/view/1439719.html
    
    
    
    // ��ȡimg��ǩ����
    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
    // ��ȡsrc·��������
    private static final String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)";
    
    

    public static void main(String[] args) {
        try {
            Main cm=new Main();
            //���html�ı�����
            String HTML = cm.getHtml(URL);
            //��ȡͼƬ��ǩ
            List<String> imgUrl = cm.getImageUrl(HTML);
            //��ȡͼƬsrc��ַ
            List<String> imgSrc = cm.getImageSrc(imgUrl);
            //����ͼƬ
            cm.Download(imgSrc);

        }catch (Exception e){
            System.out.println("��������");
        }

    }

   //��ȡHTML����
    private String getHtml(String url)throws Exception{
        URL url1=new URL(url);//ʹ��java.net.URL
        URLConnection connection=url1.openConnection();//������
        InputStream in=connection.getInputStream();//��ȡ������
        InputStreamReader isr=new InputStreamReader(in);//���İ�װ
        BufferedReader br=new BufferedReader(isr);

        String line;
        StringBuffer sb=new StringBuffer();
        while((line=br.readLine())!=null){//���ж�ȡ
            sb.append(line,0,line.length());//��ӵ�StringBuffer��
            sb.append('\n');//��ӻ��з�
        }
      //�رո��������������ĺ�ر�
        br.close();
        isr.close();
        in.close();
        return sb.toString();
    }

    //��ȡImageUrl��ַ
    private List<String> getImageUrl(String html){
        Matcher matcher=Pattern.compile(IMGURL_REG).matcher(html);
        List<String>listimgurl=new ArrayList<String>();
        while (matcher.find()){
            listimgurl.add(matcher.group());
        }
        return listimgurl;
    }

    //��ȡImageSrc��ַ
    private List<String> getImageSrc(List<String> listimageurl){
        List<String> listImageSrc=new ArrayList<String>();
        for (String image:listimageurl){
            Matcher matcher=Pattern.compile(IMGSRC_REG).matcher(image);
            while (matcher.find()){
                listImageSrc.add(matcher.group().substring(0, matcher.group().length()-1));
            }
        }
        return listImageSrc;
    }

    //����ͼƬ
    private void Download(List<String> listImgSrc) {
        try {
            //��ʼʱ��
            Date begindate = new Date();
            for (String url : listImgSrc) {
                //��ʼʱ��
                Date begindate2 = new Date();
                String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
                URL uri = new URL(url);
                InputStream in = uri.openStream();
                //�ļ������
                FileOutputStream fo = new FileOutputStream(new File(
                		"rec//"+imageName));
                byte[] buf = new byte[1024];
                int length = 0;
                System.out.println("��ʼ����:" + url);
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                //�ر���
                in.close();
                fo.close();
                System.out.println(imageName + "�������");
                //����ʱ��
                Date overdate2 = new Date();
                double time = overdate2.getTime() - begindate2.getTime();
                System.out.println("��ʱ��" + time / 1000 + "s");
            }
            Date overdate = new Date();
            double time = overdate.getTime() - begindate.getTime();
            System.out.println("�ܺ�ʱ��" + time / 1000 + "s");
        } catch (Exception e) {
            System.out.println("����ʧ��");
        }
    }
}
