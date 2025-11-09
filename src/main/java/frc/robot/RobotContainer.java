// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import dev.doglog.DogLog;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.ExampleSubsystem;

public class RobotContainer {
    private ExampleSubsystem subsystem = new ExampleSubsystem();
    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {}
    //call all subsystem tuneMotors methods through RobotContainer
    public void tuneMotors(){
        subsystem.tuneMotors();
    }
}
