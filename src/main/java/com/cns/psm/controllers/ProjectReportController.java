package com.cns.psm.controllers;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cns.psm.services.ProjectReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/v1/reports")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectReportController {
	 
	@Autowired
	private ProjectReportService proRepoServ;

//////Controller for Report generated code here/////////////

	@GetMapping("/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		System.out.println("Pdf is generated-------------------------------");
		return proRepoServ.exportReport(format);

	}

}
