package com.calculator.soap.client;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.annotation.PostConstruct;

import com.calculator.soap.generated.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {

	@Value("${service.url}")
	private String serviceUrl;

	@Value("${service.url2}")
	private String serviceUrl2;

	private String uri;

	@PostConstruct
	public void init() {

		this.uri = serviceUrl.concat("/NumberConversion.wso");

	}

	/**
	 * https://www.dataaccess.com/webservicesserver/NumberConversion.wso?op=NumberToWords
	 * 
	 * @param value
	 * @return
	 */
	public NumberToWordsResponse getNumberToWordsResponse(BigInteger value) {

		// Se arma el request
		NumberToWords request = new NumberToWords();
		request.setUbiNum(value);

		// SoapActionCallback es una clase en Spring Web Services que se utiliza para
		// definir y enviar la cabecera SOAPAction en una solicitud SOAP.
		// El valor de SOAPAction generalmente es una URL o URI que identifica la
		// operacion SOAP que se esta invocando.
		SoapActionCallback soapActionCallback = new SoapActionCallback(serviceUrl + "/NumberToWords");

		// WebServiceTemplate es una clase de Spring que facilita el envio y recepcion
		// de mensajes SOAP. Proporciona varios metodos para enviar solicitudes a
		// servicios web SOAP y procesar las respuestas. Esto incluye la serializacion
		// (marshalling) y deserializacion (unmarshalling) de objetos Java a/desde
		// mensajes SOAP.
		NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(uri,
				request, soapActionCallback);

		return response;
	}

	/**
	 * https://www.dataaccess.com/webservicesserver/NumberConversion.wso?op=NumberToDollars
	 * 
	 * @param value
	 * @return
	 */
	public NumberToDollarsResponse getNumberToDollarsResponse(BigDecimal value) {

		NumberToDollars request = new NumberToDollars();
		request.setDNum(value);

		SoapActionCallback soapActionCallback = new SoapActionCallback(serviceUrl + "/NumberToDollars");

		NumberToDollarsResponse response = (NumberToDollarsResponse) getWebServiceTemplate().marshalSendAndReceive(uri,
				request, soapActionCallback);

		return response;
	}

	public AddResponse getAddResponse(int valueA, int valueB) {

		Add request = new Add();
		request.setIntA(valueA);
		request.setIntB(valueB);

		SoapActionCallback soapActionCallback = new SoapActionCallback(serviceUrl2 + "/Add");

		AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request, soapActionCallback);

		return response;
	}

	public SubtractResponse getSubtractResponse(int valueA, int valueB) {

		Subtract request = new Subtract();
		request.setIntA(valueA);
		request.setIntB(valueB);

		SoapActionCallback soapActionCallback = new SoapActionCallback(serviceUrl2 + "/Subtract");

		SubtractResponse response = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request, soapActionCallback);

		return response;
	}

	public MultiplyResponse getMultiplyResponse(int valueA, int valueB) {

		Multiply request = new Multiply();
		request.setIntA(valueA);
		request.setIntB(valueB);

		SoapActionCallback soapActionCallback = new SoapActionCallback(serviceUrl2 + "/Multiply");

		MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request, soapActionCallback);

		return response;
	}

	public DivideResponse getDivideResponse(int valueA, int valueB) {

		Divide request = new Divide();
		request.setIntA(valueA);
		request.setIntB(valueB);

		SoapActionCallback soapActionCallback = new SoapActionCallback(serviceUrl2 + "/Divide");

		DivideResponse response = (DivideResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request, soapActionCallback);

		return response;
	}
}