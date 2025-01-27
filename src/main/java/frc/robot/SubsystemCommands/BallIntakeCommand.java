package frc.robot.SubsystemCommands;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkLowLevel.MotorType;

public class BallIntakeCommand extends SubsystemBase{
    private final int motorCanId1 = 0;
    private final int motorCanId2 = 1;
    //max speed ig? 
    private final int speedLimit = 30;

    //class initialization for the two intake motors
    private CANSparkMax intakeMotor1 = new CANSparkMax(motorCanId1, MotorType.kBrushless);
    private CANSparkMax intakeMotor2 = new CANSparkMax(motorCanId2, MotorType.kBrushless);
    //eli said that were arent using brushed motors. Might need a fact check on this
    public BallIntakeCommand()
    {
        // reset setting on initialization
        intakeMotor1.restoreFactoryDefaults();
        intakeMotor2.restoreFactoryDefaults();

        //set speed limit on initialization
        intakeMotor1.setSmartCurrentLimit(speedLimit);
        intakeMotor2.setSmartCurrentLimit(speedLimit);

        

        //saves setting in the encoders
        intakeMotor1.burnFlash();
        intakeMotor2.burnFlash();
        
    }
    //turns motor / makes it work
    public void move(double speed)
    {
        //for direction of movement
        //because motors are inverted speed should be opposite of eachother
        intakeMotor1.set(speed);
        intakeMotor2.set(-speed);
        //outputs the motor power on the dashboard

        SmartDashboard.putNumber("Motor 1 power", intakeMotor1.get());
        SmartDashboard.putNumber("Motor 2 power", intakeMotor2.get());
    }

    public void stop()
    {
        intakeMotor1.set(0);
        intakeMotor2.set(0);
    }
    //function run every 20ms to display motor output 
    //Note: the old hanger class inherited from something idk what that is 
    public void periodic() {
        SmartDashboard.putNumber("hang motor 11", intakeMotor1.get());
        SmartDashboard.putNumber("hang motor 12", intakeMotor2.get());
    }




    
}
