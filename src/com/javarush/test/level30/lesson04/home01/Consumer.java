package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;


public class Consumer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try{
            Thread.sleep(500);
            while(true){
                if(!Thread.interrupted()){
                ShareItem si = queue.take();
                if(si!=null){
                System.out.println("Processing "+ si.toString());
                }}
                else throw new InterruptedException();
            }
        }
        catch (InterruptedException e){}

        }
}



