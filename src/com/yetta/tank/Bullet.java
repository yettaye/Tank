package com.yetta.tank;

import java.awt.*;

/**
 * *
 * 子弹类
 * @author chunying.ye
 * @date 2020/4/28
 */
public class Bullet {
    //子弹的速度
    private final int speed = 10;
    //子弹的坐标
    private int x,y;
    //字段宽度和高度
    private  static int WIDTH=10;
    private  static int HEIGHT=10;
    private TankFrame tankFrame;

    private boolean living=true;

    //坦克的方向
    private Dir dir;

    public Bullet(int x, int y,Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    //画子弹
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(color);
        //边界检测
        checkBound();
        if(!living){
            tankFrame.removeBullets(this);
        }else{
            switch (dir) {
                case LEFT:
                    x -= speed;
                    break;
                case RIGHT:
                    x += speed;
                    break;
                case UP:
                    y -= speed;
                    break;
                case DOWN:
                    y += speed;
                    break;
                default:
                    break;
            }
        }

    }

    private void checkBound() {
        if(x<=0 || x>=TankFrame.WIDTH || y<=0 || y>=TankFrame.HEIGHT){
            living=false;
        }
    }


}
