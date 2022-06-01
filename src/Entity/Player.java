package Entity;

import main.GamePanel;
import main.keyHandler;

import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static javax.imageio.ImageIO.*;

public class Player extends Entity {
    GamePanel gp;
    keyHandler KeyH;

    public Player(GamePanel gp, keyHandler KeyH) {
        this.gp = gp;
        this.KeyH = KeyH;
        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    //loading player image
    public void getPlayerImage() {
        try {
            up1 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_1.png")));
            up2 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_2.png")));
            up3 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_3.png")));
            down1 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_1.png")));
            down2 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_2.png")));
            down3 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_3.png")));
            left1 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_1.png")));
            left2 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_2.png")));
            left3 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_3.png")));
            right1 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_1.png")));
            right2 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_2.png")));
            right3 = read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_3.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (KeyH.upPressed || KeyH.downPressed || KeyH.leftPressed || KeyH.rightPressed) {
            if (KeyH.upPressed) {
                direction = "up";
                y -= speed;
            } else if (KeyH.downPressed) {
                direction = "down";
                y += speed;
            } else if (KeyH.leftPressed) {
                direction = "left";
                x -= speed;
            } else {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter > 6) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3)
                    spriteNum = 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.titleSize, gp.titleSize);
        BufferedImage image = null;
        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;
                }
            }
        }
        g2.drawImage(image, x, y, gp.titleSize, gp.titleSize, null);
    }
}
