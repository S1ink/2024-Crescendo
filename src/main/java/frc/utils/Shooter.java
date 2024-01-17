package frc.utils;

public class Shooter {
	// insert particle physics

	double[] robotPosition = new double[2];
	double[] speakerPosition = new double[2];

	/**
	 * Takes the current position from VISION™, aims the output device towards speaker, and fires it.
	 * @param xPos X position of robot, provided by VISION™
	 * @param yPos Y position of robot, provided by VISiON™
	 */
	public Shooter(double xPos, double yPos) {
		// get from vision
		this.robotPosition[0] = xPos;
		this.robotPosition[1] = yPos;

		// calculate speaker position, take into account which side you're on
		this.speakerPosition =  calculateSpeakerPosition(xPos, yPos);
	}

	public static double[] calculateSpeakerPosition(double xPos, double yPos) {
		double[] speakerPosition = new double[2];
		// TODO: calculate
		return speakerPosition;
	}

	// move towards target
	public static void aimZAxis() {
		// TODO: aim body
	}

	// aim (update theta)
	public static void aimXAxis() {
		// TODO: aim shooter
	}

	public static void shoot() {
		// TODO: robot.shooter.shoot();
	}
}

// user presses shoot trigger
// locks controls for 3s | command finished | cancel button
// do the thing
// unlock controls