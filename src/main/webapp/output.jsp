<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="org.dom4j.bean.BeanElement"%>
<%@ page language="java" import = "com.youtube.rest.PersonInfo" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="personinfo" scope="page" class="com.youtube.rest.PersonInfo"/>
<jsp:setProperty property="firstname" name="personinfo" param="firstname"/>
<jsp:setProperty property="lastname" name="personinfo" param="lastname"/>




<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.util.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.PrintStream" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.io.FileInputStream" %>

<%@ page import="org.dom4j.Document" %>
<%@ page import="org.dom4j.DocumentException" %>
<%@ page import="org.dom4j.DocumentHelper" %>
<%@ page import="org.dom4j.Element" %>
<%@ page import="org.dom4j.Node" %>
<%@ page import="org.dom4j.io.SAXReader" %>
<%@ page import="org.dom4j.io.XMLWriter" %>


<%



	String fn = request.getParameter("firstname");
	String ln = request.getParameter("lastname");
	
	File file = new File("beans.xml");
	
	//PrintStream ps = null;
	//ps = new PrintStream(new FileOutputStream(file));
	//ps.println(fn);
	//ps.println(ln);
	//ps.close();//
	
	Document XMLDoc = DocumentHelper.createDocument();
	//XMLDoc.addDocType("beans", "-//SPRING//DTD BEAN//EN",  
            //"http://www.springframework.org/dtd/spring-beans.dtd");
	
	
	
	Element beansEle = XMLDoc.addElement("beans","http://www.springframework.org/schema/beans");
	beansEle.addAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
	beansEle.addAttribute("xsi:schemaLocation", "http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd");
	
	
	
	Element beanName  = beansEle.addElement("bean").addAttribute("id", "person_info")  
            .addAttribute("class", "com.innovatis.Person_Info");

	Element propertyfirstname = beanName.addElement("property")  
            .addAttribute("name", "first_name").addAttribute("value", fn);  
 //   Element valuefirstname= beanName.addElement("value")  
            //.addText(fn);//  
    Element propertylastname = beanName.addElement("property")  
            .addAttribute("name", "last_name").addAttribute("value", ln) ;
  //  Element valuelastname = beanName.addElement("value")  
           // .addText(ln);
    
    XMLWriter outXML = new XMLWriter(new FileWriter(file));
    outXML.write(XMLDoc);
    outXML.close();
    
  
    
%>

<% %>
<br>
First Name:<%=personinfo.getFirstname()%>
<br>
Last Name:<%=personinfo.getLastname()%>

<form action="confirm.jsp" method ="get">

<input type="submit" value="Confirm">

</form>

</body>

</html>