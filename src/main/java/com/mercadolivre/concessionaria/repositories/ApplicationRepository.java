package com.mercadolivre.concessionaria.repositories;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository<K, T> {

    public T create(T object);
    public List<T> read();
    public Optional<T> find(K objectId);
    public T update(K objectId, T newObject);
    public void delete(T object);

}
