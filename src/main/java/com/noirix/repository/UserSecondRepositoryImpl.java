package com.noirix.repository;

import com.noirix.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserSecondRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findOne(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User create(User object) {
        return null;
    }

    @Override
    public User update(User object) {
        return null;
    }

    @Override
    public User delete(Long id) {

        return null;
    }

    @Override
    public void searchUser() {

    }
}
