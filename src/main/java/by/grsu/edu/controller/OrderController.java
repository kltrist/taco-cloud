package by.grsu.edu.controller;


import by.grsu.edu.entity.Order;
import by.grsu.edu.entity.User;
import by.grsu.edu.repository.OrderRepository;
import by.grsu.edu.web.OrderProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/orders")
@SessionAttributes("order")
@CrossOrigin(origins = "*")
public class OrderController {

    private OrderRepository orderRepo;
    private OrderProps orderProps;


    public OrderController(OrderRepository orderRepo, OrderProps orderProps) {
        this.orderRepo = orderRepo;
        this.orderProps = orderProps;
    }




    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Order postTaco(@RequestBody @Valid Order order,
                          SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        order.setUser(user);
        orderRepo.save(order);
        sessionStatus.setComplete();
        return order;
    }


    @PutMapping("/{orderId}")
    public Order putOrder(@RequestBody Order order) {
        return orderRepo.save(order);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public Order patchOrder(@PathVariable("orderId") Long orderId,
                            @RequestBody Order patch) {
        Order order = orderRepo.findById(orderId).get();
        if (patch.getId() != null) {
            order.setId(patch.getId());
        }
        if (patch.getStreet() != null) {
            order.setStreet(patch.getStreet());
        }
        if (patch.getCity() != null) {
            order.setCity(patch.getCity());
        }
        if (patch.getState() != null) {
            order.setState(patch.getState());
        }
        if (patch.getZip() != null) {
            order.setZip(patch.getZip());
        }
        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }
        return orderRepo.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            orderRepo.deleteById(orderId);
        } catch (EmptyResultDataAccessException ignored) {}
    }

    public String ordersForUser(@AuthenticationPrincipal User user, Model model) {
        Pageable pageable = PageRequest.of(0, orderProps.getPageSize());
        model.addAttribute("order",
                orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));

        return "orderList";
    }
}

