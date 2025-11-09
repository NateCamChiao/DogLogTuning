package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.MotorTuner;

public class ExampleSubsystem extends SubsystemBase{
    private TalonFX intakeMotor = new TalonFX(1);
    private TalonFX armMotor = new TalonFX(1);
    
    public ExampleSubsystem(){
    }

    public void tuneMotors(){
        MotorTuner.Talon.tunablePID("Intake motor", intakeMotor, new Slot0Configs());
        MotorTuner.Talon.tunablePIDFeedforward("Intake Arm Motor", armMotor, new Slot0Configs());
    }
}
