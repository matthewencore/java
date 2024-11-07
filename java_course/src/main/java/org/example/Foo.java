public final class Foo {
    public String str1 = "";
    public String str2 = "";
    public int num1 = 0;
    public int num2 = 0;

    // привет
    // как дела друг
    public Foo() {
        str1 = "Привет";
    }

    public static Foo methodCreate(){
        return new Foo();
    }
}
