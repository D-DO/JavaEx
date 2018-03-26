// Простой пример применения семафора в Java

import java.util.concurrent.*;

class SemDemo {

    public static void main(String args[]) {
        Semaphore sem = new Semaphore(1);

        new Thread(new IncThread(sem, "A")).start();
        new Thread(new DecThread(sem, "B")).start();

    }

}

// Общий ресурс

class Shared {
    static int count = 0;
}

// Поток исполнения, увеличивающий значение счетчика на единицу

class IncThread implements Runnable {

    String name;
    Semaphore sem;

    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
    //    new Thread(this).start();
    }

    public void run() {
        System.out.println("Запуск потока " + name);
        try {
            // сначала получить разрешение
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение");

            // а теперь получить доступ к общему ресурсу

            for(int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                // Разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        // освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}

// Поток исполнения, уменьшающий значение счетчика на единицу

class DecThread implements Runnable {

    String name;
    Semaphore sem;

    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
      //  new Thread(this).start();
    }

    public void run() {
        System.out.println("Запуск потока " + name);
        try {
            // сначала получить разрешение
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение");

            // а теперь получить доступ к общему ресурсу

            for(int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                // Разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        // освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}

//        Запуск потока A
//        Поток A ожидает разрешения
//        Поток A получает разрешение
//        Запуск потока B
//        Поток B ожидает разрешения
//        A: 1
//        A: 2
//        A: 3
//        A: 4
//        A: 5
//        Поток A освобождает разрешение
//        Поток B получает разрешение
//        B: 4
//        B: 3
//        B: 2
//        B: 1
//        B: 0
//        Поток B освобождает разрешение