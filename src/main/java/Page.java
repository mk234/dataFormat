import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Page extends Node {
    private double width;
    private double height;
    private Node[] nodeRef;
String name;

    public Page() {
    }

    public Page(String name, double width, double height, Node[] nodeRef) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.nodeRef = nodeRef;
    }

    @Override
    public String toString() {
        return
                "width=" + width + "\n" +
                        "height=" + height + "\n" +
                        "nodeRef=" + Arrays.toString(nodeRef) + "\n"
                ;
    }


    @Override
    public void save(DataOutputStream dataOutputStream) throws IOException {
        super.save(dataOutputStream);
        dataOutputStream.writeDouble(width);
        dataOutputStream.writeDouble(height);
        dataOutputStream.writeInt(nodeRef.length);

        for (Node node : nodeRef) {
            if (node instanceof FlowArea) {
                dataOutputStream.writeUTF("FlowArea");
            } else if (node instanceof Rectangle) {
                dataOutputStream.writeUTF("Rectangle");
            }
            node.save(dataOutputStream);
        }
    }

    @Override
    public void load(DataInputStream dataInputStream) throws IOException {
        super.load(dataInputStream);
        width = dataInputStream.readDouble();
        height = dataInputStream.readDouble();
        int count = dataInputStream.readInt();
         nodeRef = new Node[count];
        for (int i = 0; i < count; i++) {
            String n = dataInputStream.readUTF();
            Node node = null;
            if ("FlowArea".equals(n)) {
                node = new FlowArea();
            } else if ("Rectangle".equals(n)) {
                node = new Rectangle();
            }
            nodeRef[i] = node;
            node.load(dataInputStream);
        }
    }
}
