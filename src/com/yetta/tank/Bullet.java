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

    public Bullet(int x, int y,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    //画子弹
    public void paint(Graphics g) {
        if(!living){
            tankFrame.removeBullets(this);
        }
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(color);
        if(x>=TankFrame.WIDTH || y>=TankFrame.HEIGHT){
            living=false;
        }
        x+=speed;
        y+=speed;


    }



}
