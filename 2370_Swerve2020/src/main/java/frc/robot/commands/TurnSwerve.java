/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SwerveDrive;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TurnSwerve extends PIDCommand {
  /**
   * Creates a new TurnSwerve.
   */
  private static double inverted = 0;
  private static double speedInvert = 1;
  public TurnSwerve(SwerveDrive s) {
    super(
        // The controller that the command will use
        new PIDController(0.0007, 0, 0),
        // This should return the measurement
        () -> SwerveDrive.getAngle() - inverted,
        // This should return the setpoint (can also be a constant)
        () -> RobotContainer.getAngle(),
        // This uses the output
        output -> {SwerveDrive.moveSwerve(output !=0? output > 0 ? output+0.035 : output - 0.035 : 0, RobotContainer.getDistance() * speedInvert);
        SmartDashboard.putNumber("output", output);
          // Use the output here
        });
        addRequirements(s);
        getController().enableContinuousInput(-180, 180);
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

  @Override
  public void execute() {
    RobotContainer.setPreviousAngle();
    SmartDashboard.putNumber("setpoint", getController().getSetpoint());
    SmartDashboard.putNumber("error", getController().getPositionError());
    SmartDashboard.putNumber("inverted", inverted);
    SmartDashboard.putNumber("Speed", RobotContainer.getDistance() * speedInvert);
    if(Math.abs(getController().getPositionError()) > 91){
      if(inverted == 0){
        inverted = 180;
        speedInvert = -1;
      } else{
        inverted = 0;
        speedInvert = 1;
      }
    }
    super.execute();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
