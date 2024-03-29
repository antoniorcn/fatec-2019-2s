package io;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import javax.imageio.ImageIO;

public class LeituraImagemPixels {
	// https://coding-robin.de/2013/07/22/train-your-own-opencv-haar-classifier.html
	public static void main(String[] args) {
		File f = new File("C:/Users/anton/Pictures/IMG-20190503-WA0007.jpg");
		try { 
			FileInputStream imgIS = new FileInputStream(f);
			BufferedImage img = ImageIO.read(imgIS);
			WritableRaster raster = img.getRaster();
			FileWriter fw = new FileWriter("C:/tmp2/image.txt");
			int i = 0;
			int count = 0;
			for (int y = 0; y < raster.getHeight(); y++) {
				for (int x = 0; x < raster.getWidth(); x++) {
					int pixel = img.getRGB(x, y);
					int r = (pixel & 0b111111110000000000000000);
					int g = (pixel & 0b000000001111111100000000) << 8;
					int b = (pixel & 0b000000000000000011111111) << 16;
					int m = (r + g + b)/3;
					char c = r > 128 ? '.' : ' '; 
					System.out.print(c);
					fw.write(c);
				}
				System.out.println(count++);
				fw.write('\n');
				fw.flush();
			}
			fw.close();
		} catch(Exception e) { 
			e.printStackTrace();
		}

	}
}
