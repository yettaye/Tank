package com.yetta.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * *
 *
 * @author chunying.ye
 * @date 2020/4/28
 */
public class TankFrame extends Frame {
    private int x=200,y=200;
    /**
     *
     */
    public TankFrame(){
        setSize(800,800);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 重新画的时候系统自动调用
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        System.out.println("----paint");
        g.fillRect(x,y,50,50);
        //x+=10;
       // y+=10;

    }

    /**
     * 内部类，
     */
    class MyKeyListener extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
           int key = e.getKeyCode();
           switch(key){

           }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    }
}
