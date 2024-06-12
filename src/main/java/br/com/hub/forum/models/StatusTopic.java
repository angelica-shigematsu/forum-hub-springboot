package br.com.hub.forum.models;

public enum StatusTopic {
    DO,
    DONE,
    TODO;

    public static StatusTopic fromString(String value) {
        if (value.equalsIgnoreCase("do")){
            return StatusTopic.DO;
        } else if (value.equalsIgnoreCase("done")){
            return StatusTopic.DONE;
        } else {
            return StatusTopic.TODO;
        }
    }
}
