package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;

public class ElevatorCommand extends Command {
    //Define motor attributes
    Elevator elevatorMotor;
    double power;

    public ElevatorCommand (Elevator elevatorMotor, double speed)
    {
        this.elevatorMotor = elevatorMotor;
        this.power = speed;
        addRequirements(elevatorMotor);
    }

    @Override
    public void execute ()
    {
        //Move the motor based on power
        elevatorMotor.move(power);
    }
}
