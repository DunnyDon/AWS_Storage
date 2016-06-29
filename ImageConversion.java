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
		//define your file location and your file destination
		String path = "c:\\Users\\cdonohue\\Desktop\\Temp";
		String destination = "c:\\Users\\cdonohue\\Documents\\IMGFolder\\";
		//walk the path of where the files are located
		Files.walk(Paths.get(path)).forEach(path_to_file -> {
			if (Files.isRegularFile(path_to_file)) {
				//check if files
		        File inputFile = new File(path_to_file.toString());
				int i = inputFile.getName().lastIndexOf('.');
				if (i >= 0) {
				    String ext = inputFile.getName().substring(i+1);
				    //System.out.println(ext);
				    //debugging to check what kind of files they are
				    if (Objects.equals(ext, "bmp")){
				    	//System.out.println("File is a "+ext);
				    	//System.out.println(path_to_file);
				    	//^^Path to original file
				    	//if file is jpg then create a new file with the same name but with jpg replacing bmp
				    	File outputFile = new File((destination+inputFile.getName()).replace(".bmp",".jpg"));
				        try (InputStream is = new FileInputStream(inputFile)) {
							BufferedImage image = ImageIO.read(is);
							try (OutputStream os = new FileOutputStream(outputFile)) {
								ImageIO.write(image, "jpg", outputFile);
								//write the image to that file
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
