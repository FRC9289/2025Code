package frc.robot.commands;

import frc.robot.subsystems.Roller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;

public class RollerCommandMethod extends Command {
    private final Roller roller;
    private final Joystick _controller;

    public RollerCommandMethod(Roller roller, Joystick _controller) {
        this.roller = roller;
        this._controller = _controller;
        addRequirements(roller);
    }

    @Override
    public void initialize() {
        if (_controller.getRawButton(CommandConstants.ButtonA)) {
            this.roller.intakeIn();
        }
        else if(_controller.getRawButton(CommandConstants.ButtonB)) {
            this.roller.stop();
        }
    }
}

/*
 * Created by Aditya-2204
 */