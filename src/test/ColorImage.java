package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;

import javax.imageio.ImageIO;
public class ColorImage {

	
	public LinkedList<Double> getImagePixel(String image,int r, int g, int b,int r1, int g1, int b1) throws Exception {
		LinkedList<Double> result = new LinkedList<>();
		int[] rgb = new int[3];
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		double likelihood1 = Math.sqrt(Math.abs(r1-r)^2+Math.abs(g1-g)^2+Math.abs(b1-b)^2)/Math.sqrt(255*255*3);
		System.out.println("width=" + width + ",height=" + height + ".");
		System.out.println("minx=" + minx + ",miniy=" + miny + ".");
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				double likelihood = Math.sqrt(Math.abs(rgb[0]-r)^2+Math.abs(rgb[1]-g)^2+Math.abs(rgb[2]-b)^2)/Math.sqrt(255*255*3);
//				System.out.println(likelihood);
				result.add(likelihood);
//				System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","
//						+ rgb[1] + "," + rgb[2] + ")" );
			}
		}
		Collections.sort(result);
		int times = 0;
		for (Double a: result) {
			if (a<likelihood1) {
				times++;
			}
		}
		System.out.println(times*1.0/result.size()*1.0);
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		ColorImage rc = new ColorImage();
//		LinkedList<Double> result = rc.getImagePixel("resource/image/pdf/1-1号/2-4.JPG",228,255,19,255,138,8);
		LinkedList<Double> result = rc.getImagePixel("resource/image/pdf/1-1号/18-20.JPG",127,0,0,246,114,78);
//		for (Double a: result) {
//			System.out.println(a);123
//		}
	}

}
