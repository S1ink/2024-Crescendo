
package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.util.sendable.SendableBuilder;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FloorIntake extends SubsystemBase {

    private CANSparkMax intakeMotor;
    private DigitalInput sensorBot = new DigitalInput(Constants.IntakeConstants.BOT_DIO_SENSOR);
    private DigitalInput sensorTop = new DigitalInput(Constants.IntakeConstants.TOP_DIO_SENSOR);

    private double m_intakeSpeedTarget = 0.0;

    public FloorIntake() {
        intakeMotor = new CANSparkMax(Constants.IntakeConstants.motorCanID, MotorType.kBrushless);
        intakeMotor.setInverted(false);
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Bot Sensor", getBotSensor());
        SmartDashboard.putBoolean("Top Sensor", getTopSensor());
        SmartDashboard.putNumber("Intake Velocity", intakeMotor.getEncoder().getVelocity());
    }

    @Override
    public void simulationPeriodic() {

    }

    /**
     * Spins the intake, positive is clockwise
     * 
     * @param speed
     */
    public void intake(double speed) {
        m_intakeSpeedTarget = speed;
        intakeMotor.set(speed);
    }

    public double getMotorSpeed() {
        return intakeMotor.get();
    }

    /**
     * Gets the value of the bottom sensir
     * 
     * @return The value of the bottom sensor
     */
    public boolean getBotSensor() {
        return sensorBot.get();
    }

    /**
     * Gets the value of the top sensir
     * 
     * @return The value of the top sensor
     */
    public boolean getTopSensor() {
        return sensorTop.get();
    }


    @Override
    public void initSendable(SendableBuilder b) {
        // motor
        b.addDoubleProperty("Intake Motor/Encoder RPM", ()->this.intakeMotor.getEncoder().getVelocity(), null);
        b.addDoubleProperty("Intake Motor/Current", ()->this.intakeMotor.getOutputCurrent(), null);
        b.addDoubleProperty("Intake Motor/Voltage", ()->this.intakeMotor.getBusVoltage(), null);
        b.addDoubleProperty("Intake Motor/Applied speed", ()->this.intakeMotor.get(), null);
        b.addDoubleProperty("Intake Motor/Temperature", ()->this.intakeMotor.getMotorTemperature(), null);
        // targets/state
        b.addBooleanProperty("Bottom Sensor", ()->this.getBotSensor(), null);
        b.addBooleanProperty("Top Sensor", ()->this.getTopSensor(), null);
        b.addDoubleProperty("Target Speed", ()->m_intakeSpeedTarget, null);
    }


}
