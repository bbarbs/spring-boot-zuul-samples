package com.gateway.config;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class HystrixZuulFallbackConfig {

    @Bean
    public FallbackProvider customerServiceFallbackProvider() {
        return new FallbackProvider() {
            @Override
            public ClientHttpResponse fallbackResponse(Throwable cause) {
                return new ClientHttpResponse() {
                    @Override
                    public HttpStatus getStatusCode() throws IOException {
                        return HttpStatus.SERVICE_UNAVAILABLE;
                    }

                    @Override
                    public int getRawStatusCode() throws IOException {
                        return HttpStatus.SERVICE_UNAVAILABLE.value();
                    }

                    @Override
                    public String getStatusText() throws IOException {
                        return HttpStatus.SERVICE_UNAVAILABLE.toString();
                    }

                    @Override
                    public void close() {
                    }

                    @Override
                    public InputStream getBody() throws IOException {
                        String str = "{\n" +
                                "  \"fallback\" : \"Service Down\"\n" +
                                "}";
                        InputStream stream = new ByteArrayInputStream(str.getBytes());
                        return stream;
                    }

                    @Override
                    public HttpHeaders getHeaders() {
                        HttpHeaders headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        return headers;
                    }
                };
            }

            @Override
            public String getRoute() {
                // Service id.
                return "customer-service";
            }

            @Override
            public ClientHttpResponse fallbackResponse() {
                return new ClientHttpResponse() {
                    @Override
                    public HttpStatus getStatusCode() throws IOException {
                        return HttpStatus.OK;
                    }

                    @Override
                    public int getRawStatusCode() throws IOException {
                        return HttpStatus.OK.value();
                    }

                    @Override
                    public String getStatusText() throws IOException {
                        return HttpStatus.OK.toString();
                    }

                    @Override
                    public void close() {
                    }

                    @Override
                    public InputStream getBody() throws IOException {
                        String str = "{\n" +
                                "  \"fallback\" : \"Service Down\"\n" +
                                "}";
                        InputStream stream = new ByteArrayInputStream(str.getBytes());
                        return stream;
                    }

                    @Override
                    public HttpHeaders getHeaders() {
                        HttpHeaders headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        return headers;
                    }
                };
            }
        };
    }
}
