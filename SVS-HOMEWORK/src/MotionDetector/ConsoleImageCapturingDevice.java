package MotionDetector;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleImageCapturingDevice implements ImageCapturingDevice {
	
	public List<byte[]> images;
	
	public ConsoleImageCapturingDevice() {
		images = new ArrayList<byte[]> ();
	}
	
	@Override
	public List<byte[]> getImage(Scanner scanner) {
		
		List<byte[]> res = new ArrayList<byte []> ();
		
		while(scanner.hasNext()) {
			String line = scanner.nextLine();
			res.add(line.getBytes()); 
		}
		scanner.close();
		images = res;
		return res;
	}

	public List<byte[]> getImages() {
		return images;
	}

	@Override
	public List<byte[]> getAllImages() {
		return images;
	}

}
