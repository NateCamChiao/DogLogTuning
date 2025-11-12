// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import dev.doglog.DogLog;
import frc.robot.subsystems.ExampleSubsystem;

public class RobotContainer {
    private ExampleSubsystem subsystem = new ExampleSubsystem();
    public RobotContainer() {
        configureBindings();
        DogLog.setEnabled(false);
        //this requires all tuning to be done in test mode
        MotorTuner.requireTestMode();
    }

    private void configureBindings() {}
    //call all subsystem tuneMotors methods through RobotContainer
    public void tuneMotors(){
        subsystem.tuneMotors();
    }
}
