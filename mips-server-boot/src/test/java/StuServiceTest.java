import org.springframework.context.annotation.Configuration;

import com.th.supcom.test.serverimpl.service.StuService;
public class StuServiceTest {
	private StuService stuService;
	public void test(){
		stuService.delStu("");
	}
}
