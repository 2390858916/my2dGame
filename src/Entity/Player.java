package Entity;

import main.GamePanel;
import main.keyHandler;

import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;

public class Player extends Entity {
    GamePanel gp;
    keyHandler KeyH;

    public Player(GamePanel gp, keyHandler KeyH) {
        this.gp = gp;
        this.KeyH = KeyH;
        setDefaultValue();
    }

    public void setDefaultValue() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {
        if (KeyH.upPressed) {
            y -= speed;
        } else if (KeyH.downPressed) {
            y += speed;
        } else if (KeyH.leftPressed) {
            x -= speed;
        } else if (KeyH.rightPressed) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.titleSize, gp.titleSize);
    }
}
