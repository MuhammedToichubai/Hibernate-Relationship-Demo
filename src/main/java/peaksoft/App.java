package peaksoft;

import peaksoft.enums.Gender;
import peaksoft.models.Post;
import peaksoft.models.Profile;
import peaksoft.models.User;
import peaksoft.service.PostService;
import peaksoft.service.ProfileService;
import peaksoft.service.UserService;
import peaksoft.service.impl.PostServiceImpl;
import peaksoft.service.impl.ProfileServiceImpl;
import peaksoft.service.impl.UserServiceImpl;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProfileService profileService = new ProfileServiceImpl();
        PostService postService = new PostServiceImpl();
//        userService.save(
//                User.builder()
//                        .username("mukhammedaly")
//                        .email("mukhammed@gmail.com")
//                        .password("MyPassword")
//                        .profile(
//                                new Profile(
//                                        "Mukhammedaly",
//                                        LocalDate.of(2005, 1, 14),
//                                        Gender.MALE,
//                                        "programmer"
//                                )
//                        )
//                        .build()
//        );
//        userService.deleteById(3L);

//        userService.save(
//                User.builder()
//                        .username("aibek")
//                        .email("aibek@gmail.com")
//                        .password("MyPassword")
//                        .build()
//        );

//        Profile profile = new Profile(
//                "Aibek Duisho uulu",
//                LocalDate.of(2005, 1, 14),
//                Gender.MALE,
//                "programmer"
//        );
//        profileService.saveProfile(1L, profile);

//        System.out.println(profileService.deleteById(2L));


//        System.out.println(userService.findById(1L));

//        String saved = postService.save(Post.builder()
//                .imageURl("https://sadkjrwlej4rlsjdf")
//                .description("description 3")
//                .build());
//        System.out.println(saved);

//       postService.assignPostToUser(2L, 1L);
//       postService.assignPostToUser(3L, 1L);

//        String s = postService.deleteById(1L);
//        System.err.println(s);

        userService.deleteById(1L);


    }
}
