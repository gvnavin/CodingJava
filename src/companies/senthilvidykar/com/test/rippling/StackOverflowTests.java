package companies.senthilvidykar.com.test.rippling;

import com.test.rippling.models.Question;
import com.test.rippling.models.User;

public class StackOverflowTests {


    User u1 = new User("user1", "User Name 1");
    User u2 = new User("user2", "User Name 2");
    User u3 = new User("user3", "User Name 3");
    User u4 = new User("user4", "User Name 4");
    Question q1 = new Question("title1", "content1", u1);
    Question q2 = new Question("title2", "content2", u2);
    Question q3 = new Question("", "content2", u1);
    Question q4 = new Question("title", "", u2);
    Question q5 = new Question("title", "content5", u4);

    public void runTests() {
        System.out.println(StackOverflowHandler.getInstance().createQuestion(q1));
        System.out.println(StackOverflowHandler.getInstance().createQuestion(q2));
        System.out.println(StackOverflowHandler.getInstance().listQuestions());
        System.out.println(StackOverflowHandler.getInstance().createQuestion(q3));
        System.out.println(StackOverflowHandler.getInstance().createQuestion(q4));
        System.out.println(StackOverflowHandler.getInstance().createQuestion(q2));
        System.out.println(StackOverflowHandler.getInstance().listQuestions());
        System.out.println(StackOverflowHandler.getInstance().createQuestion(q5));
        System.out.println(StackOverflowHandler.getInstance().listQuestions());
    }

    public static void main(String[] args) {
        StackOverflowTests test = new StackOverflowTests();
        test.runTests();
    }

}
