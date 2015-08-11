package lesson10.lab10.prob2.bugreporter;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import lesson10.lab10.prob2.classfinder.ClassFinder;

/**
 * This class scans the package lesson10.lab10.prob2.javapackage
 * for classes with annotation @BugReport. It then generates a bug report
 * bugreport.txt, formatted like this:
 * 
 * Joe Smith
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 * Tom Jones
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 * 
 *
 */
public class BugReportGenerator {
	private static final Logger LOG = Logger.getLogger(BugReportGenerator.class.getName());
	private static final String PACKAGE_TO_SCAN = "lesson10.lab10.prob2.javapackage";
	private static final String REPORT_NAME = "bug_report.txt";
	private static final String REPORTED_BY = "reportedBy: ";
	private static final String CLASS_NAME = "classname: ";
	private static final String DESCRIPTION = "description: ";
	private static final String SEVERITY = "severity: ";
	public void reportGenerator() {
		List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);
		//implement
		Map<String, List<String>> bugReportMap = new HashMap<String, List<String>>();

		buildReportMap(classes, bugReportMap);

		writeToFile(bugReportMap);

	}

	private void writeToFile(Map<String, List<String>> bugReportMap) {
		try (PrintWriter writer = new PrintWriter(REPORT_NAME)) {
			for (Map.Entry<String, List<String>> entry : bugReportMap.entrySet()) {

				List<String> reports = entry.getValue();
				writer.write(entry.getKey());
				writer.write(System.lineSeparator());
				for (String report : reports) {
					writer.write(report);
					writer.write(System.lineSeparator());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void buildReportMap(List<Class<?>> classes, Map<String, List<String>> bugReportMap) {
		List<String> list = null;

		for (Class<?> cls : classes) {
			Annotation[] bugReportAnnotations = cls.getAnnotations();

			for (int i = 0; i < bugReportAnnotations.length; i++) {
				BugReport bugReport = (BugReport) bugReportAnnotations[i];
				list = bugReportMap.get(bugReport.assignedTo());

				if (list == null) {
					list = new ArrayList<String>();
				}

				list.add("\t" + REPORTED_BY + bugReport.reportedBy());
				list.add("\t" + CLASS_NAME + cls.getCanonicalName());
				list.add("\t" + DESCRIPTION + bugReport.description());
				list.add("\t" + SEVERITY + bugReport.severity() + System.lineSeparator());
				bugReportMap.put(bugReport.assignedTo(), list);
			}
		}
	}
}
