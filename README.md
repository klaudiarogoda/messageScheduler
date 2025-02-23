# MessageScheduler - Automated Message Sending App

This Java-based project sends automated daily messages through the macOS Messages app. It selects a random message each day.

## Files Overview:

- **MessageScheduler.java**: Schedules and sends daily messages using a `ScheduledExecutorService`.
- **MessageSender.java**: Main class that initiates the message scheduling process.
- **MessageService.java**: Sends messages via AppleScript to the macOS Messages app.

## How It Works:

1. Schedules and sends a random message each day.
2. Stops after sending messages for 3 days. 
3. Customizable message list and time.

## Prerequisites:

- **macOS** (since it uses AppleScript to send messages)
- **Java JDK** installed on your system


