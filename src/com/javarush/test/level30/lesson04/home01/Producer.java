package com.javarush.test.level30.lesson04.home01;


import java.util.concurrent.TransferQueue;


public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    @Override
    public void run()
    {
        try
        {
            for (int i = 1; i < 10; i++)
            {
                if (!Thread.interrupted())
                {
                    ShareItem si = new ShareItem("ShareItem-" + i, i);
                    System.out.format("Элемент '%s' добавлен", si.getDescription());
                    System.out.println();
                    queue.offer(si);
                    Thread.sleep(100);
                    if(queue.getWaitingConsumerCount()>0) System.out.println("Consumer в ожидании!");
                } else throw new InterruptedException();
            }

        }
        catch (InterruptedException e){}




        }


    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }
}
