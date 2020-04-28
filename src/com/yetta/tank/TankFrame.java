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
    private Tank tank;
    /**
     *
     */
    public TankFrame(){
        tank = new Tank(200,200);
        setSize(800,800);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);
        //frame的监听事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //按键监听事件
        addKeyListener(new MyKeyListener());
    }

    /**
     * 重新画的时候系统自动调用
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        tank.paint(g);
    }

    /**
     * 内部类，键盘监听类
     */
    class MyKeyListener extends KeyAdapter{

        boolean BU=false,BD=false,BL=false,BR=false;

        @Override
        public void keyPressed(KeyEvent e) {
           int key = e.getKeyCode();
           switch(key){
               case KeyEvent.VK_UP: BU=true;break;
               case KeyEvent.VK_DOWN:BD=true;break;
               case KeyEvent.VK_LEFT:BL=true;break;
               case KeyEvent.VK_RIGHT:BR=true;break;
               default:break;
           }

           setTankDir();

        }
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key){
                case KeyEvent.VK_UP: BU=false;break;
                case KeyEvent.VK_DOWN:BD=false;break;
                case KeyEvent.VK_LEFT:BL=false;break;
                case KeyEvent.VK_RIGHT:BR=false;break;
                default:break;
            }
            setTankDir();
        }

        private void setTankDir() {
            if(!BU && !BL && !BD && !BR){
                tank.setMoving(false);
            }else{
                tank.setMoving(true);
                if(BU){ tank.setDir(Dir.UP);}
                if(BD){tank.setDir(Dir.DOWN);}
                if(BL){tank.setDir(Dir.LEFT);}
                if(BR){tank.setDir(Dir.RIGHT);}
            }
        }

    }
}
