package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	public Properties inializeProperties(){
		Properties prob = new Properties();
		FileInputStream f;
		try {
			f = new FileInputStream(new File("src\\test\\resource\\Config\\config.properties"));
			prob.load(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prob;
	}
}
