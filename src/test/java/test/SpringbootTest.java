package test;


import com.ruoyi.RuoYiApplication;
import com.ruoyi.project.pdd.task.PddTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(classes={RuoYiApplication.class})
public class SpringbootTest {

	@Autowired
	private PddTask pddTask;

	@Test
	public void test(){
		pddTask.analysis();
	}

}
