package com.service;

import com.dto.MultipartBody;
import com.spire.xls.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.MessageFormat;

@Named
@RequestScoped
public class ExcelToPdfService implements Serializable {

    public Response excelToPdf(MultipartBody data) throws IOException {
        Workbook workbook = new Workbook();
        workbook.loadFromStream(data.getFile());
        workbook.getConverterSetting().setSheetFitToPage(true);
        File pdf = File.createTempFile("tempfile", ".pdf");
        workbook.saveToFile(pdf.getAbsolutePath(), FileFormat.PDF);
        Response.ResponseBuilder response = Response.ok(pdf);
        response.header("Content-Disposition", MessageFormat.format("attachment; filename={0}.pdf", data.getFileName()));
        return response.build();
    }
}
