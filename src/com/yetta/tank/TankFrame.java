package com.yetta.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * *
 *
 * @author chunying.ye
 * @date 2020/4/28
 */
public class TankFrame extends Frame {
    public final static int WIDTH=800;
    public final static int HEIGHT=800;
    private Tank tank;
    /**
     *   子弹
     */
    private List<Bullet> bullets = new ArrayList<Bullet>();

    /**
     * 敌方坦克
     */
    private List<Tank> tanks = new ArrayList<>();

    /**
     *
     */
    public TankFrame(){
        tank = new Tank(200,200,this);
        setSize(WIDTH,HEIGHT);
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
        /**
         * 子弹发射
         */
        for(int i=0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }

        Color color = g.getColor();
        g.setColor(Color.red);
        //子弹的个数
        g.drawString("子弹的个数："+bullets.size(),100,50);
        g.setColor(color);


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
               case KeyEvent.VK_CONTROL:
                   tank.fire();
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

    public void addBullets(Bullet bullet) {
        bullets.add(bullet);
    }

    public void removeBullets(Bullet bullet) {
        bullets.remove(bullet);
    }
}
