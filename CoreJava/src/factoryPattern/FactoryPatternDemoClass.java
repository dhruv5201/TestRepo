package factoryPattern;

public class FactoryPatternDemoClass {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape circle = shapeFactory.GetShape("Circle");
		circle.draw();
		Shape triangle = shapeFactory.GetShape("Triangle");
		triangle.draw();
		

	}

}
