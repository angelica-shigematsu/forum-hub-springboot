package br.com.hub.forum.domain.models;

public enum StatusTopic {
    RASCUNHO,
    PUBLICADO;

    public static StatusTopic fromString(String value) {
        if (value.equalsIgnoreCase("RASCUNHO")){
            return StatusTopic.RASCUNHO;
        } else {
            return StatusTopic.PUBLICADO;
        }
    }
}
