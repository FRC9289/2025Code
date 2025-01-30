package frc.robot.subsystems;
//Aarav is doing all hang!

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hang extends SubsystemBase {
    //Defines Motor ID
    private final int motorCanID13=13;

    //Defines attribute Speed Limit
    private final int speedLimit=20;

    //Define Motor Constructor
    private CANSparkMax hangMotor13=new CANSparkMax(motorCanID13, MotorType.kBrushed);

    public Hang(){
        //Restore Motor Defaults
        hangMotor13.restoreFactoryDefaults();

        //Set Speed Limit
        hangMotor13.setSmartCurrentLimit(speedLimit);

        //Store to motor controller
        hangMotor13.burnFlash();

    }
    public void move(double speed){
        hangMotor13.set(speed);
        SmartDashboard.putNumber("Motor 13 power", hangMotor13.get());
    }
    public void stop(){
        //Stops Motor
        hangMotor13.set(0);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Hang Motor 13", hangMotor13.get());
    }
}
