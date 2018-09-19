import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FlowArea extends Node {
    private double posX;
    private double posY;
    private double width;
    private double height;
    private String[] arrayOfString;
    String name;

    public FlowArea(String name, double posX, double posY, double width, double height, String[] arrayOfString) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.arrayOfString = arrayOfString;
    }

    public FlowArea() {
    }

    @Override
    public String toString() {
        return "FlowArea " + "\n" +
                "posX=" + posX + "\n" +
                "posY=" + posY + "\n" +
                "width=" + width + "\n" +
                "height=" + height + "\n" +
                "arrayOfString=" + Arrays.toString(arrayOfString) + "\n"
                ;
    }

    @Override
    public void save(DataOutputStream dataOutputStream) throws IOException {
        super.save(dataOutputStream);
        dataOutputStream.writeDouble(posX);
        dataOutputStream.writeDouble(posY);
        dataOutputStream.writeDouble(width);
        dataOutputStream.writeDouble(height);
        int size = arrayOfString.length;
        dataOutputStream.writeInt(size);
         for (String s : arrayOfString) {
            dataOutputStream.writeUTF(s);
        }
    }

    @Override
    public void load(DataInputStream dataInputStream) throws IOException {
        super.load(dataInputStream);
        posX = dataInputStream.readDouble();
        posY = dataInputStream.readDouble();
        width = dataInputStream.readDouble();
        height = dataInputStream.readDouble();
        int size = dataInputStream.readInt();
         arrayOfString = new String[size];
        for (int i = 0; i < arrayOfString.length; i++) {
            arrayOfString[i] = dataInputStream.readUTF();
        }
    }
}
