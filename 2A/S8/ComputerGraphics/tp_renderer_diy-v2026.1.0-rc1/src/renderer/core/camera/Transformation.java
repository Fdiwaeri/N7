package renderer.core.camera;

import renderer.algebra.Matrix;
import renderer.algebra.SizeMismatchException;
import renderer.algebra.Vector;


/**
 * The Transformation class represents a transformation in 3D space.
 * author: cdehais
 */
public class Transformation {

    /**
     * The world to camera matrix.
     */
    private Matrix worldToCamera;
    /**
     * The 3x4 projection matrix.
     */
    private Matrix projection;
    /**
     * The 3x3 calibration matrix.
     */
    private Matrix calibration;

    /**
     * Creates a new Transformation object.
     */
    public Transformation() {
        final int w2cDim = 4;
        worldToCamera = Matrix.createIdentity("W2C", w2cDim);
        final int projRows = 3;
        final int projCols = 4;
        projection = new Matrix("P", projRows, projCols);
        final int calibDim = 3;
        calibration = Matrix.createIdentity("K", calibDim);
    }

    /**
     * Sets the lookAt transformation.
     * @param eye a 3D vector representing the eye position
     * @param lookAtPoint a 3D vector representing the point to look at
     * @param up a 3D vector representing the up direction
     */
    public void setLookAt(final Vector eye, final Vector lookAtPoint, final Vector up) {
        try {
            // Camera axes:
            // Z axis points from Eye to LookAt 
            Vector zAxis = lookAtPoint.subtract(eye).normalize();

            // X axis = Up ^ Z
            Vector xAxis = up.cross(zAxis).normalize();

            // Y axis = Z ^ X
            Vector yAxis = zAxis.cross(xAxis); //already normalized since Z and X are

          
            // Création de la matrice de Rotation
            Matrix R = Matrix.createIdentity(4);
            R.set(0, 0, xAxis.get(0)); R.set(0, 1, xAxis.get(1)); R.set(0, 2, xAxis.get(2));
            R.set(1, 0, yAxis.get(0)); R.set(1, 1, yAxis.get(1)); R.set(1, 2, yAxis.get(2));
            R.set(2, 0, zAxis.get(0)); R.set(2, 1, zAxis.get(1)); R.set(2, 2, zAxis.get(2));

            // Création de la matrice de Translation
            Matrix T = Matrix.createIdentity(4);
            T.set(0, 3, -eye.get(0));
            T.set(1, 3, -eye.get(1));
            T.set(2, 3, -eye.get(2));

            // worldToCamera = Rotation * Translation
            this.worldToCamera = R.multiply(T);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Modelview matrix:\n" + worldToCamera);
    }

    /**
     * Sets the projection matrix.
     */
    public void setProjection() {
        this.projection = Matrix.createIdentity(4);
        // On remplace la dernière ligne pour que W = Z
        this.projection.set(3, 2, 1.0); 
        this.projection.set(3, 3, 0.0);

        System.out.println("Projection matrix:\n" + projection);
    }

    /**
     * Sets the calibration matrix.
     * @param focal the focal length
     * @param width the width of the image
     * @param height the height of the image
     */
    public void setCalibration(double focal, double width, double height) {
        // coordonnées géométriques -> pixels
        this.calibration = Matrix.createIdentity(4);
        this.calibration.set(0, 0, focal);
        this.calibration.set(1, 1, focal); //-focal si l'axe Y des pixels est inversé
        
        //on décale pour centrer l'image
        this.calibration.set(0, 2, width / 2.0);
        this.calibration.set(1, 2, height / 2.0);

        System.out.println("Calibration matrix:\n" + calibration);
    }

    /**
     * Projects the given 3 dimensional point onto the screen.
     * The resulting Vector as its (x,y) coordinates in pixel, and its z coordinate
     * is the depth of the point in the camera coordinate system.
     * @param p a 3d vector representing a point
     * @return the projected point as a 3d vector, with (x,y) the pixel
     * coordinates and z the depth
     * @throws SizeMismatchException if the size of the input vector is not 3
     */
    public Vector projectPoint(Vector p) throws SizeMismatchException {
        // Homogeneous coords (x, y, z, 1)
        Vector ph = p.homogeneousPoint();
        // World -> Camera
        Vector pCam = worldToCamera.multiply(ph);
        double depthZ = pCam.get(2); // sauvegarde de z
        // projection to 3D camera coords 
        Vector pProj = projection.multiply(pCam);
        // perspective division
        double z = pProj.get(2);
        if (Math.abs(z) < 1e-6) z = 1e-6; // Sécurité anti division par zéro

        // Normalized Device Coords (x/z, y/z, 1)
        Vector pNorm = new Vector(4);
        pNorm.set(0, pProj.get(0) / z);
        pNorm.set(1, pProj.get(1) / z);
        pNorm.set(2, 1.0);
        pNorm.set(3, 1.0);

        // Calibration -> Pixels
        Vector pPixel = calibration.multiply(pNorm);

        // Resultat : pixel_x, pixel_y, z_original
        Vector ps = new Vector(3);
        ps.set(0, pPixel.get(0));
        ps.set(1, pPixel.get(1));
        ps.set(2, depthZ);

        return ps;
    }

    /**
     * Transform a vector from world to camera coordinates.
     * @param v the vector to transform
     * @return the transformed vector
     * @throws SizeMismatchException if the size of the input vector is not 3
     */
    public Vector transformVector(final Vector v) {
        // Doing nothing special here because there is no scaling
        final Matrix m = worldToCamera.getSubMatrix(0, 0, 3, 3);
        return m.multiply(v);
    }

}
