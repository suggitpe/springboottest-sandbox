package org.suggs.sandbox.springboottest.greeting.domain;

public class Greeting {

    private final long id;
    private final String from;
    private final String greeting;
    private final long unusedID;

    public Greeting(long id, String from, String content, long unusedID) {
        this.id = id;
        this.from = from;
        this.greeting = content;
        this.unusedID = unusedID;
    }

    public long getId() {
        return id;
    }

    public String getFrom(){
        return from;
    }

    public String getGreeting() {
        return greeting;
    }

    public long getUnusedID(){
        return unusedID;
    }
}
