package exception;

public class Test {
    public static void main(String[] args) throws Exception {

        // https://www.cnblogs.com/hysum/p/7112011.html

        String word = testException();
        System.out.println(word);

        Test test = new Test();
        test.throwException();
    }

    public static String testException() {
        // 当try和finally中都有return语句时， 在方法返回之前， finally中的语句会被执行
        // 同时，finally中的返回值会覆盖原始的返回值

        // 即，如果try， finally中都有return ,则忽略try中的return , 而是用finally中的return
//        try {
//            int j = 10 / 1;
//            return "try";
//        } finally {
//            System.out.println("this is finally");
//            return  "finally";
//        }


        // 当try中有return语句时，会先执行finally中的语句，最后返回try中的return
//        try {
//            return "second try";
//        } finally {
//            System.out.println("this is second finally");
//        }


        // 当程序中有多个catch代码块时，要按照先catch子类，后catch父类的处理方式
        try {
            return "try";
        } catch(RuntimeException e) {

        } catch (Exception e) {

        }

        // throw 和 throws的一些比较
        /*
        *  1. throws出现在方法头， throw出现在方法体中
        *  2. throws表现的是出现异常的一种可能性，并不一定会发生异常，throw则是抛出了异常，执行throw一定会抛出异常
        *  3. 两者都是消极处理异常的方式，只是抛出或者可能抛出异常，但是不会有函数去处理，真正的处理是在函数的上层调用
        *  4. throws的异常可以抛出一个异常，也可以抛出一系列异常，throws (Exception1, Exception2, Exception3)
        *  5. 如果一个方法调用了抛出异常的方法，那么必须添加try catch语句或者向上抛出该异常
        * */



        return "string";
    }

    public void throwException() throws Exception{
        throw new Exception();
    }
}

class UserException extends RuntimeException {
    private String errorCode;

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    private UserException() {}

    public UserException(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
