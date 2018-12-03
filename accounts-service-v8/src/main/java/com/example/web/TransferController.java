package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.TransferService;

@Controller
public class TransferController {

	@Autowired
	private TransferService transferService;

	@PostMapping(value = "/txr", consumes = { "application/xml","application/json" }, produces = { "application/xml","application/json" })
	public @ResponseBody TxrResponse doTxr(@RequestBody TxrRequest request) {
		boolean b = transferService.transfer(request.getAmount(), request.getFromAccNum(), request.getToAccNum());

		TxrResponse response = new TxrResponse();
		if (b)
			response.setMessage("Txr successful");

		return response;
	}

}
