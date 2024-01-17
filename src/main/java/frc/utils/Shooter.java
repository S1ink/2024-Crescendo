package frc.utils;

public class Shooter {
	// insert particle physics

	/**
	 * Takes the current position from VISION, aims the output device towards speaker, and fires it.
	 */
	double xPos;
	double yPos;

	double speakerXPos;
	double speakerYPos;

	public Shooter(double xPos, double yPos) {
		// get from vision
		this.xPos = xPos;
		this.yPos = yPos;

		// calculate speaker position, take into account which side you're on
		this.speakerXPos = 0;
		this.speakerYPos = 0;
	}

	// move towards target
	public static void aimZAxis() {
		// aim body
	}

	// aim (update theta)
	public static void aimXAxis() {
		// aim shooter
	}

	public static void shoot() {
		// robot.shooter.shoot();
	}
}

// user presses shoot trigger
// locks controls for 3s | command finished | cancel button
// do the thing
// unlock controls