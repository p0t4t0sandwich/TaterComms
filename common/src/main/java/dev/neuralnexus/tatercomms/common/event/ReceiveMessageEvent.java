package dev.neuralnexus.tatercomms.common.event;

import dev.neuralnexus.tatercomms.common.api.TaterCommsAPIProvider;
import dev.neuralnexus.tatercomms.common.api.message.Message;

/** Receive message event. */
public class ReceiveMessageEvent {
    private final Message message;

    public ReceiveMessageEvent(Message message) {
        if (message.isRemote()) {
            message.setPlaceHolderMessage(TaterCommsAPIProvider.get().getFormatting("remote"));
        } else if (message.isGlobal()) {
            message.setPlaceHolderMessage(TaterCommsAPIProvider.get().getFormatting("global"));
        }
        this.message = message;
    }

    /**
     * Get the message.
     *
     * @return The message.
     */
    public Message getMessage() {
        return message;
    }
}
