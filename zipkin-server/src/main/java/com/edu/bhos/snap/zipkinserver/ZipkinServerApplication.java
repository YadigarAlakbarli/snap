package com.edu.bhos.snap.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
@EnableEurekaClient
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

}
