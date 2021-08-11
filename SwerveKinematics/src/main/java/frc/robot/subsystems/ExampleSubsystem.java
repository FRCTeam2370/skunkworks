/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.SwerveLibrary.SwerveDrive;
import frc.robot.SwerveLibrary.SwerveModule;

public class ExampleSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  public ExampleSubsystem() {
    motorInit(frontLeftDrive);
    motorInit(frontRightDrive);
    motorInit(backLeftDrive);
    motorInit(backRightDrive);
    motorInit(frontLeftSpin);
    motorInit(frontRightSpin);
    motorInit(backLeftSpin);
    motorInit(backRightSpin);
    drive.resetGyro();
  }

  public static WPI_TalonFX frontLeftDrive = new WPI_TalonFX(Constants.Drivefl);
  public static WPI_TalonFX frontRightDrive = new WPI_TalonFX(Constants.Drivefr);
  public static WPI_TalonFX backLeftDrive = new WPI_TalonFX(Constants.Drivebl);
  public static WPI_TalonFX backRightDrive = new WPI_TalonFX(Constants.Drivebr);
  public static WPI_TalonFX frontLeftSpin = new WPI_TalonFX(Constants.Spinfl);
  public static WPI_TalonFX frontRightSpin = new WPI_TalonFX(Constants.Spinfr);
  public static WPI_TalonFX backLeftSpin = new WPI_TalonFX(Constants.Spinbl);
  public static WPI_TalonFX backRightSpin = new WPI_TalonFX(Constants.Spinbr);

  public static AHRS ahrs = new AHRS();

  public static SwerveModule frontLeftModule = new SwerveModule(-1, 1, frontLeftSpin, frontLeftDrive);
  public static SwerveModule frontRightModule = new SwerveModule(1, 1, frontRightSpin, frontRightDrive);
  public static SwerveModule backLeftModule = new SwerveModule(-1, -1, backLeftSpin, backLeftDrive);
  public static SwerveModule backRightModule = new SwerveModule(1, -1, backRightSpin, backRightDrive);
  
  public static SwerveDrive drive = new SwerveDrive(frontLeftModule, frontRightModule, backLeftModule, backRightModule, ahrs,0,0);

  public static void motorInit(WPI_TalonFX motor){
    motor.configFactoryDefault();
    motor.config_kP(0, 0.1);
    motor.config_kI(0, 0);
    motor.config_kD(0, 0);
    motor.config_kF(0, 0);
    motor.configPeakOutputForward(0.5);
    motor.configPeakOutputReverse(-0.5);
    motor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,0,0);
    motor.configAllowableClosedloopError(0, 0, 0);
    motor.configFeedbackNotContinuous(true, 0);
    motor.getSensorCollection().setIntegratedSensorPosition(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
