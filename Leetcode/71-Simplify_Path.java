import java.util.ArrayList;
import java.util.List;

class SimplifyPath{
    /**
    clairfications
        - always begins with a slash?
            - root is just slash? 
        - path is not null?
        - /../? cannot go back so just simplig to /
        - garuantee that names in path are indeed seperated
            by slashes? 

    approaches
        - string parsing. we crete a res string and iterate through that
            w nest loops for period, slash, different cases
            verbose
        - create an arreay using .split() by the slashes
            so well have a list of directory/file names, dots
            multiple slashes will be just empty edlements, so easy to exclude

            iterate throuhg the list w a stack. 
                name --> add element
                . --> skip
                .. --> pop last element
                "" --> skip
            
            iterate though stack and build final string w /

            time: O(n)
            space: O(n)

        tests
            - .., ., ///, 
            - single /
            - /../ -> /
     */

     public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> s = new Stack<>();

        for(String part : parts){
            if(part.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }else if(!part.equals("") && !part.equals(".")){
                s.push(part);
            }
        }

        StringBuilder res = new StringBuilder();

        Iterator<String> iter = s.iterator();

        while(iter.hasNext()){
            res.append("/");
            String curr = iter.next();
            res.append(curr);
        }

        if(res.isEmpty()){return "/";}
        return res.toString();
    }
}