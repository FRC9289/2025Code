package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.CommandConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class CoralMotors extends SubsystemBase {

    private final int moterCanID13 = 13;
    private final int speed = 40;
    private CANSparkMax coralMotor13 = new CANSparkMax(moterCanID13, MotorType.kBrushed);

    CoralMotors() {
        coralMotor13.restoreFactoryDefaults();
        coralMotor13.setSmartCurrentLimit(speed);
        coralMotor13.burnFlash();
    }

    public void run(double speed) {
        coralMotor13.set((speed * -1));
        SmartDashboard.putNumber("Coral Motor 13", coralMotor13.get());
    }

    public void stop() {
        coralMotor13.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Coral Motor 13", coralMotor13.get());
    }
}
