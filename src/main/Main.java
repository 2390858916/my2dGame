package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口
        window.setResizable(false); //不能调整大小
        window.setTitle("2d name");

        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
