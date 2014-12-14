package by.dreamteam.businessservices.entities;

import java.util.List;

/**
 * @author dkaganovich
 * @version 1.0
 * @created 06-Dec-2014 3:35:03 PM
 */
public class ReportList {

    private final List<Report> reportList;

    public ReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    public List<Report> getReportList() {
        return reportList;
    }
}//end ReportList
