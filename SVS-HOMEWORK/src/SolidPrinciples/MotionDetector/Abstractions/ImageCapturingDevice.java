package SolidPrinciples.MotionDetector.Abstractions;

public interface ImageCapturingDevice {

	void captureImage(byte[] image);

	byte[] getImage();

}
