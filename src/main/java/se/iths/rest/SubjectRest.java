package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.exception.NotFoundException;
import se.iths.service.SubjectService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {
    @Inject
    SubjectService subjectService;

    @Path("{id}")
    @GET
    public Response getSubject(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findSubjectById(id);
        return Response.ok(foundSubject).build();
    }

    @Path("")
    @GET
    public Response getAllSubject() {
        List<Subject> foundSubjects = subjectService.getAllSubjects();
        if (foundSubjects == null) {
            throw new NotFoundException("No Subjects Found");
        }
        return Response.ok(foundSubjects).build();
    }
}