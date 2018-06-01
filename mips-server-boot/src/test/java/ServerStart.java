

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ServerStart
{
    public static void main (String[] args) throws Throwable
    {
        System.out.println ("后台服务开始启动...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext (new String[]
        { "classpath:META-INF/mips-test-service.spring.xml" });
        context.start ();
        System.out.println ("后台服务启动成功...");
//        UploadDetailBackgroundService bgService = context.getBean (UploadDetailBackgroundService.class);
//        bgService.uploadDetailBackground ();
        System.in.read (); // 按任意键退出
    }
}
