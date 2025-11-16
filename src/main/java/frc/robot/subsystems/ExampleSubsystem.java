package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import dev.doglog.DogLog;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.MotorTuner;

public class ExampleSubsystem extends SubsystemBase{
    private TalonFX intakeMotor = new TalonFX(1);
    private TalonFX armMotor = new TalonFX(1);
    private SparkMax sparkMaxMotor = new SparkMax(0, MotorType.kBrushless);
    private ProfiledPIDController profiledPIDController = new ProfiledPIDController(0, 0, 0, new Constraints(0, 0));
    private PIDController nativePIDController = new PIDController(0, 0, 0);
    private SimpleMotorFeedforward motorFeedforward = new SimpleMotorFeedforward(0, 0);
    private ElevatorFeedforward elevatorFeedforward = new ElevatorFeedforward(0, 0, 0);
    private ArmFeedforward armFeedforward = new ArmFeedforward(0, 0, 0);
    
    public ExampleSubsystem(){

    }
    //Method in subsystem to 
    public void tuneMotors(){
        //TalonFX examples
        MotorTuner.TalonMotor.tunablePID("Intake motor", intakeMotor, new Slot0Configs());
        MotorTuner.TalonMotor.tunablePIDFeedforward("Intake Arm Motor", armMotor, new Slot0Configs());
        //SparkMax example
        MotorTuner.SparkMaxMotor.tunablePIDF("Spark Max motor", sparkMaxMotor);
        //Native controller examples
        MotorTuner.NativeController.tunablePID("Native PID", nativePIDController);
        MotorTuner.NativeController.tunablePID("Native ProfiledPID", profiledPIDController);
        //Native Feedforwards
        MotorTuner.NativeController.tunableMotorFeedforward("Native Motor Feedforward", 
            () -> this.motorFeedforward, // Supplies feedforward
            updatedFeedforward -> this.motorFeedforward = updatedFeedforward // Allows modification of variable "motorFeedforward"
        );
        MotorTuner.NativeController.tunableArmFeedforward("Native Arm Feedforward", 
            () -> this.armFeedforward, // Supplies feedforward
            updatedFeedforward -> this.armFeedforward = updatedFeedforward // Allows modification of variable "armFeedforward"
        );
        MotorTuner.NativeController.tunableElevatorFeedforward("Native Elevator Feedforward", 
            () -> this.elevatorFeedforward, // Supplies feedforward
            updatedFeedforward -> this.elevatorFeedforward = updatedFeedforward // Allows modification of variable "elevatorFeedforward"
        );
    }
}
