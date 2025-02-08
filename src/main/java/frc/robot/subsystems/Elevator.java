package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Elevator extends SubsystemBase {
  
   //intialize motorCanID
   private final int motorCanID11 = 11;
   private final int motorCanID12 = 12;


   //initialize speed limit
   private final int speedLimit = 20;


   //initialize CANSparkMax
   private CANSparkMax elevatorMotor11 = new CANSparkMax(motorCanID11, MotorType.kBrushed);
   private CANSparkMax elevatorMotor12 = new CANSparkMax(motorCanID12, MotorType.kBrushed);


   public Elevator()
   {
       //reset it every time to reset encoder specifically to initial settings
       elevatorMotor11.restoreFactoryDefaults();
       elevatorMotor12.restoreFactoryDefaults();


       //set speed limit on how fast motors can go
       elevatorMotor11.setSmartCurrentLimit(speedLimit);
       elevatorMotor12.setSmartCurrentLimit(speedLimit);


       //save changes to motor controller/encoder
       elevatorMotor11.burnFlash();
       elevatorMotor12.burnFlash();
   }


   //turns motor
   public void move(double speed)
   {
       //direction of movement
       elevatorMotor11.set(speed);
       elevatorMotor12.set(-speed);


       SmartDashboard.putNumber("Motor 11 power", elevatorMotor11.get());
       SmartDashboard.putNumber("Motor 12 power", elevatorMotor12.get());
   }
   
   //terminates motor movement
   public void stop()
   {
       elevatorMotor11.set(0);
       elevatorMotor12.set(0);
   }


   public void periodic()
   {
       SmartDashboard.putNumber("elevator motor 11", elevatorMotor11.get());
       SmartDashboard.putNumber("elevator motor 12", elevatorMotor12.get());
   }


}



