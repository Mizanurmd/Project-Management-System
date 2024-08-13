package com.cns.psm.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import com.cns.psm.entities.Project;
import com.cns.psm.repositories.ProjectRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProjectReportService {

	@Autowired
	private ProjectRepository proRepo;

	public String exportReport(String reportFromat) throws FileNotFoundException, JRException {
	
		String path = "C:\\Users\\DELL-PC\\Desktop\\Report";
		List<Project> pa = proRepo.findAll();

		// load file and compile
		File file = ResourceUtils.getFile("classpath:Project_Report.jrxml");

		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(pa);

		Map<String, Object> parameter = new HashMap<>();
		parameter.put("Createdby", "MD.Mizanur Rahman");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);

		if (reportFromat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\Project_Report.html");
		}

		if (reportFromat.equalsIgnoreCase("pdf")) {

			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Project_Report.pdf");

		}

		return "Report generated in the path : " + path;
	}

}
