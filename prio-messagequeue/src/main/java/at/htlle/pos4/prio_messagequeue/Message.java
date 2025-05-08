package at.htlle.pos4.prio_messagequeue;

class Message {
    boolean isPriority = false;
    String content;

    public Message(boolean isPriority, String content) {
        this.isPriority = isPriority;
        this.content = content;
    }
// Constructor, getter, setter

    public boolean isPriority() {
        return isPriority;
    }

    public void setPriority(boolean priority) {
        isPriority = priority;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
