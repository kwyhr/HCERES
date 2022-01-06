<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Activities</title>
        <meta charset="UTF-8"/> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Local -->
        <link rel="stylesheet" type="text/css" href="css/styleGrpOUSSAMA.css" />

        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
        <script type="text/javascript" src="js/localdata.js"></script>

        <!-- Bootstrap -->
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <!-- Datatable -->
        <link rel="stylesheet" type="text/css" href="DataTables/css/jquery.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="DataTables/css/buttons.dataTables.css">
        <link rel="stylesheet" type="text/css" href="DataTables/css/responsive.dataTables.min.css">
        <link rel="stylesheet" type="text/css" href="DataTables/css/rowReorder.dataTables.min.css">
        <script type="text/javascript" src="DataTables/js/jquery.dataTables.js" ></script>
        <script type="text/javascript" src="DataTables/js/dataTables.buttons.js"></script>
        <script type="text/javascript" src="DataTables/js/buttons.html5.js"></script>
        <script type="text/javascript" src="DataTables/js/buttons.print.js"></script>
        <script type="text/javascript" src="DataTables/js/dataTables.select.js"></script>
        <script type="text/javascript" src="DataTables/js/dataTables.responsive.min.js"></script>
        <script type="text/javascript" src="DataTables/js/dataTables.rowReorder.min.js"></script>
    </head>
    <body>
        <%@ include file="header.jspf" %>

        <h1 class="headTitle">Liste des activités</h1> 

        <main id="pagecontent" class="row" >

            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><br/></div>

            <c:forEach var="typeActivity" items="${listActivities}">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h3>${typeActivity.nameType}</h3> 
                </div> 
            </c:forEach>
        </main>

        <%@ include file="footer.jspf" %>

    </body>
</html>

