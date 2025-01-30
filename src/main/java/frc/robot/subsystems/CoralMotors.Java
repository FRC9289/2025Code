package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class CoralMotors extends SubsystemBase {
    // Constants
    private static final int MOTOR_CAN_ID = 13;
    private static final int MOTOR_CURRENT_LIMIT = 40;
    
    // Motor
    private final CANSparkMax coralMotor = new CANSparkMax(MOTOR_CAN_ID, MotorType.kBrushed);
    
    // Constructor
    public CoralMotors() {
        coralMotor.restoreFactoryDefaults();
        coralMotor.setSmartCurrentLimit(MOTOR_CURRENT_LIMIT);
        coralMotor.burnFlash();
    }
    
    // Run the motor at a specified speed
    public void run(double speed) {
        coralMotor.set(speed);
        SmartDashboard.putNumber("Coral Motor Speed", coralMotor.get());
    }
    
    // Stop the motor
    public void stop() {
        coralMotor.set(0);
    }
    
    // Periodic method for debugging and updates
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Coral Motor Speed", coralMotor.get());
    }
}
