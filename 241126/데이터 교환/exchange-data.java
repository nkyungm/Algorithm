public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int a= 5;
        int b =6;
        int c= 7;

        int aTemp = a;
        int bTemp = b;
        a= c;
        b= aTemp;
        c=bTemp;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}