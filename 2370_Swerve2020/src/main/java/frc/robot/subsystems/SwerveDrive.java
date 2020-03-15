/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class SwerveDrive extends SubsystemBase {
  /**
   * Creates a new SwerveDrive.
   */
  public SwerveDrive() {
    resetEncoders();
  }
  private static WPI_TalonSRX FrontLeftSteer = new WPI_TalonSRX(60);

  private static WPI_TalonSRX FrontLeftDrive = new WPI_TalonSRX(12);


  public static double getAngle(){
    double raw = FrontLeftSteer.getSensorCollection().getQuadraturePosition();
    return raw * 360/4096;
  }

  public static void moveSwerve(double angle, double speed){
    FrontLeftSteer.set(ControlMode.PercentOutput, angle);
    FrontLeftDrive.set(ControlMode.PercentOutput, speed);
  }

  public static void resetEncoders(){
    FrontLeftSteer.getSensorCollection().setQuadraturePosition(0, 0);
  }

  @Override
  public void periodic() {
    if(RobotContainer.A.get()){
      resetEncoders();
    }
    SmartDashboard.putNumber("MotorAngle", getAngle());
    SmartDashboard.putNumber("JoystickAngle", RobotContainer.getAngle());
    // This method will be called once per scheduler run
  }
}
