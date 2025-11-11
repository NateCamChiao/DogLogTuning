package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.MotorTuner;

public class ExampleSubsystem extends SubsystemBase{
    private TalonFX intakeMotor = new TalonFX(1);
    private TalonFX armMotor = new TalonFX(1);
    private SparkMax sparkMaxMotor = new SparkMax(0, MotorType.kBrushless);
    private ProfiledPIDController profiledPIDController = new ProfiledPIDController(0, 0, 0, null);
    private PIDController nativePIDController = new PIDController(0, 0, 0);
    public ExampleSubsystem(){

    }
    //Method in subsystem to 
    public void tuneMotors(){
        //talonFX examples
        MotorTuner.TalonMotor.tunablePID("Intake motor", intakeMotor, new Slot0Configs());
        MotorTuner.TalonMotor.tunablePIDFeedforward("Intake Arm Motor", armMotor, new Slot0Configs());
        //SparkMax example
        MotorTuner.SparkMotor.tunablePIDF("Spark Max motor", sparkMaxMotor);
        //Native controller examples
        MotorTuner.NativeController.tunablePID("Native PID", nativePIDController);
        MotorTuner.NativeController.tunablePID("Native ProfiledPID", profiledPIDController);
    }
}
