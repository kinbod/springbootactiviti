package org.activiti.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.easeu.easeuoa.ui.InMemoryMessageRespository;
import com.easeu.easeuoa.ui.Message;
import com.easeu.easeuoa.ui.MessageRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableWebMvc
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	@Bean
	public MessageRepository messageRepository() {
		return new InMemoryMessageRespository();
	}

	@Bean
	public Converter<String, Message> messageConverter() {
		return new Converter<String, Message>() {
			@Override
			public Message convert(String id) {
				return messageRepository().findMessage(Long.valueOf(id));
			}
		};
	}

	/*@Bean
	InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {

		return new InitializingBean() {
			public void afterPropertiesSet() throws Exception {

				Group group = identityService.newGroup("user");
				group.setName("users");
				group.setType("security-role");
				identityService.saveGroup(group);

				User admin = identityService.newUser("admin");
				admin.setPassword("admin");
				identityService.saveUser(admin);

			}
		};
	}*/

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
