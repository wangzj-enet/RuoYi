package test;


import cn.hutool.http.HttpUtil;
import com.ruoyi.RuoYiApplication;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.pdd.task.PddTask;
import com.ruoyi.project.system.files.service.IFilesService;
import org.apache.http.entity.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={RuoYiApplication.class})
public class SpringbootTest {

	@Autowired
	private PddTask pddTask;
	/*@Test
	public void test_analysis(){
		pddTask.analysis();
	}

	@Test
	public void test_copy(){
		pddTask.copy();
	}*/


	@Test
	public void test_local(){
		pddTask.local();

	}

	}
