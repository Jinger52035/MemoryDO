package Test1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;

public class A extends JFrame{
	private int w = 500;// 窗口宽度
	private int h = 500;// 窗口高度

	// 窗口方法
	public void launchFrame() {
		this.setTitle("地图0.4");
		this.setVisible(true);
		this.setSize(w, h);
		this.setLocation(100, 100);// 窗口的坐标
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
				System.exit(0);
			}
		});
	}

	// 主方法
	public static void main(String[] args) {
		A a = new A();
		a.launchFrame();
	}

	// 绘制
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int a = 1;// 定义像素块大小
		int s = (int) (Math.random() * 20000);// 随机种子

		// 使用百噪声函数
		float[][] noises = GenerateWhiteNoise(w, h, s);

		// 嵌套循环赋值
		for (int i = 0; i < w / a; i++) {
			for (int j = 0; j < h / a; j++) {
				int co = (int) (noises[i][j] * 256);
				Color c = new Color(co, co, co);// 随机颜色
				g.setColor(c);// 设置颜色
				g.fillRect(i * a, j * a, a, a);// 绘制实心方块 前两个是坐标，后两个是大小
			}
		}

	}

	// 白噪声函数，是一个二维数组，每个数大于等于0，小于1
	public float[][] GenerateWhiteNoise(int width, int height, int seed) {
		Random r = new Random(seed);
		float[][] noise = new float[width][];
		for (int i = 0; i < width; i++) {
			noise[i] = new float[height];
		}

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				noise[i][j] = (float) r.nextDouble() % 1;
			}
		}
		return noise;
	}
}
