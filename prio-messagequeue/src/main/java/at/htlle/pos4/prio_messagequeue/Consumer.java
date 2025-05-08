package at.htlle.pos4.prio_messagequeue;

import java.util.Random;

class Consumer extends Thread {

    // Consumer name
    private String consumername;
    PriortyMessageQueue queue;

public Consumer(String consumername, PriortyMessageQueue queue){
    this.consumername = consumername;
    this.queue =  queue;
    }
    public String Consumername() {
        return consumername;
    }
    public void setConsumername(String name) {
        this.consumername = name;
    }
    // Constructor, getter, setter
    // Consume at random time messgaes
    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                Thread.sleep(random.nextInt(2000) + 500);
                Message msg = queue.receiveMessage();
                if (msg != null) {
                    System.out.println(consumername + " receiveMessage(): " + msg.isPriority() + ", " + msg.getContent());
                } else {
                    System.out.println(consumername + " receiveMessage(): WAIT");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
