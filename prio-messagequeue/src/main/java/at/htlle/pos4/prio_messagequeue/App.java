package at.htlle.pos4.prio_messagequeue;

/**
 * Hello world!
 *
 */
public class App {
        public static void main(String[] args) {
            // Erstelle die gemeinsame PriorityMessageQueue mit max. Kapazität 10
            PriortyMessageQueue queue = new PriortyMessageQueue(10);

            // Starte zwei Producer
            Producer producer1 = new Producer("Producer1", queue);
            Producer producer2 = new Producer("Producer2", queue);

            // Starte zwei Consumer
            Consumer consumer1 = new Consumer("Consumer1", queue);
            Consumer consumer2 = new Consumer("Consumer2", queue);

            producer1.start();
            producer2.start();
            consumer1.start();
            consumer2.start();
        }



}
