package part2.chapter2;

/**
 * VM Args： -Xss2M （这时候不妨设大些， 请在32位系统下运行）
 *  64位系统不要运行,会死机 假如真的要运行,可以在虚拟机里面玩一玩
 *
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
