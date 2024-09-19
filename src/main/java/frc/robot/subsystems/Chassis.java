// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Chassis extends SubsystemBase {
  /** Creates a new Chassis. */

private CANSparkMax _frontLeft = new CANSparkMax(1, MotorType.kBrushed);
private CANSparkMax _backLeft = new CANSparkMax(2, MotorType.kBrushed);
private CANSparkMax _frontRight = new CANSparkMax(3, MotorType.kBrushed);
private CANSparkMax _backRight = new CANSparkMax(4, MotorType.kBrushed);


//F -> Front, B -> Back, R -> Right, L -> Left, D -> Drive, T -> Turn
private CANSparkMax FLDMotor = new CANSparkMax(1, MotorType.kBrushed); // FIELD
private CANSparkMax FLTMotor = new CANSparkMax(2, MotorType.kBrushed); // FILLET
private CANSparkMax FRDMotor = new CANSparkMax(3, MotorType.kBrushed); // FORD
private CANSparkMax FRTMotor = new CANSparkMax(4, MotorType.kBrushed); // FART
private CANSparkMax BLDMotor = new CANSparkMax(5, MotorType.kBrushed); // BLEED
private CANSparkMax BLTMotor = new CANSparkMax(6, MotorType.kBrushed); // SANDWHICH
private CANSparkMax BRDMotor = new CANSparkMax(7, MotorType.kBrushed); // BREAD
private CANSparkMax BRTMotor = new CANSparkMax(8, MotorType.kBrushed); // brat

private static final Chassis _chassis = new Chassis();

private DifferentialDrive _drive = new DifferentialDrive(_frontRight, _frontLeft);


  public Chassis() 
  {
    _backLeft.follow(_frontLeft);
    _backRight.follow(_frontRight);

    // for motor correction
    _frontLeft.setInverted(true);
    _frontRight.setInverted(true);
    _backLeft.setInverted(true);
    _backRight.setInverted(true);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Front Left Speed", _frontLeft.get());
    SmartDashboard.putNumber("Front Right Speed", _frontRight.get());
    SmartDashboard.putNumber("Back Left Speed", _backLeft.get());
    SmartDashboard.putNumber("Back Right Speed", _backRight.get());

    _drive.feed();
  }
  public void teleoPeriodic() {
  
  }

  //turn is for turn robot left/right (little movement)
  //direction positive -> forward, negative -> backward
  public void Drive(double turnMovement, double linearMovement)
  {
    //actual movement
    _drive.arcadeDrive(turnMovement*1, linearMovement * 1);

    _drive.feed();
    
    

    
  }

  public void TeleOpDrive(Joystick controller)
  {
    double axis1 = controller.getRawAxis(1);
    double axis4 = controller.getRawAxis(4);


    
    SmartDashboard.putNumber("axis 0", axis1);
    SmartDashboard.putNumber("axis 5", axis4);
    Drive(axis4, -axis1);
  }

  public void autoDrive(double turnMovement, double linearMovement)
  {
    //_drive.arcadeDrive(turn, direction);
    _drive.arcadeDrive(turnMovement, linearMovement);
    _drive.feed();
  }
  
  public static Chassis returnInstance()
  {
    return _chassis;
  }

}