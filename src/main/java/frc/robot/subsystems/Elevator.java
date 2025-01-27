package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.CommandConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import com.revrobotics.CANSparkMax;

public class Elevator extends SubsystemBase {

    private final int speed = 40; //Speed lim
    //Declare motors (Someonne pls change to real)
    private final int moterCanID14 = 14;
    private CANSparkMax elevatorMotor14 = new CANSparkMax(moterCanID14, MotorType.kBrushed);
    
    private final int moterCanID15 = 15;
    private CANSparkMax elevatorMotor15 = new CANSparkMax(moterCanID15, MotorType.kBrushed);

    Elevator() {
        elevatorMotor14.restoreFactoryDefaults();
        elevatorMotor14.setSmartCurrentLimit(speed);
        elevatorMotor14.burnFlash();

        elevatorMotor15.restoreFactoryDefaults();
        elevatorMotor15.setSmartCurrentLimit(speed);
        elevatorMotor15.burnFlash();
    }

    public void run(double speed) {
        elevatorMotor14.set(speed);
        SmartDashboard.putNumber("Elevator Motor 14", elevatorMotor14.get());
        elevatorMotor15.set(speed);
        SmartDashboard.putNumber("Elevator Motor 15", elevatorMotor15.get());
    }

    public void stop() {
        elevatorMotor14.set(0);
        elevatorMotor15.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Elevator Motor 14", elevatorMotor14.get());
        SmartDashboard.putNumber("Elevator Motor 15", elevatorMotor15.get());
    }
}
