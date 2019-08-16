package br.com.webflux.services;

import br.com.webflux.documents.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);
    User update(User user);
    Optional<User> findById(String id);
    List<User> findAll();
    void deleteById(String id);
}
