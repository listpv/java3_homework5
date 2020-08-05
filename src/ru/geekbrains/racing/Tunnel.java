package ru.geekbrains.racing;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage
{
    Semaphore semaphore;     //  при условии задания, что гонка состоит из одного круга, Tunnel разные.
    public Tunnel(int number)
    {
        semaphore = new Semaphore(number);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
