package frc.robot.SubsystemCommands;

import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class ArmCommands extends Command {
    Arm arm;
    double power;
    boolean up;
    Timer timer = new Timer();
    double time = 1;
    boolean running = false;

    public ArmCommands(double speed, Arm arm) {
        this.arm = arm;
        this.power = speed;
        this.up = false;
    }

    public void up() {
        if (!up && !running) {
            timer.reset();
            running = true;
            while (timer.get() < time) {
                arm.move(this.power);
            }
            up = true;
            running = false;
        }
    }
    public void down() {
        if (up && !running) {
            timer.reset();
            running = true;
            while (timer.get() < time) {
                arm.move(-1 * this.power);
            }
            up = false;
            running = false;
        }
    }

    public void execute(boolean dir) {
        if (dir) {
            arm.move(1);
        }
        else if (dir) {
            arm.move(-1);
        }
    }

    public void stop() {
        arm.move(0);
    } 
}
// Written by Wolfram121