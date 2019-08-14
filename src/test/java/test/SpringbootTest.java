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
	public void test_analysis(){
		pddTask.analysis();
	}

	@Test
	public void test_copy(){
		pddTask.copy();
	}


	@Test
	public void test_local(){
		pddTask.local();

	}

	@Test
	public void test_rule(){

		pddTask.rule();

	}

	@Test
	public void test_all(){
		pddTask.analysis();
		pddTask.copy();
		pddTask.local();
		pddTask.rule();

	}

	}
