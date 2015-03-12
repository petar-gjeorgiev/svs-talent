package WorkingWithObjects;

public class BoxVolumeMain {

	public static void main(String[] args) {

		BoxVolume bv1 = new BoxVolume();

		BoxVolume bv2 = new BoxVolume();

		bv1.setDepth(10);
		bv1.setHeight(170);
		bv1.setWeight(90);

		bv2.setDepth(15);
		bv2.setHeight(150);
		bv2.setWeight(57);

		System.out
				.println((bv1.calculateVolume() > bv2.calculateVolume()) ? bv1
						: bv2);

	}

}
