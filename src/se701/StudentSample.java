public class Test {

    public interface DelBehaviour {
        public void Del(String message, int a);
    }


    public interface Del2Behaviour {
        public Dog Del2(int a, int b);
    }


    public static void DelegateMethod(String message, int b) {
    }

    public static void DelegateMethod2(String message, int b) {
    }

    public Dog lala(int m, int a) {
    }

    public void ShowOff(Del abc) {
    }

    public static void main(String args[]) {
        Del handler = DelegateMethod;
        Del handler3 = DelegateMethod2;
        Del2 handler2 = lala;
        handler("Hello World", 5);
        handler2(5, 5);
        ShowOff(handler);
        DelegateMethod("hello world", 5);
    }

    public class Dog {
    }
}
