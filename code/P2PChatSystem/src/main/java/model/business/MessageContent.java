package model.business;

import java.util.Date;

/**
 * manage the content of messages
 * (is an adapter to the content of messages to
 * J____ objects from swing/awt)
 */
public interface MessageContent {
    /**
     * transform the content to (see on top of the class)
     * @return
     */
    public MessageContent getContent();
}
