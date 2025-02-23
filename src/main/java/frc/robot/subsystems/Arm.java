package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    //Defines attribute Speed Limit
    private final int speedLimit=20;

    //Define Motor Constructor
    private CANSparkMax arm1 = new CANSparkMax(16, MotorType.kBrushed);
    private CANSparkMax arm2 = new CANSparkMax(17, MotorType.kBrushed);

    public Arm() {
        //Restore Motor Defaults
        arm1.restoreFactoryDefaults();
        arm2.restoreFactoryDefaults();

        //Set Speed Limit
        arm1.setSmartCurrentLimit(speedLimit);
        arm2.setSmartCurrentLimit(speedLimit);

        //Store to motor controller
        arm1.burnFlash();
        arm2.burnFlash();
    }
    public void move(double speed){
        arm1.set(speed);
        arm2.set(-1 * speed);
        SmartDashboard.putNumber("Arm Motor 1", arm1.get());
        SmartDashboard.putNumber("Arm Motor 2", arm2.get());
    }
    public void stop(){
        //Stops Motor
        arm1.set(0);
        arm2.set(0);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Arm Motor 2", arm1.get());
        SmartDashboard.putNumber("Arm Motor 2", arm2.get());
    }
}
//Written by Wolfram121