package frc.robot.SubsystemCommands;

import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class ArmCommands extends Command {
    Arm arm;
    double power;
    boolean up;
    Timer timer = new Timer();
    double time = 2;

    public ArmCommands(double speed, Arm arm) {
        this.arm = arm;
        this.power = speed;
        this.up = false;
    }

    public void up() {
        if (!up) {
            timer.reset();
            while (timer.get() < time) {
                arm.move(this.power);
            }
        }
    }
    public void down() {
        if (up) {
            timer.reset();
            while (timer.get() < time) {
                arm.move(-1 * this.power);
            }
        }
    }
    
}
// Written by Wolfram121