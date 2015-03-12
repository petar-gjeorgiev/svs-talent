package WorkingWithObjects;

public class BoxVolume {

	public int height;

	public int weight;

	public int depth;

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int calculateVolume() {
		return weight * depth * height;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Height: " + height + " Weight: " + weight + " Depth: "
				+ depth);
		return sb.toString();
	}
}
