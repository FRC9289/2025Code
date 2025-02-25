package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    private final int speedLimit = 20;

    // Provide all required parameters
    private CANSparkMax arm1 = new CANSparkMax(9,MotorType.kBrushless);

    public Arm() {
        arm1.restoreFactoryDefaults();

        arm1.setSmartCurrentLimit(speedLimit);

        arm1.burnFlash();
    }

    public void move(double speed) {
        arm1.set(speed);
        SmartDashboard.putNumber("Arm Motor 1", arm1.get());
    }

    public void stop() {
        arm1.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Arm Motor 1", arm1.get());
    }
}

//Wolfram