package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // 屏幕设定
    final int originalTileSize = 16; //16*16s
    final int scale = 3;

    final int titleSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenwitch = titleSize * maxScreenCol;
    final int screenHeight = titleSize * maxScreenRow;

    // 游戏线程 启动或停止游戏 或重复（人物移动）

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenwitch, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //game action loop
        // 游戏在运行就重复写入过程
        while (gameThread != null) {
            System.out.println("The game loop is running");
            //1，更新内容 角色位置
            //2. 更新图片内容 新场景
            update();
            repaint();
        }
    }

    public void update() {

    }


    //画布
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //绘制图形大小
        g2.setColor(Color.white);
        g2.fillRect(100, 100, titleSize, titleSize);
        g2.dispose();
    }


}
