package br.com.webflux.services;

import br.com.webflux.documents.User;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> create(User user);
    Mono<User> update(User user);
    Mono<User> findById(String id);
    Flux<User> findAll(Pageable page);
    Flux<User> findUsersByName(String name, Pageable page);
    void deleteById(String id);
}
