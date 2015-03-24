package SolidPrinciples.MotionDetector.Implementations;

import SolidPrinciples.MotionDetector.Abstractions.ImageCapturingDevice;

public class ImageAdapter implements ImageCapturingDevice {

	private Image image;
	
	public ImageAdapter(Image image) {
		this.image = image;
	}

	@Override
	public void captureImage(byte[] image) {
		this.image.captureImage(image);
	}

	@Override
	public byte[] getImage() {
		return this.image.getImage();
	}

}
