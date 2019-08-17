package br.com.webflux.controllers;

import br.com.webflux.documents.User;
import br.com.webflux.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Api("User Controller")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    @ApiOperation("Register User")
    public ResponseEntity<Mono<User>> create(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.OK).body(service.create(user));
    }

    @GetMapping()
    @ApiOperation("Find User by id")
    public ResponseEntity<Mono<User>> findAllById(@RequestParam(value = "id client") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @GetMapping("all")
    @ApiOperation("get all Users")
    public ResponseEntity<Flux<User>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }

    @GetMapping("findByName")
    @ApiOperation("Find Users by name")
    public ResponseEntity<Flux<User>> findByName(@RequestParam(value = "nameClient") String name) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findUsersByName(name));
    }

    @PutMapping
    @ApiOperation(value = "Update User")
    public ResponseEntity<Mono<User>> update(@ApiParam(value = "Client", required = true) @RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(user));
    }

    @DeleteMapping("/delete")
    @ApiOperation("Delete User By Id")
    public ResponseEntity<Void> delete(@RequestParam(value = "id user") String id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
