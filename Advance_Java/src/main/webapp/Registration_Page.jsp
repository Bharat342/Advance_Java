
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>

	<%  // NOTE : Scriplet tag
	
	// // To create declaration tag we use "<percentage percentage>"
	// Scriptlet tag has built in implicit object like out, request, response, session
	// we cannot use access specifier inside scriptlet tag
	// Inside Scriptlet tag we cannot create static / non-static variables (Local variables doesn't have access specifier)
	// we cannot use local variable without initialising it
	// we cannot create methods inside scriptlet tag only local variable we can create 
	// we cannot Write HTML Code inside scriptlet tag only java code 
	// HTML should be write outside of the scriptlet tag it cannot be inside the scriptlet tag
	
	// The Advantage of JSP over HTML is that we can write java code inside html code
	// which can help me built some small logic inside HTML itself and that can my make my development bit easier.
	
		// Example :
	
		/* for(int i=1; i<=5; i++) {
			//System.out.println(i);// --> it will print in the console
			out.println(i); // --> it will print in the web
		} */
		
	 	String sharada = "hello my name is Bharat !katti";
		out.println(sharada);
	%>
	
	<%! // NOTE : Declaration tag
	
		// To create declaration tag we use "<percentage+exclamation percentage>"
		// To create static/ non-static variable we use declaration tag 
		// To create methods we use declaration tag 
		// we do not have implicit objects inside declaration (out, request, response, session etc.)
		// we cannot write html code inside declaration tag 
		
		// Example :
		
		public int y = 50;
		public int x = 10; // ----> non-static variable we can create 
		// out.println(x); --- it is giving an error because we cannot use out, request, response, session etc. here
		
		public int test() {
			return x;
		}
		
		// here we can create variables & methods static/ non-static 
		// but order to access this we can use scriptlet tag --> Continue with scriptlet tag
	%>
	<% // Scriptlet tag
		// directly we can access here we can use "out, request, response, session etc.."
		
		out.println(y); // ---> directly we are accessing from declaration tag's 'y' value
		out.println(test()); // ---> directly we are accessing test() from declaration tag
	%>
	
	
	
	
	
	
	
	<%!
		public String a = "testing expression tag a";
		public String b = "testing expression tag b"; // --> non-static variable
		public String test1() {
			return "inside Expression tag";
		}
	%>
	<%=a // NOTE : Expression tag
	
		// To create declaration tag we use "<percentage+equal percentage>"
		// Evaluates an expression and prints the final output to a webpage
		// Here we can wtite oly one statement 
		// Do not terminate the staement with semicolon(;)
	
		// Example : are Below	
	%>
	<%=b %>
	<%=test1() %>
	
</body>
</html>
























