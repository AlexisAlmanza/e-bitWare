package com.bitware.clientes.models;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

public class ObjectResponse  {
	
	private Object data;
	
	private String Cve_Error;
	
	private String Cve_Mensaje;
	
	private HttpStatus status;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getCve_Error() {
		return Cve_Error;
	}

	public void setCve_Error(String cve_Error) {
		Cve_Error = cve_Error;
	}

	public String getCve_Mensaje() {
		return Cve_Mensaje;
	}

	public void setCve_Mensaje(String cve_Mensaje) {
		Cve_Mensaje = cve_Mensaje;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public ObjectResponse(String cve_Error, String cve_Mensaje, HttpStatus status) {
		this.Cve_Error = cve_Error;
		this.Cve_Mensaje = cve_Mensaje;
		this.status = status;
	}

	public ObjectResponse(Cliente data, String cve_Error, String cve_Mensaje, HttpStatus status) {
		this.data = data;
		Cve_Error = cve_Error;
		Cve_Mensaje = cve_Mensaje;
		this.status = status;
	}
	
	public ObjectResponse(Optional<Cliente> data, String cve_Error, String cve_Mensaje, HttpStatus status) {
		this.data = data;
		Cve_Error = cve_Error;
		Cve_Mensaje = cve_Mensaje;
		this.status = status;
	}
	
	
	public ObjectResponse(List<Cliente> data, String cve_Error, String cve_Mensaje, HttpStatus status) {
		this.data = data;
		Cve_Error = cve_Error;
		Cve_Mensaje = cve_Mensaje;
		this.status = status;
	}
	
	

}
