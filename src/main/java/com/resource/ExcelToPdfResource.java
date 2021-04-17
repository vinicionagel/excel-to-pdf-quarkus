package com.resource;

import com.dto.MultipartBody;
import com.service.ExcelToPdfService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/excel-to-pdf")
public class ExcelToPdfResource {

    @Inject
    ExcelToPdfService excelToPdfService;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("aplication/pdf")
    public Response uploadFile(@MultipartForm MultipartBody data) throws IOException {
        return excelToPdfService.excelToPdf(data);
    }
}
