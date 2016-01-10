package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.EventLoopManager;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.exception.RobotCoreException;
import com.qualcomm.robotcore.hardware.usb.RobotUsbDevice;
import com.qualcomm.robotcore.robocol.RobocolDatagramSocket;
import com.qualcomm.robotcore.util.*;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;
import java.text.SimpleDateFormat;
import com.qualcomm.ftcrobotcontroller.*;
import com.qualcomm.hardware.HiTechnicNxtDcMotorController;
import com.qualcomm.hardware.ModernRoboticsUsbLegacyModule;
import java.util.Date;

/**
 * TeleOp Mode
 * <p>
 *Enables control of the robot via the gamepad
 */
public class DriverControl extends OpMode
{

  private String startDate;
  private ElapsedTime runtime = new ElapsedTime();
  MainUpdate inputVars = new MainUpdate();

  DcMotor motorRightF;
  DcMotor motorRightB;
  DcMotor motorLeftF;
  DcMotor motorLeftB;



  @Override
  public void init()
  {
    inputVars.start();

    motorRightF = hardwareMap.dcMotor.get("motor_RF");
    motorRightB = hardwareMap.dcMotor.get("motor_RB");
    motorLeftF = hardwareMap.dcMotor.get("motor_LF");
    motorLeftB = hardwareMap.dcMotor.get("motor_LB");
  }

  /*
     * Code to run when the op mode is first enabled goes here
     * @see com.qualcomm.robotcore.eventloop.opmode.OpSMode#start()
     */
  @Override
  public void init_loop()
  {
    startDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    runtime.reset();
    telemetry.addData("Null Op Init Loop", runtime.toString());
  }

  /*
   * This method will be called repeatedly in a loop
   * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
   */
  @Override
  public void loop()
  {
    telemetry.addData("1 Start", "NullOp started at " + startDate);
    telemetry.addData("2 Status", "running for " + runtime.toString());
    motorRightF.setPower(inputVars.yPadRight1);
    motorRightB.setPower(inputVars.yPadRight1);
    motorLeftF.setPower(inputVars.yPadLeft1);
    motorLeftB.setPower(inputVars.yPadLeft1);
  }
}
