package com.nts.jvm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileConfUtil {

	public static String getConfPath() {
		String strDir = System.getProperty("user.home");
		String home = strDir.replace('\\', File.separatorChar);
		String confName = "class_conf.properties";
		String pathName = home + File.separatorChar + confName;
		return pathName;
	}

	/**
	 * @return
	 */
	public static List<String> readConf(String key) {
		List<String> lst = new ArrayList<>();
		Properties p = readConfProp();
		String countKey = key + "_count";
		try {
			int count = Integer.parseInt(p.getProperty(countKey));
			for (int i = 1; i <= count; i++) {
				String k = key + "_" + i;
				String v=p.getProperty(k);
				if (v != null) {
					lst.add(v);
				}
			}
		} catch (Exception ex) {
			//do nothing
		}
		return lst;
	}

	private static Properties readConfProp() {
		Properties pro = new Properties();
		try {
			String pathName = getConfPath();
			pro.load(new FileInputStream(pathName));
			return pro;
		} catch (IOException e) {
			e.printStackTrace();
			return pro;
		}
	}

	public static void saveConf(String key,List<String> dataList) {
		try {
			Properties pro = new Properties();
			String pathName = getConfPath();
			File file = new File(pathName);
			FileOutputStream out = new FileOutputStream(file);
			for (int i = 0; i < dataList.size(); i++) {
				String nKey = key + "_" + (1 + i);
				pro.setProperty(nKey, dataList.get(i));
			}
			pro.setProperty(key + "_count", String.valueOf(dataList.size()));
			pro.store(out, "classView");
			out.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}


}
