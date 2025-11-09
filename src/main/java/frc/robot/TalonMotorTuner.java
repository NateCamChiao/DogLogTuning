package frc.robot;

import java.util.function.BooleanSupplier;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;

import dev.doglog.DogLog;
import edu.wpi.first.wpilibj.DriverStation;

public class TalonMotorTuner extends DogLog{
    /*
     * Use a boolean supplier to check if in test mode
     * otherwise don't allow tuning
     */
    //this returns true if in test mode
    private static BooleanSupplier isTestMode = () -> DriverStation.isTest();
    /*
     * Publishes values for tuning PID via DogLog
     */
    public static void tunablePID(String motorName, TalonFX motor, Slot0Configs defaultConfigs){
        if(isTestMode.getAsBoolean()){
            TalonFXConfigurator motorConfigurator = motor.getConfigurator();
            DogLog.tunable(motorName + "kP", defaultConfigs.kP, updatedValue -> {
                motorConfigurator.apply(defaultConfigs.withKP(updatedValue));
            });
            DogLog.tunable(motorName + "kI", defaultConfigs.kI, updatedValue -> {
                motorConfigurator.apply(defaultConfigs.withKI(updatedValue));
            });
            DogLog.tunable(motorName + "kD", defaultConfigs.kD, updatedValue -> {
                motorConfigurator.apply(defaultConfigs.withKD(updatedValue));
            });
        }
        
    }
    /*
     * Publishes values for tuning PID and Feedforward using DogLog
     */
    public static void tunablePIDFeedforward(String motorName, TalonFX motor, Slot0Configs defaultConfigs){
        if(isTestMode.getAsBoolean()){
            TalonMotorTuner.tunablePID(motorName, motor, defaultConfigs);

            TalonFXConfigurator motorConfigurator = motor.getConfigurator();
            DogLog.tunable(motorName + "kG", defaultConfigs.kP, updatedValue -> {
                motorConfigurator.apply(defaultConfigs.withKG(updatedValue));
            });
            DogLog.tunable(motorName + "kS", defaultConfigs.kS, updatedValue -> {
                motorConfigurator.apply(defaultConfigs.withKS(updatedValue));
            });
            DogLog.tunable(motorName + "kV", defaultConfigs.kV, updatedValue -> {
                motorConfigurator.apply(defaultConfigs.withKV(updatedValue));
            });
            DogLog.tunable(motorName + "kA", defaultConfigs.kA, updatedValue -> {
                motorConfigurator.apply(defaultConfigs.withKA(updatedValue));
            });
        }
    }
}
