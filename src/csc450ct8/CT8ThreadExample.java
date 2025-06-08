package csc450ct8;

public class CT8ThreadExample {

    // Class that counts up to 20
    static class UpCounter implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 20; i++) {
                System.out.println("Counting up: " + i);
            }
        }
    }

    // Class that counts down to 0
    static class DownCounter implements Runnable {
        @Override
        public void run() {
            for (int i = 20; i >= 0; i--) {
                System.out.println("Counting down: " + i);
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            Thread counterUp = new Thread(new UpCounter());
            counterUp.start();
            counterUp.join(); // Wait for the first thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter Up finished. Now starting Counter Down...");

        try{
            Thread counterDown = new Thread(new DownCounter());
            counterDown.start();
            counterDown.join(); // Wait for the second thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
