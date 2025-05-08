package at.htlle.pos4.prio_messagequeue;

import java.util.Random;

class Producer extends Thread {

    // Producer name
    private String producerName;

    PriortyMessageQueue queue;
    public Producer(String producerName, PriortyMessageQueue queue){
        this.producerName = producerName;
        this.queue = queue;
    }


    // Constructor, getter, setter

    // Produce at random time Messages
    @Override
    public void run() {
        Random random = new Random();
        int count = 1;

        try {
            while (true) {
                Thread.sleep(random.nextInt(2000) + 500);
                boolean isPrio = random.nextBoolean();
                String content = "Message Content" + count++;
                Message msg = new Message(isPrio, content);
                queue.sendMessge(msg);
                if (isPrio) {
                    System.out.println(producerName + " sendMessage(true): " + content);
                } else {
                    System.out.println(producerName + " sendMessage(): " + content);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

