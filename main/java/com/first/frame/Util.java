package com.first.frame;

import java.io.FileOutputStream; 
import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void saveFile(MultipartFile pf1, MultipartFile pf2, MultipartFile pf3, MultipartFile lc1,
			MultipartFile lc2, MultipartFile lc3, String dir1, String dir2, String dir3, String dir4, String dir5,
			String dir6) {

		byte[] data1;
		byte[] data2;
		byte[] data3;
		byte[] data4;
		byte[] data5;
		byte[] data6;

		String profile1 = pf1.getOriginalFilename();
		String profile2 = pf2.getOriginalFilename();
		String profile3 = pf3.getOriginalFilename();
		String license1 = lc1.getOriginalFilename();
		String license2 = lc2.getOriginalFilename();
		String license3 = lc3.getOriginalFilename();

		try {
			data1 = pf1.getBytes();
			FileOutputStream fo1 = new FileOutputStream(dir1 + profile1);
			fo1.write(data1);
			fo1.close();

			data2 = pf2.getBytes();
			FileOutputStream fo2 = new FileOutputStream(dir2 + profile2);
			fo2.write(data2);
			fo2.close();

			data3 = pf3.getBytes();
			FileOutputStream fo3 = new FileOutputStream(dir3 + profile3);
			fo3.write(data3);
			fo3.close();

			data4 = lc1.getBytes();
			FileOutputStream fo4 = new FileOutputStream(dir4 + license1);
			fo4.write(data4);
			fo4.close();

			data5 = lc2.getBytes();
			FileOutputStream fo5 = new FileOutputStream(dir5 + license2);
			fo5.write(data5);
			fo5.close();

			data6 = lc3.getBytes();
			FileOutputStream fo6 = new FileOutputStream(dir6 + license3);
			fo6.write(data6);
			fo6.close();

		} catch (Exception e) {

		}

	}

	public static void saveFile1(MultipartFile pf1, String dir1) {

		byte[] data1;

		String profile1 = pf1.getOriginalFilename();

		try {
			data1 = pf1.getBytes();
			FileOutputStream fo1 = new FileOutputStream(dir1 + profile1);
			fo1.write(data1);
			fo1.close();

		} catch (Exception e) {

		}

	}
	
	public static void saveFile2(MultipartFile pf2, String dir2) {

		byte[] data2;

		String profile2 = pf2.getOriginalFilename();

		try {
			data2 = pf2.getBytes();
			FileOutputStream fo2 = new FileOutputStream(dir2 + profile2);
			fo2.write(data2);
			fo2.close();

		} catch (Exception e) {

		}

	}

	public static void saveFile3(MultipartFile pf3, String dir3) {

		byte[] data3;

		String profile3 = pf3.getOriginalFilename();

		try {
			data3 = pf3.getBytes();
			FileOutputStream fo3 = new FileOutputStream(dir3 + profile3);
			fo3.write(data3);
			fo3.close();

		} catch (Exception e) {

		}

	}
	
	public static void saveFile4(MultipartFile lc1, String dir4) {

		byte[] data3;

		String profile3 = lc1.getOriginalFilename();

		try {
			data3 = lc1.getBytes();
			FileOutputStream fo3 = new FileOutputStream(dir4 + profile3);
			fo3.write(data3);
			fo3.close();

		} catch (Exception e) {

		}

	}
	
	public static void saveFile5(MultipartFile lc2, String dir5) {

		byte[] data3;

		String profile3 = lc2.getOriginalFilename();

		try {
			data3 = lc2.getBytes();
			FileOutputStream fo3 = new FileOutputStream(dir5 + profile3);
			fo3.write(data3);
			fo3.close();

		} catch (Exception e) {

		}

	}
	
	public static void saveFile6(MultipartFile lc3, String dir6) {

		byte[] data3;

		String profile3 = lc3.getOriginalFilename();

		try {
			data3 = lc3.getBytes();
			FileOutputStream fo3 = new FileOutputStream(dir6 + profile3);
			fo3.write(data3);
			fo3.close();

		} catch (Exception e) {

		}

	}
	
	
	public static void saveFileR(MultipartFile rp, String dir7) {

		byte[] dataR;

		String report = rp.getOriginalFilename();

		try {
			dataR = rp.getBytes();
			FileOutputStream foR = new FileOutputStream(dir7 + report);
			foR.write(dataR);
			foR.close();

		} catch (Exception e) {

		}

	}


}
