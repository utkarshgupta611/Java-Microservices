package com.ust.cartStatus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service("status")
@Component
public class Status {

	@Value("${cartStatus.statusNE}")
	private String statusNe;
	
	@Value("${cartStatus.statusE}")
	private  String emptystatus;

	public String getStatusNe() {
		return statusNe;
	}

	public void setStatusNe(String statusNe) {
		this.statusNe = statusNe;
	}

	public String getEmptystatus() {
		return emptystatus;
	}

	public void setEmptystatus(String emptystatus) {
		this.emptystatus = emptystatus;
	}

	public Status() {
	}

	public Status(String statusNe, String emptystatus) {
		super();
		this.statusNe = statusNe;
		this.emptystatus = emptystatus;
	}	
	}
	
	

