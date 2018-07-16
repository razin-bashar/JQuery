package com.reve;

import com.reve.util.SliderManager;
import javafx.scene.control.Slider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTests {

	@Autowired
	SliderManager sliderManager;
	@Test
	public void fileTest(){
		try {
			sliderManager.listFilesForFolder();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void contextLoads() {
	}

}
