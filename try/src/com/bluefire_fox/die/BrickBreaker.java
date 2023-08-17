package com.bluefire_fox.die;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class BrickBreaker extends JFrame implements ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_HEIGHT = 20;
    private static final int BALL_DIAMETER = 20;
    private static final int BRICK_WIDTH = 60;
    private static final int BRICK_HEIGHT = 20;
    private static final int BRICK_ROWS = 5;
    private static final int BRICK_COLUMNS = 10;
    private static final int DELAY = 10;

    private Timer timer;
    private int ballX, ballY, ballXSpeed, ballYSpeed;
    private int paddleX, paddleY;
    private boolean leftPressed, rightPressed;
    private boolean[][] bricks;

    private Image bufferImage;
    private Graphics bufferGraphics;

    public BrickBreaker() {
        setTitle("Brick Breaker");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        bricks = new boolean[BRICK_ROWS][BRICK_COLUMNS];
        resetBricks();

        ballX = WIDTH / 2 - BALL_DIAMETER / 2;
        ballY = HEIGHT / 2 - BALL_DIAMETER / 2;
        ballXSpeed = 2;
        ballYSpeed = 2;

        paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;
        paddleY = HEIGHT - PADDLE_HEIGHT;

        timer = new Timer(DELAY, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = true;
                }
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = false;
                }
            }
        });

        setFocusable(true);

        // 创建双缓冲
        bufferImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        bufferGraphics = (Graphics2D) bufferImage.getGraphics();
    }

    public void actionPerformed(ActionEvent e) {
        if (leftPressed && paddleX > 0) {
            paddleX -= 3;
        }
        if (rightPressed && paddleX < WIDTH - PADDLE_WIDTH) {
            paddleX += 3;
        }

        ballX += ballXSpeed;
        ballY += ballYSpeed;

        if (ballX <= 0 || ballX >= WIDTH - BALL_DIAMETER) {
            ballXSpeed *= -1;
        }

        if (ballY <= 0 || ballY >= HEIGHT - BALL_DIAMETER) {
            ballYSpeed *= -1;
        }

        if (ballX >= paddleX && ballX <= paddleX + PADDLE_WIDTH && ballY >= paddleY - BALL_DIAMETER) {
            ballYSpeed *= -1;
        }

        for (int row = 0; row < BRICK_ROWS; row++) {
            for (int col = 0; col < BRICK_COLUMNS; col++) {
                if (bricks[row][col]) {
                    int brickX = col * BRICK_WIDTH + 50;
                    int brickY = row * BRICK_HEIGHT + 50;
                    Rectangle brick = new Rectangle(brickX, brickY, BRICK_WIDTH, BRICK_HEIGHT);
                    Rectangle ball = new Rectangle(ballX, ballY, BALL_DIAMETER, BALL_DIAMETER);

                    if (ball.intersects(brick)) {
                        bricks[row][col] = false;
                        ballYSpeed *= -1;
                    }
                }
            }
        }

        // 更新界面
        updateGraphics();
    }

    private void updateGraphics() {
        // 使用双缓冲绘制界面
        bufferGraphics.setColor(Color.WHITE);
        bufferGraphics.fillRect(0, 0, WIDTH, HEIGHT);

        bufferGraphics.setColor(Color.BLUE);
        bufferGraphics.fillOval(ballX, ballY, BALL_DIAMETER, BALL_DIAMETER);

        bufferGraphics.setColor(Color.RED);
        bufferGraphics.fillRect(paddleX, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);

        bufferGraphics.setColor(Color.GREEN);
        for (int row = 0; row < BRICK_ROWS; row++) {
            for (int col = 0; col < BRICK_COLUMNS; col++) {
                if (bricks[row][col]) {
                    int brickX = col * BRICK_WIDTH + 50;
                    int brickY = row * BRICK_HEIGHT + 50;
                    bufferGraphics.fillRect(brickX, brickY, BRICK_WIDTH, BRICK_HEIGHT);
                }
            }
        }

        // 将缓冲区绘制到屏幕上
        Graphics g = getGraphics();
        g.drawImage(bufferImage, 0, 0, this);
        g.dispose();
    }

    public void resetBricks() {
        for (int row = 0; row < BRICK_ROWS; row++) {
            for (int col = 0; col < BRICK_COLUMNS; col++) {
                bricks[row][col] = true;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BrickBreaker().setVisible(true);
            }
        });
    }
}
