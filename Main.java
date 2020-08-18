package AutoArroz;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Main implements Runnable{

    int lowx = 391;
    int lowy = 503;



    Coordinator c = new Coordinator();

    static int j = 0;


    static Thread[] threads = new Thread[14];


    static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    static Color color = new Color(40, 89, 100);

    static int[] ovenNums = new int[]{567, 370, 682, 370, 881, 360, 982, 352, 572, 254, 665, 250, 758, 258, 873, 258, 979, 272, 562, 170, 652, 165, 760, 185, 881, 168, 983, 148};


    public static void main(String[] args) {
        Main main = new Main();

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_TAB);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_TAB);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        robot.mouseMove(0, 0);
        robot.mouseMove(719, 611);


        for (int i = 0; i < 14; i++) {
            for (int p = 0; p < threads.length; p++) {
                threads[p] = new Thread(main);
            }
            for (j=0; j < threads.length; j++) {
                threads[j].start();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(103000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void run() {
        cook(ovenNums[j*2], ovenNums[j*2+1], j);
    }

    // x and y is the position of the oven
    public void cook(int x, int y, int j) {
        int[] loc = c.ingredientCoords();
        mouseMove(0, 0);
        mouseMove(loc[0], loc[1]); // click on rice
        click(j);
        mouseMove(x, y); // move to oven
        click(j);
        try {
            threads[j].sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mouseMove(lowx, lowy); // click on low, begins cooking
        click(j);
        try {
            threads[j].sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(j == threads.length-1){
            esc();
        }
        try {
            threads[j].sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(j == threads.length-1) {
            for (int i = 0; i < 10; i++) {
                Color color = new Color(40, 89, 100);
                if(robot.getPixelColor(1103, 160).equals(color)){
                    esc();
                }
                try {
                    threads[j].sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                threads[j].sleep(19750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        else {
            try {
                threads[j].sleep(29750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mouseMove(loc[2], loc[3]); // click on onion
        click(j);
        mouseMove(x, y); // click on oven
        click(j);
        mouseMove(loc[4], loc[5]); // click on chicken
        try {
            threads[j].sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(j);
        mouseMove(x, y); // click on oven
        click(j);
        try {
            threads[j].sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(j == threads.length-1){
            esc();
        }
        try {
            threads[j].sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(j == threads.length-1) {
            System.out.println("cycle: " + j);
            System.out.println("num cooked: " + (j*threads.length));
            for (int i = 0; i < 10; i++) {
                Color color = new Color(40, 89, 100);
                if(robot.getPixelColor(1103, 160).equals(color)){
                    esc();
                }
                try {
                    threads[j].sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                threads[j].sleep(24500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        else {
            try {
                threads[j].sleep(34500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mouseMove(loc[6], loc[7]); // click on tomato
        click(j);
        mouseMove(x, y); // click on oven
        click(j);
        try {
            threads[j].sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(j == threads.length-1){
            esc();
        }
        try {
            threads[j].sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(j == threads.length-1) {
            for (int i = 0; i < 10; i++) {
                Color color = new Color(40, 89, 100);
                if(robot.getPixelColor(1103, 160).equals(color)){
                    esc();
                }
                try {
                    threads[j].sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                threads[j].sleep(17900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        else {
            try {
                threads[j].sleep(27900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mouseMove(loc[8], loc[9]); // click on fist
        click(j);
        mouseMove(x, y); // click on oven
        click(j);
        mouseMove(loc[0], loc[1]); // click on something else so it wont become a wrench
        click(j);


    }

    public void esc(){
        robot.keyPress(KeyEvent.VK_ESCAPE);
        try {
            threads[threads.length-1].sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.keyRelease(KeyEvent.VK_ESCAPE);

    }

    public void click(int j){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        try {
            threads[j].sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    
    public void mouseMove(int x, int y){
        robot.mouseMove(0, 0);
        robot.mouseMove(x, y);
    }


}
