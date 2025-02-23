package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakeCommand extends Command {
    private final Intake intake;
    private final boolean isIntaking;

    public IntakeCommand(Intake intake, boolean isIntaking) {
        this.intake = intake;
        this.isIntaking = isIntaking;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        if (isIntaking) {
            intake.intakeIn();
        } else {
            intake.intakeOut();
        }
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
    }
}

/*
 * Created by Aditya-2204
 */