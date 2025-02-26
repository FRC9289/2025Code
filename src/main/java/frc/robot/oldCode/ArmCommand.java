package frc.robot.oldCode;

import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;

public class ArmCommand extends Command {
    private final Arm arm;
    private final DoubleSupplier speedSupplier;

    public ArmCommand(Arm arm, DoubleSupplier speedSupplier) {
        this.arm = arm;
        this.speedSupplier = speedSupplier;
        addRequirements(arm);
    }

    @Override
    public void execute() {
        double speed = speedSupplier.getAsDouble();
        arm.move(speed);
    }

    @Override
    public void end(boolean interrupted) {
        arm.stop(); 
    }
}

/*
 * Created by Aditya-2204
 */