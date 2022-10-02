package com.life.recrention;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.*;

public class Heart extends JFrame {

    private static final long serialVersionUID = -1284128891908775645L;

    // 定义加载窗口大小

    public static final int GAME_WIDTH = 500;

    public static final int GAME_HEIGHT = 500;
    // 获取屏幕窗口大小
    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;

    public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Heart() {

        // 设置窗口标题
        this.setTitle("心形曲线");
        // 设置窗口初始位置
        this.setLocation((WIDTH - GAME_WIDTH) / 2, (HEIGHT - GAME_HEIGHT) / 2);
        // 设置窗口大小
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        // 设置背景色
        this.setBackground(Color.BLACK);
        // 设置窗口关闭方式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口显示
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        double x, y, r;
        Image OffScreen = createImage(GAME_WIDTH, GAME_HEIGHT);
        Graphics drawOffScreen = OffScreen.getGraphics();
        for (int i = 0; i < 90; i++) {
            for (int j = 0; j < 90; j++) {
                r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
                x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + GAME_WIDTH / 2;
                y = -r * Math.sin(Math.PI / 45 * j) + GAME_HEIGHT / 4;
                //设置画笔颜色
                drawOffScreen.setColor(Color.PINK);
                // 绘制椭圆
                drawOffScreen.fillOval((int) x, (int) y, 2, 2);
            }
            // 生成图片
            g.drawImage(OffScreen, 0, 0, this);
        }
    }

    public static void heart2() {
        double x, y;
        char[] s = new char[]{'I',' ','l','o','v','e',' ','y','o','u','!'};
        int index;
        for(y = 1.3f; y > -1.1f; y -= 0.06f){
            index=0;
            for(x = -1.1f; x <= 1.1f; x += 0.025f){
                double result=x*x+pow((5.0*y/4.0-sqrt(abs(x))),2);
                if(result<=1) {
                    System.out.print((s[index]));
                    index=(index+1)%11;
                }
                else{
                    System.out.print(' ');
                }
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        Heart demo = new Heart();
        demo.setVisible(true);
        heart2();
    }

}
