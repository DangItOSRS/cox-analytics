package com.coxanalytics.party;

import lombok.Value;
import net.runelite.client.party.messages.PartyMessage;

/**
 * A message packet used to synchronize raid split times across a party
 * during a Chambers of Xeric raid.
 */
@Value
public class CoxTimePacket extends PartyMessage
{
    /**
     * The most recent room recorded in the user's splits.
     * Used to verify that both the sender and receiver are currently
     * synchronized within the same raid instance.
     */
    String lastRecordedRoomName;

    /**
     * The most recent room the sender physically saw a split for in
     * their own chat box (native game message). If the sender missed
     * a previous room transition, their next split will be a sum of
     * multiple rooms, making the individual room time invalid.
     */
    String lastSeenRoomName;

    /**
     * The specific room name that this current split packet is being
     * reported for.
     */
    String roomName;

    /**
     * The elapsed time recorded for the room specified in {@link #roomName}.
     */
    String time;
}