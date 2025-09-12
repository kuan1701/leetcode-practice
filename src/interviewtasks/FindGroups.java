package interviewtasks;

import java.util.List;
import java.util.stream.Stream;

public class FindGroups {
  public static void main(String[] args) {
    Group group1 = new Group("xgroup1", "desc1");
    Group group2 = new Group("group1", "desc2");
    Group group3 = new Group("xgroup1", "desc3");
    Group group4 = new Group("group1", "desc4");
    Group group5 = new Group("xgroup1", "desc5");

    User user1 = new User("user1", 10, List.of(group1, group2, group3, group4, group5));
    User user2 = new User("user2", 13, List.of(group2));
    User user3 = new User("user3", 11, List.of(group5));

    Stream<User> userStream = Stream.of(user1, user2, user3);

    List<User> userList = userStream
        .filter(user -> user.groups.stream()
            .anyMatch(group -> group.name.startsWith("x")))
        .toList();

    userList.forEach(user -> System.out.println(user.username));
  }

  static class User {
    private final String username;
    private int age;
    private List<Group> groups;

    public User(String username, int age, List<Group> groups) {
      this.username = username;
      this.age = age;
      this.groups = groups;
    }
  }

  static class Group {
    private final String name;
    private String description;

    public Group(String name, String description) {
      this.name = name;
      this.description = description;
    }
  }
}