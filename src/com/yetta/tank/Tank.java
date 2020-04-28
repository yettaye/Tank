package com.yetta.tank;

import java.awt.*;

/**
 * *
 * tank对象类
 * @author chunying.ye
 * @date 2020/4/28
 */
public class Tank {
    //坦克坐标
    private int x,y;
    //坦克的方向
    private Dir dir = Dir.DOWN;
    //速度
    private final int speed = 10;

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private boolean moving=false;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        if(moving) {
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

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
