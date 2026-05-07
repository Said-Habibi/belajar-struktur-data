public class ArrayExamples {
    public static void main(String[] args) {
        // ============================================
        // 1. Array 1 Dimensi (1D Array)
        // ============================================
        System.out.println("=== 1D Array ===");
        int[] array1D = {10, 20, 30, 40, 50};
        
        // Mengakses dan mencetak nilai array 1D
        for (int i = 0; i < array1D.length; i++) {
            System.out.print(array1D[i] + " ");
        }
        System.out.println("\n");

        // ============================================
        // 2. Array 2 Dimensi (2D Array) - seperti Matriks/Tabel
        // ============================================
        System.out.println("=== 2D Array ===");
        int[][] array2D = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Mengakses dan mencetak nilai array 2D
        for (int baris = 0; baris < array2D.length; baris++) {
            for (int kolom = 0; kolom < array2D[baris].length; kolom++) {
                System.out.print(array2D[baris][kolom] + " ");
            }
            System.out.println(); // Pindah baris
        }
        System.out.println();

        // ============================================
        // 3. Array 3 Dimensi (3D Array) - seperti Kubus
        // ============================================
        System.out.println("=== 3D Array ===");
        int[][][] array3D = {
            { // Layer/Kedalaman 1
                {1, 2, 3}, 
                {4, 5, 6}
            },
            { // Layer/Kedalaman 2
                {7, 8, 9}, 
                {10, 11, 12}
            }
        };
        
        // Mengakses dan mencetak nilai array 3D
        for (int layer = 0; layer < array3D.length; layer++) {
            System.out.println("Layer " + (layer + 1) + ":");
            for (int baris = 0; baris < array3D[layer].length; baris++) {
                for (int kolom = 0; kolom < array3D[layer][baris].length; kolom++) {
                    System.out.print(array3D[layer][baris][kolom] + " ");
                }
                System.out.println(); // Pindah baris
            }
            System.out.println(); // Spasi antar layer
        }
    }
}
