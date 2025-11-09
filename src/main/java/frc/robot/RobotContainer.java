// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import dev.doglog.DogLog;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Intake;

public class RobotContainer {
    private Intake intake = new Intake();
    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {}

    public void tuneMotors(){
        intake.tuneMotors();
    }
}
