import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import java.util.HashMap;

public class ImageLoader {

    public static String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "w", "x", "y", "z" };
    public static String[][] lettersMatrix = new String[5][6];

    public static HashMap<String, BufferedImage> LoadImage(String path) throws IOException {

        int rows = 5; // You should decide the values for rows and cols variables
        int cols = 6;

        // Initialize letters first
        HashMap<String, BufferedImage> lettersToImg = new HashMap<String, BufferedImage>();

        int currentRow = 0;
        int currentCol = 0;

        for (int i = 0; i < letters.length; i++) {
            lettersMatrix[currentRow][currentCol] = letters[i];
            currentCol++;
            if (currentCol >= cols) {
                currentCol = 0;
                currentRow++;
            }
        }

        // Then process letters file
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        BufferedImage image = ImageIO.read(fis); // reading the image file

        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height
        int chunkHeight = image.getHeight() / rows;

        BufferedImage subs[][] = new BufferedImage[rows][cols]; // Image array to hold image chunks

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                subs[r][c] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                // draws the image chunk
                Graphics2D gr = subs[r][c].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * c, chunkHeight * r,
                        chunkWidth * c + chunkWidth, chunkHeight * r + chunkHeight, null);
                gr.dispose();

                // Add to hash map
                lettersToImg.put(lettersMatrix[r][c], subs[r][c]);
            }
        }
        System.out.println("Splitting done");

        return lettersToImg;
    }
}