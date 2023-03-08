package com.noirix.repository;

import com.noirix.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

//K - key, datatype of PK
//T - type of object
public interface CRUDRepository <K, T> {
    //    CRUD - operations
//    Create - Insert
//    Read - Select (by id, all, filtered)
//    Update
//    Delete



    Optional<T> findOne(T object);

    T findById(K id) throws EntityNotFoundException;

    List<T> findAll();

    T create(T object);

    T update(T object);

    T delete(K id) throws EntityNotFoundException;
}
