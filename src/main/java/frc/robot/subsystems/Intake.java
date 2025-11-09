package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.SlotConfigs;
import com.ctre.phoenix6.hardware.TalonFX;

import dev.doglog.DogLog;
import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.TalonMotorTuner;

public class Intake extends SubsystemBase{
    private TalonFX intakeMotor = new TalonFX(1);
    
    public Intake(){

    }

    public void tuneMotors(){
        if(DriverStation.isTest()){
            TalonMotorTuner.tunablePID("Intake motor", intakeMotor, new Slot0Configs());
        }
    }
}
