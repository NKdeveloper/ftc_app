package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by harry on 10/23/15.
 */
import com.qualcomm.robotcore.hardware.Gamepad;


import java.lang.Runnable;

public class MainUpdate implements Runnable
{
    public static String title = "";

    private Thread thread;
    private boolean running = false;
    private static Gamepad gamepad1 = new Gamepad();
    private static Gamepad gamepad2 = new Gamepad();

    //booleans for controlling robot : face buttons
    public static boolean a1 = gamepad1.a;
    public static boolean a2 = gamepad2.a;
    public static boolean b1 = gamepad1.b;
    public static boolean b2 = gamepad2.b;
    public static boolean x1 = gamepad1.x;
    public static boolean x2 = gamepad2.x;
    public static boolean y1 = gamepad1.y;
    public static boolean y2 = gamepad2.y;

    //booleans for controlling robot : d-pad
    public static boolean dUp1 = gamepad1.dpad_up;
    public static boolean dUp2 = gamepad2.dpad_up;
    public static boolean dDown1 = gamepad1.dpad_down;
    public static boolean dDown2 = gamepad2.dpad_down;
    public static boolean dRight1 = gamepad1.dpad_right;
    public static boolean dRight2 = gamepad2.dpad_right;
    public static boolean dLeft1 = gamepad1.dpad_left;
    public static boolean dLeft2 = gamepad2.dpad_left;

    //analog y values for controller stick
    public static float yPadLeft1 = gamepad1.left_stick_y;
    public static float yPadRight1 = gamepad1.right_stick_y;
    public static float yPadLeft2 = gamepad2.left_stick_y;
    public static float yPadRight2 = gamepad2.right_stick_y;

    public synchronized void start()
    {
        gamepad1.setJoystickDeadzone(15);
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop()
    {
        running = false;
        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        double ns = 1000000000.0 / 60.0;
        double delta = 0;

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();

        while (running)
        {
            long now = System.nanoTime();

            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1)
            {
                delta--;
            }

            control();

            if(System.currentTimeMillis() - timer >= 1000)
            {
                timer += 1000;
            }
            try
            {
                Thread.sleep(15);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        stop();
    }

    //Describes the steps we take to control the robot
    public void control()
    {
            //booleans for controlling robot : face buttons
            a1 = gamepad1.a;
            a2 = gamepad2.a;
            b1 = gamepad1.b;
            b2 = gamepad2.b;
            x1 = gamepad1.x;
            x2 = gamepad2.x;
            y1 = gamepad1.y;
            y2 = gamepad2.y;

            //booleans for controlling robot : d-pad
            dUp1 = gamepad1.dpad_up;
            dUp2 = gamepad2.dpad_up;
            dDown1 = gamepad1.dpad_down;
            dDown2 = gamepad2.dpad_down;
            dRight1 = gamepad1.dpad_right;
            dRight2 = gamepad2.dpad_right;
            dLeft1 = gamepad1.dpad_left;
            dLeft2 = gamepad2.dpad_left;

            //analog y values for controller stick
            yPadLeft1 = gamepad1.left_stick_y;
            yPadRight1 = gamepad1.right_stick_y;
            yPadLeft2 = gamepad2.left_stick_y;
            yPadRight2 = gamepad2.right_stick_y;
    }
}

