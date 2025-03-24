package p2pchatsystem.main.model.business;

import p2pchatsystem.main.model.business.MessageContent;

public class Message {

    boolean isSent;
    MessageContent messageContent;

    public Message(boolean isSent, MessageContent messageContent) {
        this.isSent = isSent;
        this.messageContent = messageContent;
    }
    public Message(MessageContent messageContent) {
        this.isSent = false;
        this.messageContent = messageContent;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public MessageContent getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(MessageContent messageContent) {
        this.messageContent = messageContent;
    }
}
