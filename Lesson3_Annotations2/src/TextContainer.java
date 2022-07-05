import java.io.*;

@SaveTo(path = "file.txt")
class TextContainer {
    private static final String TEXT = "Hello, world";

    public TextContainer() {
    }

    public String getText() {
        return TEXT;
    }

    @Saver
    public void save(File file, String text) throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.flush();
        System.out.println("Done!");
    }
}