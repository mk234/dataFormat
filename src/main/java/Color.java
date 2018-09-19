import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Color extends Node {
    private double r;
    private double g;
    private double b;
String name ;
    public Color() {
    }

    public Color(String name, double r, double g, double b) {
        this.name = name;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public String toString() {
        return "\n" + "Color" + "\n" +
                "- R :" + r + "\n" +
                "- G :" + g + "\n" +
                "- B :" + b + "\n";
    }

    @Override
    public void save(DataOutputStream dataOutputStream) throws IOException {
        super.save(dataOutputStream);
        dataOutputStream.writeUTF(name);
        dataOutputStream.writeDouble(r);
        dataOutputStream.writeDouble(g);
        dataOutputStream.writeDouble(b);
    }

    @Override
    public void load(DataInputStream dataInputStream) throws IOException {
        super.load(dataInputStream);
       name = dataInputStream.readUTF();
        r = dataInputStream.readDouble();
        g = dataInputStream.readDouble();
        b = dataInputStream.readDouble();
    }
}
