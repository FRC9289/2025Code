package frc.robot.AutonCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.SubsystemCommands.ArmCommands;
import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.Command;

public class ArmAuton extends Command {
    private final ArmCommands armCommands;
    private final Timer timer;
    private final double t_total = 3.25; // Change this value to the desired time
    Arm arm;
    double speed;
    ArmCommands command;

    public ArmAuton(Arm arm, double speed) {
        this.arm = arm;
        this.speed = speed;
        armCommands = new ArmCommands(speed, arm);
        timer = new Timer();
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        armCommands.up();
    }

    @Override
    public void end(boolean interrupted) {
        armCommands.stop();
        timer.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= t_total;
    }
}