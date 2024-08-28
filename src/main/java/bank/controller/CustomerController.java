package bank.controller;

import bank.controller.base.BaseController;
import bank.dto.CustomerDto;
import bank.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController extends BaseController {
    private final CustomerService service;

    @GetMapping
    public ResponseEntity<?> findAll(Pageable pageable) {
        return call(() -> service.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable final String id) {
        return call(() -> service.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCustomerById(@Valid @RequestBody final CustomerDto dto,
                                                @PathVariable final String id) {
        return call(() -> service.updateById(dto, id));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody final CustomerDto dto) {
        return call(() -> service.create(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable final String id) {
        return call(() -> service.deleteById(id));
    }
}
