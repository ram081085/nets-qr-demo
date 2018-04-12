package com.nets.demo.qr.main;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan(basePackages = { "com.nets.demo" })
@EnableAutoConfiguration
public class ApplicationConfig {

	@Value("${base.hostname}")
	private String baseHostname;

	@Bean
	public Docket apiName() {
		List<SecurityScheme> schemes = new ArrayList<>();
		SecurityScheme scheme = new BasicAuth("https");
		schemes.add(scheme);
		System.out.println(baseHostname);
		return new Docket(DocumentationType.SWAGGER_2).groupName("name").
				select().apis(RequestHandlerSelectors.basePackage("com.nets.demo.qr.controller")).paths(PathSelectors.any()).build()
				.directModelSubstitute(Calendar.class, String.class).genericModelSubstitutes(ResponseEntity.class)
				.pathProvider(new BasePathAwareRelativePathProvider("/")).host(baseHostname);
	}

	protected String getHost() {
		String host = null;
		try {
			host = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return host;
	}

	class BasePathAwareRelativePathProvider extends AbstractPathProvider {
		private String basePath;

		public BasePathAwareRelativePathProvider(String basePath) {
			this.basePath = basePath;
		}

		@Override
		protected String applicationPath() {
			return "";
		}

		@Override
		protected String getDocumentationPath() {
			return "/";
		}

		@Override
		public String getOperationPath(String operationPath) {
			System.out.println(operationPath);
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");

			return Paths.removeAdjacentForwardSlashes(uriComponentsBuilder.path(operationPath.replaceFirst(basePath, "")).build().toString());
		}
	}

}
