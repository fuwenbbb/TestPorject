package JavaCrawler;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
* @author ：fuwenbin   
* @Email: 185723075@qq.com	
* @created at ：2017年9月5日 上午10:54:54 
* 类说明
*/

public class Main {

    // 地址
    private static final String URL = "http://www.ali213.net/";
//    http://www.baidu.com
//    http://www.tooopen.com/view/1439719.html
    
    
    
    // 获取img标签正则
    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
    // 获取src路径的正则
    private static final String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)";
    
    

    public static void main(String[] args) {
        try {
            Main cm=new Main();
            //获得html文本内容
            String HTML = cm.getHtml(URL);
            //获取图片标签
            List<String> imgUrl = cm.getImageUrl(HTML);
            //获取图片src地址
            List<String> imgSrc = cm.getImageSrc(imgUrl);
            //下载图片
            cm.Download(imgSrc);

        }catch (Exception e){
            System.out.println("发生错误");
        }

    }

   //获取HTML内容
    private String getHtml(String url)throws Exception{
        URL url1=new URL(url);//使用java.net.URL
        URLConnection connection=url1.openConnection();//打开链接
        InputStream in=connection.getInputStream();//获取输入流
        InputStreamReader isr=new InputStreamReader(in);//流的包装
        BufferedReader br=new BufferedReader(isr);

        String line;
        StringBuffer sb=new StringBuffer();
        while((line=br.readLine())!=null){//整行读取
            sb.append(line,0,line.length());//添加到StringBuffer中
            sb.append('\n');//添加换行符
        }
      //关闭各种流，先声明的后关闭
        br.close();
        isr.close();
        in.close();
        return sb.toString();
    }

    //获取ImageUrl地址
    private List<String> getImageUrl(String html){
        Matcher matcher=Pattern.compile(IMGURL_REG).matcher(html);
        List<String>listimgurl=new ArrayList<String>();
        while (matcher.find()){
            listimgurl.add(matcher.group());
        }
        return listimgurl;
    }

    //获取ImageSrc地址
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

    //下载图片
    private void Download(List<String> listImgSrc) {
        try {
            //开始时间
            Date begindate = new Date();
            for (String url : listImgSrc) {
                //开始时间
                Date begindate2 = new Date();
                String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
                URL uri = new URL(url);
                InputStream in = uri.openStream();
                //文件输出流
                FileOutputStream fo = new FileOutputStream(new File(
                		"rec//"+imageName));
                byte[] buf = new byte[1024];
                int length = 0;
                System.out.println("开始下载:" + url);
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                //关闭流
                in.close();
                fo.close();
                System.out.println(imageName + "下载完成");
                //结束时间
                Date overdate2 = new Date();
                double time = overdate2.getTime() - begindate2.getTime();
                System.out.println("耗时：" + time / 1000 + "s");
            }
            Date overdate = new Date();
            double time = overdate.getTime() - begindate.getTime();
            System.out.println("总耗时：" + time / 1000 + "s");
        } catch (Exception e) {
            System.out.println("下载失败");
        }
    }
}
