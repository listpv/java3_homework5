package ru.geekbrains.racing;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Main
{
    public static final int CARS_COUNT = 4;
    public static AtomicInteger atomicIntegerStart;    // для момента старта.
    public static AtomicInteger atomicIntegerWin;      // для момента победы.

    public static void main(String[] args)
    {
	// write your code here
        atomicIntegerStart = new AtomicInteger(0);
        atomicIntegerWin = new AtomicInteger(0);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);  // для линии старта, передаю в Car.
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        // передаю в Tunnel пропускную способность.
        Race race = new Race(new Road(60), new Tunnel(2), new Road(40), new Tunnel(3));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, cyclicBarrier,  20 + (int) (Math.random() * 10));
        }
        Thread[] threadsCars = new Thread[cars.length];
        for (int i = 0; i < cars.length; i++) {
//            new Thread(cars[i]).start();
            threadsCars[i] = new Thread(cars[i]);
            threadsCars[i].start();
        }
        for (int i = 0; i < cars.length; i++)
        {
            try {
                threadsCars[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
