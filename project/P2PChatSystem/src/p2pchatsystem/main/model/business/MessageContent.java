package p2pchatsystem.main.model.business;

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
    MessageContent getContent();
}
