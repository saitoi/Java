public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;
        switch (shapeType.toLowerCase()) {
            case "circle" -> {
                return new Circle();
            }
            case "rectangle" -> {
                return new Rectangle();
            }
            case "square" -> {
                return new Square();
            }
            default -> {
                return null;
            }
        }
    }
}
