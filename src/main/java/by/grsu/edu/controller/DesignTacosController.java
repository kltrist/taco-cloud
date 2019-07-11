package by.grsu.edu.controller;

import by.grsu.edu.entity.Taco;
import by.grsu.edu.repository.TacoRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j
@RestController
@RequestMapping(path = "/design",
        produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacosController {

    private final TacoRepository tacoRepo;


    public DesignTacosController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;

    }



    @GetMapping("/{id}")
    public ResponseEntity<Taco> getTacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        return optTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }




}