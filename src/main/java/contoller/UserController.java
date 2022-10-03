package contoller;

import dto.CreateUserRequest;
import dto.UpdateUserRequest;
import exception.UserDoesNotExistException;
import service.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/v1/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @POST
    public Response createUser(@Valid CreateUserRequest createUserRequest) {
        return Response.ok(userService.createUser(createUserRequest))
                .build();
    }

    @GET
    @Path("{id}")
    public Response getUser(@PathParam("id") Long id) {
        try {
            return Response.ok(userService.findUserById(id))
                    .build();
        } catch (UserDoesNotExistException e) {
            return Response
                    .status(404, e.getMessage())
                    .build();
        }

    }

    @GET
    public Response getAllUsers() {
        return Response.ok(userService.getAllUser())
                .build();
    }


    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        try {


            return Response.ok(userService.deleteUser(id))
                    .build();
        } catch (UserDoesNotExistException e) {
            return Response
                    .status(404, e.getMessage())
                    .build();
        }
    }

//    @PATCH
//    @Path("{id}")
//    public UserDto updateUser(@PathParam("id") Long id, UpdateUserRequest updateUserRequest) throws UserDoesNotExistException {
//        return userService.updateUserDetails(id, updateUserRequest);
//    }

    @PATCH
    @Path("{id}")
    public Response updateUser(@PathParam("id") Long id, @Valid UpdateUserRequest updateUserRequest) {
        try {


            return Response.ok(userService.updateUserDetails(id, updateUserRequest))
                    .build();

        } catch (UserDoesNotExistException e) {
            return Response
                    .status(404, e.getMessage())
                    .build();
        }
    }


}
