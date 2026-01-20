package com.example.demo.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.mapper.CoreMapper;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final CoreMapper mapper = new CoreMapper();

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.stream().filter(c -> c instanceof MappingJackson2HttpMessageConverter)
				.map(c -> (MappingJackson2HttpMessageConverter) c).forEach(c -> c.setObjectMapper(mapper));
	}
}