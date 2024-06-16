package br.com.hub.forum.models;

public enum StatusTopic {
    RASCUNHO,
    PUBLICADO;

    public static StatusTopic fromString(String value) {
        if (value.equalsIgnoreCase("do")){
            return StatusTopic.RASCUNHO;
        } else {
            return StatusTopic.PUBLICADO;
        }
    }
}
