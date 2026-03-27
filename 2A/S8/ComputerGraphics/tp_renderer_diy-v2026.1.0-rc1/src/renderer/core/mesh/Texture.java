package renderer.core.mesh;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 2D Texture class.
 */
public class Texture {

    /**
     * The width of the texture.
     */
    private final int width;
    /**
     * The height of the texture.
     */
    private final int height;
    /**
     * The image of the texture.
     */
    private final BufferedImage image;

    /**
     * Constructs a new Texture with the content of the image at @path.
     * @param path the path to the image file
     * @throws IOException if the image file is not found
     */
    public Texture(String path) throws IOException {
        image = ImageIO.read(new File(path));
        width = image.getWidth();
        height = image.getHeight();
    }

    /**
     * Samples the texture at texture coordinates (u,v), using nearest neighbor
     * interpolation.
     * u and v are normalized with respect to each image dimension and may be greater
     * than 1 when the texture is repeated over a face.
     * @param u the u texture coordinate
     * @param v the v texture coordinate
     * @return the color of the texture at (u,v)
     */
    public Color sample(double u, double v) {
        // Gestion du "tiling" (répétition) : on ne garde que la partie décimale
        double u_frac = u - Math.floor(u);
        double v_frac = v - Math.floor(v);

        // Conversion des coordonnées normalisées en indices de pixels de l'image
        int x = (int) (u_frac * width);
        int y = (int) (v_frac * height);

        // Sécurité anti-débordement (au cas où la fraction vaudrait exactement 1.0)
        x = Math.max(0, Math.min(x, width - 1));
        y = Math.max(0, Math.min(y, height - 1));

        // Retourne la couleur du pixel à ces coordonnées
        return new Color(image.getRGB(x, y));
    }
}
