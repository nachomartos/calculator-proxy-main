package com.calculator.soap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.calculator.soap.client.SoapClient;

@Configuration
public class SoapConfig {

	// Esta constante debe tener el mismo valor que el tag generatePackage del
	// pom.xml
	private static final String CONTEXT_PATH = "com.calculator.soap.generated";

	@Value("${service.url}")
	private String serviceUrl;

	/**
	 * Jaxb2Marshaller es una clase de Spring Framework que proporciona una
	 * implementacion del componente marshaller y unmarshaller para trabajar con el
	 * sistema de marshalling/unmarshalling de JAXB (Java Architecture for XML
	 * Binding).
	 * 
	 * En terminos simples, marshalling es el proceso de convertir un objeto Java a
	 * su representacion en XML, mientras que unmarshalling es el proceso inverso:
	 * convertir XML a un objeto Java.
	 * 
	 * @return
	 */
	@Bean
	public Jaxb2Marshaller getMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(CONTEXT_PATH);

		return marshaller;
	}

	@Bean
	public SoapClient getSoapClient(Jaxb2Marshaller marshaller) {
		SoapClient soapClient = new SoapClient();
		soapClient.setDefaultUri(serviceUrl);

		// Indico quien se va a encargar de serializar y deserializar
		soapClient.setMarshaller(marshaller);
		soapClient.setUnmarshaller(marshaller);

		return soapClient;
	}
}