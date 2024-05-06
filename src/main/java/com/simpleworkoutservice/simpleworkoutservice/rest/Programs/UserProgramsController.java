// package com.simpleworkoutservice.simpleworkoutservice.rest.Programs;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import com.simpleworkoutservice.simpleworkoutservice.config.security.authentication.SecurityContext;
// import com.simpleworkoutservice.simpleworkoutservice.entity.Program;
// import com.simpleworkoutservice.simpleworkoutservice.entity.User;
// import com.simpleworkoutservice.simpleworkoutservice.service.ProgramService.ProgramService;

// import java.util.List;

// @RestController
// @RequestMapping("/api/userprograms")
// public class UserProgramsController {

//     private UserProgramService userProgramService;

//     @Autowired
//     public UserProgramsController(UserProgramService userProgramService) {
//         this.userProgramService = userProgramService;

//     }

//     @GetMapping("/user")
//     public List<Program> getPrograms() {

//         User curentUser = SecurityContext.getCurrentUser();

//         List<Program> programs = userProgramService.findAllByUserId(curentUser.getId());

//         if (programs == null) {
//             throw new RuntimeException("No programs found with user id: " + curentUser.getId());
//         }

//         return programs;
//     }

//     @GetMapping("/programs/{id}")
//     public Program getProgramByUserId(@RequestHeader("programId") int programId) {

//         Program program = userProgramService.findById(programId);

//         if (program == null) {
//             throw new RuntimeException("No programs found with program id: " + programId);
//         }

//         return program;
//     }

//     @GetMapping("/programs/current")
//     public Program getCurrentProgram(@RequestHeader("userId") int userId) {

//         if (userId == 0) {
//             throw new RuntimeException("No user Id given: " + userId);
//         }

//         Program program = userProgramService.findCurrentProgram(userId);

//         if (program == null) {
//             throw new RuntimeException("No current program found with userId: " + userId);
//         }

//         return program;
//     }

// }
