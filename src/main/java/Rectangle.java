import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Rectangle extends Node {
    private double posX;
    private double posY;
    private double width;
    private double height;
    private Color color;
    String name;

    public Rectangle(String name, double posX, double posY, double width, double height, Color color) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Rectangle" + "\n" +
                "posX=" + posX + "\n" +
                "posY=" + posY + "\n" +
                "width=" + width + "\n" +
                "height=" + height + "\n" +
                "color=" + color;
    }

    public Rectangle() {
    }

    @Override
    public void save(DataOutputStream dataOutputStream) throws IOException {
        super.save(dataOutputStream);
        dataOutputStream.writeDouble(posX);
        dataOutputStream.writeDouble(posY);
        dataOutputStream.writeDouble(width);
        dataOutputStream.writeDouble(height);
        color.save(dataOutputStream);
    }

    @Override
    public void load(DataInputStream dataInputStream) throws IOException {
        super.load(dataInputStream);
        posX = dataInputStream.readDouble();
        posY = dataInputStream.readDouble();
        width = dataInputStream.readDouble();
        height = dataInputStream.readDouble();
        color = new Color();
        color.load(dataInputStream);
    }
}
