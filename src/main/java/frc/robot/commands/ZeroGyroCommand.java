// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DriveSubsystem;

/**
 * Resets the gyro so the robot thinks it is currently pointing in the given
 * direction.
 */
public class ZeroGyroCommand extends InstantCommand {

  final DriveSubsystem m_driveTrain;
  final double m_offsetAngle;

  public ZeroGyroCommand(double angle, DriveSubsystem driveSubsystem) {
    this.m_driveTrain = driveSubsystem;
    this.m_offsetAngle = angle;
  }


  @Override
  public void initialize() {
    m_driveTrain.zeroHeading(m_offsetAngle);
  }
}
