<%@page import="dao.UserDao"%>  
<jsp:useBean id="u" class="bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>

<%  
    int i=UserDao.update(u);  
    response.sendRedirect("viewusers.jsp");  
%>  