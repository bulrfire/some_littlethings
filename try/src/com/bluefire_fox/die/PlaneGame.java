package com.bluefire_fox.die;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class PlaneGame extends JPanel implements KeyListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLANE_WIDTH = 50;
    private static final int PLANE_HEIGHT = 50;
    private static final int ENEMY_WIDTH = 30;
    private static final int ENEMY_HEIGHT = 30;

    private boolean running;
    private Timer timer;
    private int planeX, planeY;
    private ArrayList<Point> enemies;

    public PlaneGame() {
        planeX = WIDTH / 2 - PLANE_WIDTH / 2;
        planeY = HEIGHT - 100;
        enemies = new ArrayList<>();
        running = true;

        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    update();
                    repaint();
                }
            }
        });
        timer.start();
    }

    private void update() {
        // 添加新的敌机
        Random random = new Random();
        if (random.nextInt(100) < 2) {
            int enemyX = random.nextInt(WIDTH - ENEMY_WIDTH);
            int enemyY = 0;
            enemies.add(new Point(enemyX, enemyY));
        }

        // 更新敌机位置
        for (int i = 0; i < enemies.size(); i++) {
            Point enemy = enemies.get(i);
            enemy.y += 5;
            if (enemy.y >= HEIGHT) {
                enemies.remove(i);
                i--;
            }
        }

        // 碰撞检测
        Rectangle planeRect = new Rectangle(planeX, planeY, PLANE_WIDTH, PLANE_HEIGHT);
        for (int i = 0; i < enemies.size(); i++) {
            Point enemy = enemies.get(i);
            Rectangle enemyRect = new Rectangle(enemy.x, enemy.y, ENEMY_WIDTH, ENEMY_HEIGHT);
            if (planeRect.intersects(enemyRect)) {
                running = false;
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 绘制飞机
        g.setColor(Color.RED);
        g.fillRect(planeX, planeY, PLANE_WIDTH, PLANE_HEIGHT);

        // 绘制敌机
        g.setColor(Color.WHITE);
        for (Point enemy : enemies) {
            g.fillRect(enemy.x, enemy.y, ENEMY_WIDTH, ENEMY_HEIGHT);
        }

        if (!running) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("游戏结束", WIDTH / 2 - 100, HEIGHT / 2);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int moveStep = 20; // 增加步长
        if (e.getKeyCode() == KeyEvent.VK_LEFT && planeX > 0) {
            planeX -= moveStep;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && planeX < WIDTH - PLANE_WIDTH) {
            planeX += moveStep;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("打飞机小游戏");
                frame.setSize(WIDTH, HEIGHT);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);

                PlaneGame game = new PlaneGame();
                frame.add(game);
                frame.addKeyListener(game);

                frame.setVisible(true);
            }
        });
    }
}

