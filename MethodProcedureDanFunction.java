public class MethodProcedureDanFunction {
    public void hitungUmur(int tahunLahir, String nama){
        int umur = 2026 - tahunLahir;
        System.out.println("Umur saia " + umur);
        System.out.println("Nama saia "+nama);
    }
    public int hitungUmurIndonesia(){
        int umurIndonesia = 2026 - 1945;
        return umurIndonesia;
    }

    public static void main(String[] args) {
        MethodProcedureDanFunction iniObject = new MethodProcedureDanFunction();
        iniObject.hitungUmur(2007, "Said");

        int simpan = iniObject.hitungUmurIndonesia();
        System.out.println(simpan);

        System.out.println(iniObject.hitungUmurIndonesia());
    }
}
