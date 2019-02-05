package com.yube.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {

	public static boolean Writer(String path, String name, String content,boolean mode) {
		FileWriter fw;
		BufferedWriter bw;
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		try {
			fw = new FileWriter(path + "\\" + name,mode);
			bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}
}
