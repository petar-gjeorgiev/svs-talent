package SolidPrinciples.MotionDetector.Implementations;

public class Image {
	
	private byte [] image;

	public byte[] getImage() {
		return image;
	}
	
	public void captureImage(byte [] image) {
		this.image = image;
	}
	
}
