import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EdgeDetectorChatGPT {
    public static void main(String[] args) throws IOException {
    // Load the image
    BufferedImage image = ImageIO.read(new File("image.jpg"));

    // Create the Sobel edge detection filters
    int[][] sobelX = new int[][]{{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
    int[][] sobelY = new int[][]{{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};

    // Create the output image
    BufferedImage edgeImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

    // Apply the Sobel edge detection filters
    for (int x = 1; x < image.getWidth() - 1; x++) {
        for (int y = 1; y < image.getHeight() - 1; y++) {
            int magnitudeX = 0;
            int magnitudeY = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int rgb = image.getRGB(x + i, y + j);
                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = rgb & 0xFF;
                    int intensity = (int)(0.2989*r + 0.5870*g + 0.1140*b);
                    magnitudeX += sobelX[i+1][j+1] * intensity;
                    magnitudeY += sobelY[i+1][j+1] * intensity;
                }
            }

            // Calculate the magnitude of the edge
            int magnitude = (int)Math.sqrt(magnitudeX * magnitudeX + magnitudeY * magnitudeY);

            // Limit the magnitude to the range 0-255
            magnitude = Math.min(255, Math.max(0, magnitude));

            // Set the pixel value in the output image
            int gray = (magnitude << 16) + (magnitude << 8) + magnitude;
            edgeImage.setRGB(x, y, gray);
        }
    }

    // Save the output image
    ImageIO.write(edgeImage, "jpg", new File("chat-edge-image.jpg"));
}

}
