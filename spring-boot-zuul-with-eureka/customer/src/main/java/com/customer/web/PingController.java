package com.customer.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PingController {

    @Value("${server.port}")
    int port;

    /**
     * Path used by ribbon to check if application is alive.
     *
     * @return
     */
    @GetMapping(
            value = "/",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String ping() {
        return "Ping";
    }

    /**
     * Checker to know if load balancing is working.
     *
     * @return
     */
    @GetMapping(
            value = "/check-load-balancing",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String check() {
        return "Request to customer service running on port: " + port;
    }
}
