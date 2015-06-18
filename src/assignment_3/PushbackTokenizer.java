

package assignment_3;


import java.util.*;
import java.util.StringTokenizer;

/**
 * PushbackTokenizer implements PushbackableTokenizer using the Adapter pattern
 */

public class PushbackTokenizer implements PushbackableTokenizer {

    Stack<String> holder;
    Stack<String> mainStack;
    /**
    * Constructor takes a String arguments and passes it to StringTokenier to be
    * divided up and pushed on to two stacks so that it is indexed in the proper order
    * @param this string will be tokenized and passed to holder stack
    * then passed to mainStack
    */

    public PushbackTokenizer (String data) {
        this.holder = new Stack<String>();
        this.mainStack = new Stack<String>();        
        StringTokenizer token = new StringTokenizer(data, " ");
        
        assert !data.equals(""):"data entered was empty string";
        
        while (token.hasMoreElements()) {
            holder.push((String) token.nextElement());
        }
        assert !holder.empty():"Empty stack! Constuctor argument contains only tokenizers";
        
        while (!holder.isEmpty()) {
            mainStack.push(holder.pop());
        }
        
    }
    
    /**
    * Pops the top element of the mainStack then returns the top of the holder stack 
    * which is equal to the element popped off mainStack
    * @returns the top element of holder stack
    */
    public String nextToken() {
        assert hasMoreTokens():"mainStack is empty";
        
        String mainPop = mainStack.peek(); //String to store element to be poped off stack
        
        holder.push(mainStack.pop());
        
        assert holder.peek().equals(mainPop):"Top of holder not equal to mainStack pop";
        
        return holder.peek();
    }
    
    /**
    * Checks if the mainStack is not empty
    * @returns a true is stack is not empty
    */
    public boolean hasMoreTokens() {
        assert mainStack.peek() != null:"Checking empty Stack";
        return !mainStack.isEmpty();
    }
    
    /**
    * Pops the top element off the holder stack back on the main Stack
    */
    public void pushback() {
        String holdPop = holder.peek();   //String to hold element being popped off
        
        mainStack.push(holder.pop());
        
        assert mainStack.peek().equals(holdPop):"Element on top of mainStack stack"
                + " does not equal element pop off holder";
    }
}