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
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SwerveDrive;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TurnSwerve extends PIDCommand {
  /**
   * Creates a new TurnSwerve.
   */
  public TurnSwerve(SwerveDrive s) {
    super(
        // The controller that the command will use
        new PIDController(0.0005, 0, 0),
        // This should return the measurement
        () -> SwerveDrive.getAngle(),
        // This should return the setpoint (can also be a constant)
        () -> RobotContainer.getAngle(),
        // This uses the output
        output -> {SwerveDrive.moveSwerve(output !=0? output > 0 ? output+0.0325 : output - 0.0325 : 0);
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
    SmartDashboard.putNumber("error", getController().getPositionError());
    super.execute();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
