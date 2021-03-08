package factoryPattern;

public class ShapeFactory {

	public Shape GetShape(String ShapeType) {
		if (ShapeType == null) {
			return null;
		}
		if (ShapeType.equalsIgnoreCase("circle")) {
			return new Circle();
		} else if (ShapeType.equalsIgnoreCase("triangle")) {

			return new Triangle();
		}

		return null;

	}

}
