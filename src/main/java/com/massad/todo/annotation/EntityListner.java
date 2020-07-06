package com.massad.todo.annotation;

import com.massad.todo.crypthage.Rsa4096;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import java.util.stream.Stream;

public class EntityListner {

    @PrePersist
    public void beforeInsert(Object o){
        Stream.of(
        o.getClass().getDeclaredFields()
        ).filter(field -> field.isAnnotationPresent(CryptoColumn.class)).forEach(field -> {
            field.setAccessible(true);
            try {
                CryptoColumn cryptoColumn = field.getAnnotation(CryptoColumn.class);
                Rsa4096 crypto = crypto = new Rsa4096(cryptoColumn.clePrivate(), cryptoColumn.clePublic());
                field.set(o,crypto.encryptToBase64((String) field.get(o)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @PostLoad
    public void afterLoad(Object o){
        Stream.of(
                o.getClass().getDeclaredFields()
        ).filter(field -> field.isAnnotationPresent(CryptoColumn.class)).forEach(field -> {
            field.setAccessible(true);
            try {
                CryptoColumn cryptoColumn = field.getAnnotation(CryptoColumn.class);
                Rsa4096 crypto = crypto = new Rsa4096(cryptoColumn.clePrivate(), cryptoColumn.clePublic());
                field.set(o,crypto.decryptFromBase64((String) field.get(o)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}
