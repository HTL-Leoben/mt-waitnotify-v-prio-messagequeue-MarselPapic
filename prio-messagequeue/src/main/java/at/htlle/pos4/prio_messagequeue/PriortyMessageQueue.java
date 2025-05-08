package at.htlle.pos4.prio_messagequeue;

import java.util.LinkedList;

class PriortyMessageQueue {
    private final LinkedList<Message> priorityQueue = new LinkedList<>();
    private final LinkedList<Message> normalQueue = new LinkedList<>();
    private final int maxSize;

    public PriortyMessageQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void sendMessge(Message msg) throws InterruptedException {
        while (priorityQueue.size() + normalQueue.size() >= maxSize) {
            wait();
        }
        if (msg.isPriority()) {
            priorityQueue.addLast(msg);
        } else {
            normalQueue.addLast(msg);
        }
        notifyAll(); // Weckt wartende Consumer
    }

    public synchronized Message receiveMessage() throws InterruptedException {
        while (priorityQueue.isEmpty() && normalQueue.isEmpty()) {
            wait();
            System.out.println("WAIT");
        }
        Message msg;
        if (!priorityQueue.isEmpty()) {
            msg = priorityQueue.removeFirst();
        } else {
            msg = normalQueue.removeFirst();
        }
        notifyAll(); // Weckt wartende Producer
        return msg;
    }
}
