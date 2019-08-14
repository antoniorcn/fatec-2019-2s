package io;

import java.io.File;
import java.io.FileInputStream;

public class LeituraImagem {

	public static void main(String[] args) {
		File f = new File("C:/Users/anton/Pictures/IMG-20190503-WA0007.jpg");
		try { 
			FileInputStream imgIS = new FileInputStream(f);
			int i = 0;
			int count = 0;
			while((i = imgIS.read()) != -1) { 
				System.out.print(Integer.toHexString(i));
				count++;
				if (count % 100 == 0) { 
					System.out.println();
				}
			}
			System.out.println("\nBytes Lidos" + count);
		} catch(Exception e) { 
			e.printStackTrace();
		}

	}

}
