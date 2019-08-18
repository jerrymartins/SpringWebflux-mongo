package br.com.webflux.services.impl;

import br.com.webflux.documents.User;
import br.com.webflux.repositories.UserRepository;
import br.com.webflux.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public Mono<User> create(User user) {
        return repository.save(user);
    }

    @Override
    public Mono<User> update(User user) {
        return repository.save(user);
    }

    @Override
    public Mono<User> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<User> findAll(Pageable page) {
        return repository.findAll();
    }

    @Override
    public Flux<User> findUsersByName(String name, Pageable page) {
        return repository.findUsersByName(name, page);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
