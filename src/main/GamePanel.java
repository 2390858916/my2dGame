package main;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
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

    ///设置帧数
    int FPS = 144;
    ////键盘操作实例化
    keyHandler KeyH = new keyHandler();
    /// set player default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    // 游戏线程 启动或停止游戏 或重复（人物移动）

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenwitch, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        //识别键盘输入
        this.addKeyListener(KeyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;


        //game action loop
        // 游戏在运行就重复写入过程
        while (gameThread != null) {
            //1，更新内容 角色位置
            //2. 更新图片内容 新场景
            update();
            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if (KeyH.upPressed) {
            playerY -= playerSpeed;
        } else if (KeyH.downPressed) {
            playerY += playerSpeed;
        } else if (KeyH.leftPressed) {
            playerX -= playerSpeed;
        } else if (KeyH.rightPressed) {
            playerX += playerSpeed;
        }
    }


    //画布
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //绘制图形大小
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, titleSize, titleSize);
        g2.dispose();
    }


}
