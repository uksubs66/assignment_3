package assignment_3;

/*
 * William Hawkins
 * Assignment 3
 * ICS 372
 * 6/4/2015
 */

public class Assignment_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PushbackableTokenizer pushbackTokenizer = new PushbackTokenizer("Hello this is a test");

        System.out.println(pushbackTokenizer.nextToken());

        //will print “Hello”
        System.out.println(pushbackTokenizer.nextToken());

        //will print “this”
        System.out.println(pushbackTokenizer.nextToken());

        //will print “is”
        pushbackTokenizer.pushback(); // pushes back “is”
        pushbackTokenizer.pushback(); // pushes back “this”

        //Now
        System.out.println(pushbackTokenizer.nextToken());

        //will print “this”
        //The next
        System.out.println(pushbackTokenizer.nextToken());

        //will print “is”
        System.out.println(pushbackTokenizer.nextToken());

        //will print “a”
        System.out.println(pushbackTokenizer.nextToken());

        //will print “test”
        pushbackTokenizer.pushback(); // pushes back “test”
        pushbackTokenizer.pushback(); // pushes back “a”

        System.out.println(pushbackTokenizer.nextToken());

        //will print “a”
        System.out.println(pushbackTokenizer.nextToken());

    }

}
