package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private static final double INTAKE_SPEED = 0.75;
    
    private final CANSparkMax intakeMotor = new CANSparkMax(18, MotorType.kBrushless); // 

    public Intake() {
        intakeMotor.restoreFactoryDefaults();
        intakeMotor.setSmartCurrentLimit(30);
        intakeMotor.burnFlash();
    }

    public void intakeIn() {
        intakeMotor.set(INTAKE_SPEED);
    }

    public void intakeOut() {
        intakeMotor.set(-INTAKE_SPEED);
    }

    public void stop() {
        intakeMotor.set(0);
    }
}
