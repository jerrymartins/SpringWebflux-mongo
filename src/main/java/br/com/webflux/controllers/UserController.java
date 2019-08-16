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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api("User Controller")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    @ApiOperation("Register User")
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.OK).body(service.create(user));
    }

    @GetMapping()
    @ApiOperation("Find User by id")
    public ResponseEntity<Optional<User>> findAllById(@RequestParam(value = "id client") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @GetMapping("all")
    @ApiOperation("get all Users")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }

    @PutMapping
    @ApiOperation(value = "Update User")
    public ResponseEntity<User> update(@ApiParam(value = "Client", required = true) @RequestBody @Valid User user) {
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
