import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {

        TestProxyHandler testProxyHandler = new TestProxyHandler(new TestInterfaceImpl());
        testProxyHandler.when("calculate", 1, 2).then(3);
        testProxyHandler.when("calculate", "a", "b").then("ab");

        TestInterface proxy = (TestInterface) Proxy.newProxyInstance(TestInterface.class.getClassLoader(),
                new Class[]{TestInterface.class},
                new TestProxyHandler(new TestInterfaceImpl()));

        String calculate = proxy.calculate("a", "b");
        boolean result = calculate.equals("ab");
        // result must be true
        assert result : true;
    }

    public interface TestInterface{
        String calculate(String a, String b);
        int calculate(int a, int b);
    }

    public static class TestInterfaceImpl implements TestInterface{

        @Override
        public String calculate(String a, String b) {
            return a + b;
        }

        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    }

    public static class TestProxyHandler implements InvocationHandler{

        private final Object target;

        private Object result;

        public TestProxyHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object invoke = method.invoke(target, args[0], args[1]);
            return invoke;
        }

        public TestProxyHandler when(String method, Object... args){
            Class<?>[] paramInfo = objectToClassParam(args);

            try {
                Method findMethod = target.getClass().getMethod(method, paramInfo);
                this.result = findMethod.invoke(target, args);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            return this;
        }

        public void then(Object expectedResult){
            // 주어진 매개변수가 result의 타입과 일치하는지 체크하여 아니면 에러발생
            if (!result.getClass().equals(expectedResult.getClass())) {
                throw new IllegalArgumentException("Expected result type: " + expectedResult.getClass() +
                        " but actual result type: " + result.getClass());
            }

            if(!result.equals(expectedResult))
                throw new IllegalStateException("expected result : " + expectedResult + "is different result : " + result);
        }

        private static Class<?>[] objectToClassParam(Object[] args) {
            Class<?>[] parameterTypes = new Class<?>[args.length];

            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof Integer) {
                    parameterTypes[i] = int.class;
                } else if (args[i] instanceof String) {
                    parameterTypes[i] = String.class;
                } else {
                    // Handle other types as needed
                    throw new IllegalArgumentException("Unsupported argument type: " + args[i].getClass());
                }
            }

            return parameterTypes;
        }
    }


}
