package IMGCONV;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import javax.imageio.ImageIO;

public class ImageConversion {

	public static void main(String[] args) throws IOException {
		String path = "c:\\Users\\cdonohue\\Desktop\\Temp";
		String destination = "c:\\Users\\cdonohue\\Documents\\IMGFolder\\";
		Files.walk(Paths.get(path)).forEach(path_to_file -> {
			if (Files.isRegularFile(path_to_file)) {
		        File inputFile = new File(path_to_file.toString());
				int i = inputFile.getName().lastIndexOf('.');
				if (i >= 0) {
				    String ext = inputFile.getName().substring(i+1);
				    System.out.println(ext);
				    if (Objects.equals(ext, "bmp")){
				    	System.out.println("File is a "+ext);
				    	System.out.println(path_to_file);
				    	//Abpove this works and files being saved to the bmp folder are only bmps
				    	//However Conversion to jpgs is failing miserably
				    	File outputFile = new File(destination+inputFile.getName());
				        try (InputStream is = new FileInputStream(inputFile)) {
							BufferedImage image = ImageIO.read(is);
							try (OutputStream os = new FileOutputStream(outputFile)) {
								ImageIO.write(image, "jpg", os);
							} catch (Exception exp) {
								exp.printStackTrace();
							}
						} catch (Exception exp) {
							exp.printStackTrace();
						}
				    }
				}
				
		    }
		});

		

	}

}
