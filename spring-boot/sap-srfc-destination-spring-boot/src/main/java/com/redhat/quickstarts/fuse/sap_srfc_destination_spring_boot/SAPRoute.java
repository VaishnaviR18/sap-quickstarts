package com.redhat.quickstarts.fuse.sap_srfc_destination_spring_boot;

import org.apache.camel.builder.RouteBuilder;

import org.springframework.stereotype.Component;

/**
 * Here is an example route which builds a request to the GetList method of the FlightCustomer BAPI
 * to retrieve the list of Flight Customers within an SAP System. The request is sent to SAP via a
 * synchronous RFC endpoint to the BAPI method which also receives back a response containing
 * the list of Flight Customers.
 */
@Component
public class SAPRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer://init?repeatCount=1")
				.to("bean:request")
				.log("${body}")
				.to("sap-srfc-destination:quickstartDest:BAPI_FLCUST_GETLIST");
	}
}
