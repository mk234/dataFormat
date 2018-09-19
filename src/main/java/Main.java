import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

  /*      BinaryFile binaryFile = new BinaryFile();
        binaryFile.createBinaryFile();
        binaryFile.readBinaryFile();
*/


        Page page = new Page("Page1", 210, 297, new Node[]{
                new FlowArea("FlowArea1", 10, 10, 80, 50, new String[]{"Petr Novak", "Jiraskova 213", "Brno", "12345"}),
                new FlowArea("FlowArea2", 120, 10, 80, 50, new String[]{"Moje firma", "Product manager", "Ing. Jana Novotna", "Hradecka 25", "Pardubice", "54332", "Tel: 123456789"}),
                new Rectangle("Rectangle1", 5, 70, 200, 2, new Color("Color", 0, 0, 0)),
                new FlowArea("FlowArea3", 10, 80, 190, 190, new String[]{"Line 1", "Line 2", "Line 3", "Line 4", "Line 5"}),
        });

        DataOutputStream dataOutputStream =
                new DataOutputStream(
                        new FileOutputStream("data.bin"));

         page.save(dataOutputStream);

        dataOutputStream.close();


        DataInputStream dataInputStream =
                new DataInputStream(
                        new FileInputStream("data.bin"));

        page = new Page();
         page.load(dataInputStream);
        System.out.println(page.toString());
        dataInputStream.close();

    }


}
