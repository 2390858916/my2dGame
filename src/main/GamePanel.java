package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    // 屏幕设定
    final int originalTileSize = 16; //16*16s
    final int scale = 3;

    final int titleSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenwitch = titleSize * maxScreenCol;
    final int screenHeight = titleSize * maxScreenRow;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenwitch, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }


}
