<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
  <%@ include  file="taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
 
   login  :  ${user.username }
   
   
    les roles 
    
    <ul>
      <c:forEach items="${user.roles}" var="role">
      <li> ${role} </li>
     </c:forEach>
    </ul>
  
  
</body>
</html>