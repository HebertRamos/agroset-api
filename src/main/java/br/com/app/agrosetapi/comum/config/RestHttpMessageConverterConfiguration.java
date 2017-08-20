package br.com.app.agrosetapi.comum.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author Hramos
 */
@EnableWebMvc
@Configuration
public class RestHttpMessageConverterConfiguration  extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(jacksonMessageConverter());

        super.configureMessageConverters(converters);
    }

    public MappingJackson2HttpMessageConverter jacksonMessageConverter() {

        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        // adicionando mapper para o message converter
        messageConverter.setObjectMapper(mapper);

        // desabilitando todas opções de desserialização
        for (DeserializationFeature feat : DeserializationFeature.values()) {
            messageConverter.getObjectMapper().configure(feat, false);
        }

        return messageConverter;

    }
}
