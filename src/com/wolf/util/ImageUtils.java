package com.wolf.util;

import java.io.*;
import java.util.Iterator;

import com.sun.image.codec.jpeg.*;
import java.awt.image.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageUtils {
	private static final String PICTRUE_FORMATE_JPG = "jpg";

	/**
	 * 添加图片水印
	 * 
	 * @param targetImg
	 *            目标图片路径
	 * @param waterImg
	 *            水印图片路径
	 * @param outputImg
	 *            水印图片输出路径
	 * @param x
	 *            水印图片距离目标图片左侧的偏移量，如果x<0, 则在正中间 @ param y
	 *            水印图片距离目标图片上侧的偏移量，如果y<0, 则在正中间 @ param alpha 透明度(0.0 -- 1.0,
	 *            0.0为完全透明，1.0为完全不透明)
	 * @param defaultLocation 若为true 忽略X，Y作用，将水印打在右下角
	 */
	public final static void pressImage(String targetImg, String waterImg,
			String outputImg, int x, int y, float alpha ,boolean defaultLocation) {
		try {
			File file = new File(targetImg);
			Image image = ImageIO.read(file);
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			BufferedImage bufferedImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(image, 0, 0, width, height, null);

			Image waterImage = ImageIO.read(new File(waterImg)); // 水印文件
			int width_1 = waterImage.getWidth(null);
			int height_1 = waterImage.getHeight(null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));

			int widthDiff = width - width_1;
			int heightDiff = height - height_1;
			//默认情况设置为右下角
			
			if(defaultLocation){
				System.out.println("1---------"+x+"-----"+y+"---------------");
				x = widthDiff;
				y = heightDiff;
			}else{
				if (x < 0) {
					x = widthDiff / 2;
				} else if (x > widthDiff) {
					x = widthDiff;
				}
				if (y < 0) {
					y = heightDiff / 2;
				} else if (y > heightDiff) {
					y = heightDiff;
				}
				System.out.println("2---------"+x+"-----"+y+"---------------");
			}

			g.drawImage(waterImage, x, y, width_1, height_1, null); // 水印文件结束

			g.dispose();
			File outfile = new File(outputImg);
			ImageIO.write(bufferedImage, PICTRUE_FORMATE_JPG, outfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 等比例压缩图片
	 * 
	 * @param originalFile
	 *            源图片
	 * @param resizedFile
	 *            压缩后图片
	 * @param newWidth
	 *            压缩后图片宽度
	 * @param quality
	 *            图片质量 0--1之间越靠近1质量越好
	 */
	public static void resize(String originalFilePath, String resizedFilePath,int newWidth, float quality) throws IOException {

		if (quality > 1) {
			throw new IllegalArgumentException(
					"Quality has to be between 0 and 1");
		}
		File originalFile = new File(originalFilePath);
		File resizedFile = new File(resizedFilePath);
		ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
		Image i = ii.getImage();
		Image resizedImage = null;
		int iWidth = i.getWidth(null);
		int iHeight = i.getHeight(null);
		if (iWidth > iHeight) {
			resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight)
					/ iWidth, Image.SCALE_SMOOTH);
		} else {
			resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight,
					newWidth, Image.SCALE_SMOOTH);
		}

		// This code ensures that all the pixels in the image are loaded.
		Image temp = new ImageIcon(resizedImage).getImage();
		// Create the buffered image.
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
				temp.getHeight(null), BufferedImage.TYPE_INT_RGB);
		// Copy image to buffered image.
		Graphics g = bufferedImage.createGraphics();
		// Clear background and paint the image.
		g.setColor(Color.white);
		g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
		g.drawImage(temp, 0, 0, null);
		g.dispose();

		// Soften.
		float softenFactor = 0.05f;
		float[] softenArray = { 0, softenFactor, 0, softenFactor,
				1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
		Kernel kernel = new Kernel(3, 3, softenArray);
		ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		bufferedImage = cOp.filter(bufferedImage, null);

		// Write the jpeg to a file.
		FileOutputStream out = new FileOutputStream(resizedFile);
		// Encodes image as a JPEG data stream
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		JPEGEncodeParam param = encoder
				.getDefaultJPEGEncodeParam(bufferedImage);
		param.setQuality(quality, true);
		encoder.setJPEGEncodeParam(param);
		encoder.encode(bufferedImage);
	}
	
	/*
	 * lzc
	 * 2015年1月28日16:16:17
	 * @param tmpString 目标图片目录路径
	 * @param fileName 图片名称(不含图片类型)
	 * @param type 图片类型(.jpg .png)等
	 * @param deal 加工图片1
	 * @param w    加工图片2
	 * @param s    加工图片3
	 * @param water 水印图片路径   PNG图片路径
	 */
	public static void deal(String tmpString, String fileName, String type, String deal, String w, String s, String water){
		try {
			resize(tmpString + fileName + type, tmpString + fileName + deal + type,1800, 0.9f);
			
			File file = new File(tmpString + fileName + deal + type);
			Image image = ImageIO.read(file);
			File fileo = new File(water);
			Image imageo = ImageIO.read(fileo);
			pressImage(tmpString + fileName + deal + type, water,tmpString + fileName + deal + w + type, 
					 image.getWidth(null) - imageo.getWidth(null) - 10, 
					 image.getHeight(null) - imageo.getHeight(null) - 10, 0.65f,false);
			resize(tmpString + fileName + deal + w + type, tmpString + fileName + deal + w + s + type, 250, 0.95f);
			File del = new File(tmpString + fileName + deal + type);
			del.delete();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// Example usage
	public static void main(String[] a) throws IOException {
		// s_pic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度)
//		ImageUtils myImage = new ImageUtils();
//		File file = new File("E:/QW/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/jd/statics/jd/images");
		String[] str = {"banshou", "baozi", "hongfushi", "huotui", "pool", "tuina", "vegetable"
						};
		
		String tmpString = "e:/JD/water/";
		String jpg = ".JPG";
		String deal = "d";
		String w = "w";
		String s = "_s";
		String water = "e:/JD/water/water.png";
		for(int i = 0; i < 7; i++){
//			System.out.println(str[i]);
			deal(tmpString, str[i], jpg, deal, w, s, water);
		}
		
//		deal(tmpString, fileName, jpg, deal, w, s, water);
		
//		resize(tmpString + fileName + jpg, tmpString + fileName + deal + jpg,1800, 0.9f);
//		File file = new File(tmpString + fileName + deal + jpg);
//		Image image = ImageIO.read(file);
//		File fileo = new File(water);
//		Image imageo = ImageIO.read(fileo);
//		pressImage(tmpString + fileName + deal + jpg, water,tmpString + fileName + deal + w + jpg, 
//				 image.getWidth(null) - imageo.getWidth(null) - 10, 
//				 image.getHeight(null) - imageo.getHeight(null) - 10, 0.6f,false);
//		resize(tmpString + fileName + deal + w + jpg, tmpString + fileName + deal + w + s + jpg, 250, 0.95f);

		
//		resize(originalImage, new File("d:\\mlsy-1.png"),150, 1f);
	}
}