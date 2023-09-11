package math;

public class TranslScalRot4x4 extends Matrix4x4 {

    double dx = 0;
    double dy = 0;
    double dz = 0;
    double sx = 1;
    double sy = 1;
    double sz = 1;
    double thetaX = 0;
    double thetaY = 0;
    double thetaZ = 0;
    double centerX = 0;
    double centerY = 0;
    double centerZ = 0;

    public TranslScalRot4x4() {
        super();
    }

    public TranslScalRot4x4(double dx, double dy, double dz,
            double sx, double sy, double sz,
            double thetaX, double thetaY, double thetaZ,
            double centerX, double centerY, double centerZ) {
        super();
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
        this.sx = sx;
        this.sy = sy;
        this.sz = sz;
        this.thetaX = thetaX;
        this.thetaY = thetaY;
        this.thetaZ = thetaZ;
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
    }

    // Aplicar transformaciones de traslación
    public void translate(double dx, double dy, double dz) {
        // Crear una matriz de traslación 4x4
        Matrix4x4 translationMatrix = new Matrix4x4();
        translationMatrix.set(0, 3, dx);
        translationMatrix.set(1, 3, dy);
        translationMatrix.set(2, 3, dz);

        // Multiplicar la matriz de traslación por la matriz actual
        multiplyMatrix(translationMatrix);
    }

    // Aplicar transformaciones de escalado
    public void scale(double sx, double sy, double sz, double centerX, double centerY, double centerZ) {
        // Crear una matriz de escalado 4x4
        Matrix4x4 scalingMatrix = new Matrix4x4();
        scalingMatrix.set(0, 0, sx);
        scalingMatrix.set(1, 1, sy);
        scalingMatrix.set(2, 2, sz);

        // Multiplicar la matriz de escalado por la matriz actual
        multiplyMatrix(scalingMatrix);
    }

    // Aplicar transformaciones de rotación en el eje X
    public void rotateX(double thetaX, double centerX, double centerY, double centerZ) {
        // Crear una matriz de rotación en el eje X 4x4
        Matrix4x4 rotationMatrixX = new Matrix4x4();
        rotationMatrixX.set(1, 1, Math.cos(thetaX));
        rotationMatrixX.set(1, 2, -Math.sin(thetaX));
        rotationMatrixX.set(2, 1, Math.sin(thetaX));
        rotationMatrixX.set(2, 2, Math.cos(thetaX));

        // Multiplicar la matriz de rotación por la matriz actual
        multiplyMatrix(rotationMatrixX);
    }

    // Aplicar transformaciones de rotación en el eje Y
    public void rotateY(double thetaY, double centerX, double centerY, double centerZ) {
        // Crear una matriz de rotación en el eje Y 4x4
        Matrix4x4 rotationMatrixY = new Matrix4x4();
        rotationMatrixY.set(0, 0, Math.cos(thetaY));
        rotationMatrixY.set(0, 2, Math.sin(thetaY));
        rotationMatrixY.set(2, 0, -Math.sin(thetaY));
        rotationMatrixY.set(2, 2, Math.cos(thetaY));

        // Multiplicar la matriz de rotación por la matriz actual
        multiplyMatrix(rotationMatrixY);
    }

    // Aplicar transformaciones de rotación en el eje Z
    public void rotateZ(double thetaZ, double centerX, double centerY, double centerZ) {
        // Crear una matriz de rotación en el eje Z 4x4
        Matrix4x4 rotationMatrixZ = new Matrix4x4();
        rotationMatrixZ.set(0, 0, Math.cos(thetaZ));
        rotationMatrixZ.set(0, 1, -Math.sin(thetaZ));
        rotationMatrixZ.set(1, 0, Math.sin(thetaZ));
        rotationMatrixZ.set(1, 1, Math.cos(thetaZ));

        // Multiplicar la matriz de rotación por la matriz actual
        multiplyMatrix(rotationMatrixZ);
    }

    // Método para multiplicar dos matrices 4x4
    private void multiplyMatrix(Matrix4x4 m) {
        // Realizar la multiplicación de matrices manualmente
        double[][] resultMatrix = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                resultMatrix[i][j] = 0;
            }
            }}}
