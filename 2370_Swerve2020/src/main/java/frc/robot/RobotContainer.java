/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TurnSwerve;
import frc.robot.subsystems.SwerveDrive;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private static Joystick stick = new Joystick(0);
  public static JoystickButton A = new JoystickButton(stick, 1);

  public static double getX(){
    if(Math.abs(stick.getRawAxis(0)) < 0.1){
      return 0;
    } else{
      return stick.getRawAxis(0);
    }
  }

  public static double gety(){
    if(Math.abs(stick.getRawAxis(1)) < 0.1){
      return 0;
    } else{
      return stick.getRawAxis(1);
    }
  }

  public static double getDistance(){
    double rawX = Math.abs(stick.getRawAxis(0));
    double rawY = Math.abs(stick.getRawAxis(1));
    return 0.5 * (rawX + rawY);
  }



  public static double getAngle(){
    if(getX() == 0 && gety() == 0){
      return previousAngle;
    }
    double rawX = getX();
    double rawY = gety();
    double rad = Math.atan2(rawX, -rawY);
    double deg = Math.toDegrees(rad);
    return deg;
  }

  private static double previousAngle;

  public static void setPreviousAngle(){
    if(getAngle() != 0){
      previousAngle = getAngle();
    }
  }
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final SwerveDrive m_SwerveDrive = new SwerveDrive();
  //private final Command m_autoCommand;// = new ExampleCommand(m_exampleSubsystem);



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_SwerveDrive.setDefaultCommand(new TurnSwerve(m_SwerveDrive));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
  //  Command ehcnuioa;
  //  return ehcnuioa;
  //}
}
