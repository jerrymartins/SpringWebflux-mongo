package br.com.webflux.repositories;

import br.com.webflux.documents.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository  extends ReactiveCrudRepository<User, String> {
    Mono<User> findById(String id);
    Flux<User> findUsersByName(String name, Pageable pageable);
}
