package br.com.webflux.services;

import br.com.webflux.documents.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

public interface UserService {
    Mono<User> create(User user);
    Mono<User> update(User user);
    Mono<User> findById(String id);
    Flux<User> findAll();
    Flux<User> findUsersByName(String name);
    void deleteById(String id);
}
