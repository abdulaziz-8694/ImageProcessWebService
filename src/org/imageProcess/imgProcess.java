package org.imageProcess;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.jws.WebService;

@WebService
public class imgProcess {
	
	public byte[] getImage(byte []originalArray, int effect) throws InterruptedException{		
		try{
			InputStream in = new ByteArrayInputStream(originalArray);
			BufferedImage originalbuf = ImageIO.read(in);
			System.out.println("image about to be saved");
			ImageIO.write(originalbuf, "png", new File("D:/images/original.png"));			
			System.out.println("image saved");
			
			processImg(effect);
			
			BufferedImage originalImage = ImageIO.read(new File("D:/images/processed.png"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;
			
		} catch(IOException e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	private void processImg(int effect) throws InterruptedException{
		String command="";
		try{
			Process p;
			switch(effect){
				case 1:
					command = "convert D:/images/original.png -blur 0x4 D:/images/processed.png";
					p = Runtime.getRuntime().exec(new String[]{"cmd", "/c",command});
					p.waitFor();
					break;
				
				case 2:
					command = "convert D:/images/original.png -colorspace Gray D:/images/processed.png";
					p = Runtime.getRuntime().exec(new String[]{"cmd", "/c",command});
					p.waitFor();
					break;
					
				case 3:
					command = "convert D:/images/original.png -negate -edge 5 D:/images/processed.png";
					p = Runtime.getRuntime().exec(new String[]{"cmd", "/c",command});
					p.waitFor();
					break;
					
				case 4:
					command = "convert D:/images/original.png -negate D:/images/processed.png";
					p = Runtime.getRuntime().exec(new String[]{"cmd", "/c",command});
					p.waitFor();
					break;
				
				case 5:
					command = "convert D:/images/original.png -sepia-tone 90% D:/images/processed.png";
					p = Runtime.getRuntime().exec(new String[]{"cmd", "/c",command});
					p.waitFor();
					break;
					
				case 6:
					command = "convert D:/images/original.png -blur 0x8 -emboss 5 D:/images/processed.png";
					p = Runtime.getRuntime().exec(new String[]{"cmd", "/c",command});
					p.waitFor();
					break;
			}
		
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

}