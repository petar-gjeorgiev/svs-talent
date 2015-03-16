package MotionDetector;

import java.util.List;
import java.util.Scanner;

public interface ImageCapturingDevice {

	List<byte[]> getImage(Scanner scannner);

	List<byte[]> getAllImages();
}
