package frc.robot.oldCode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.CommandConstants;

public class HangDefaultCommand extends Command {
    
    OldHanger _hanger;
    Joystick _joystick;

    public HangDefaultCommand(OldHanger _hanger, Joystick _controller) {
        this._hanger = _hanger;
        _joystick = _controller;
        addRequirements(_hanger);
    }

    @Override
    public void execute()
    {
        if(_joystick.getRawButton(CommandConstants.ButtonY))
        {
            OldHangerCommand _command = new OldHangerCommand(_hanger, -5);
            _command.execute();
        }
        else if(_joystick.getRawButton(CommandConstants.ButtonB))
        {
            OldHangerCommand _command = new OldHangerCommand(_hanger, 5);
            _command.execute();
        }
        else
        {
            OldHangerCommand _command = new OldHangerCommand(_hanger, 0);
            _command.execute();
        }
    }
}
