package online.zhaopei.myproject.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import online.zhaopei.myproject.jerseyservice.PersonalEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import online.zhaopei.myproject.jerseyservice.InvtsEndpoint;
import online.zhaopei.myproject.jerseyservice.LoginEndpoint;

@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

	@Value("${spring.jersey.application-path:/maintain/api}")
	private String apiPath;

	public JerseyConfig() {
		this.registerEndpoints();
	}

	@PostConstruct
	public void init() {
		this.configureSwagger();
	}

	private void registerEndpoints() {
		this.register(LoginEndpoint.class);
		this.register(InvtsEndpoint.class);
		this.register(PersonalEndpoint.class);
	}

	private void configureSwagger() {
		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);

		BeanConfig config = new BeanConfig();
		config.setTitle("基于Spring Boot,Jersey, Swagger的Restful API");
		config.setVersion("1.0.0");
		config.setContact("赵配");
//		config.setSchemes(new String[] { "http", "https" });
		config.setSchemes(new String[] { "http" });
		config.setBasePath(this.apiPath);
		config.setResourcePackage("online.zhaopei.myproject.jerseyservice");
		config.setPrettyPrint(true);
		config.setScan(true);
	}

}
