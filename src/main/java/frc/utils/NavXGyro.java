package frc.utils;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;

/**
 * Overrides the NavX gyro class {@code AHRS}, but allows us to reset the gyro
 * to different angles.
 */
public class NavXGyro extends AHRS {

    private double offset = 0.0;

    public NavXGyro(SPI.Port spi_port) {
        super(spi_port);
    }

    /**
     * Returns the total accumulated yaw angle (Z Axis, in degrees)
     * reported by the sensor.
     * 
     * @return angle in degrees.
     */
    @Override
    public double getAngle() {
        return super.getAngle() + offset;
    }

    /**
     * Reset the gyro, indicating that the robot is currently pointing in the zero
     * direction.
     */
    @Override
    public void reset() {
        this.reset(0.0);
    }

    /**
     * Reset the gyro, indicating that the robot is currently pointing to the
     * specified angle.
     * 
     * @param angle current yaw in degrees.
     */
    public void reset(double angle) {
        super.reset();
        this.offset = angle;
    }
}
