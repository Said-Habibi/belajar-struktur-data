public class MethodProcedureDanFunction {
    public void hitungUmur(int tahunLahir){
        int umur = 2026 - tahunLahir;
        System.out.println("Umur saia " + umur);
    }
    public static void main(String[] args) {
        MethodProcedureDanFunction iniObject = new MethodProcedureDanFunction();
        iniObject.hitungUmur(2007);
    }
}
