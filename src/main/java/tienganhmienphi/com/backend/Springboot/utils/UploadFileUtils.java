package tienganhmienphi.com.backend.Springboot.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UploadFileUtils {
	
	public final String root = "/usr/var"; 
	
	public void writeOrUpdate(byte[] bytes,String path) {
		//kiểm tra xem file tồn tại hay chưa
		File file = new File(StringUtils.substringBeforeLast(root + path, "/"));
		if(!file.exists()) {
			file.mkdir();
		}
		try(FileOutputStream fileOutputStream = new FileOutputStream(new File(root + path))) {
			fileOutputStream.write(bytes);
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	public String read(String path) {
		String imageString = "";
		File file = new File(root + path);
		try(FileInputStream fileInputStream = new FileInputStream(file);) {
	        byte byteArray[] = new byte[(int)file.length()];
	        fileInputStream.read(byteArray);
	        imageString = Base64.getEncoder().encodeToString(byteArray);
	    } 
	    catch (FileNotFoundException e) {
	        System.out.println("File Not Found.");
	        e.printStackTrace();
	    }
	    catch (IOException e1) {
	        System.out.println("Error Reading The File.");
	        e1.printStackTrace();
	    }
		System.out.println(imageString);
		return imageString;
	}
}

