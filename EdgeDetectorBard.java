import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class EdgeDetectorBard {

    public static void main(String[] args) throws IOException {
        // Load the image
        BufferedImage image = ImageIO.read(new File("image.jpg"));

        // Create the Sobel edge detection filters
        int[][] sobelX = new int[][]{{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
        int[][] sobelY = new int[][]{{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};

        // Create the output image
        BufferedImage edgeImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        // Apply the Sobel edge detection filters
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int magnitudeX = 0;
                int magnitudeY = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int intensity = (int) image.getRGB(x + i, y + j);
                        magnitudeX += sobelX[i][j] * intensity;
                        magnitudeY += sobelY[i][j] * intensity;
                    }
                }

                // Calculate the magnitude of the edge
                int magnitude = (int)Math.sqrt(magnitudeX * magnitudeX + magnitudeY * magnitudeY);

                // Set the pixel value in the output image
                edgeImage.setRGB(x, y, magnitude > 255 ? 255 : magnitude);
            }
        }

        // Save the output image
        ImageIO.write(edgeImage, "jpg", new File("edge-image.jpg"));
    }
}
