<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>A propos</title>
        <meta charset="UTF-8"/> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Local -->
        <link rel="stylesheet" type="text/css" href="css/styleGrpOUSSAMA.css" />

        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
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
        <div class="container1">
            <div class="left-side">
                <div class="title">
                    About cette application !
                </div>
                <div class="pg">
                    Cette application web a été créée par une équipe d'éudiants de l'Ecole Centrale de Nantes dans le
                    contexte d'un projet de groupe en option Informatique en 2021.Le suivi de l'application a été confiée à la DSI de l'université de Nantes.
                </div>
            </div>
            <div class="right-side">
                <img class="labo" src="images/welcomImg.png" />
            </div>
        </div>

        <footer class="footer">
            <div class="text5"></div>
            <div class="text2"><p class="footer_text"> ©2021 - CRTI - Ecole Centrale Nantes - France </p></div>
            <div class="footer1">
                <div class="about">
                    <c:choose>
                        <c:when test="${empty connectedUser}">
                            <form id="returnForm" action="index.do" method="POST" >
                                <a class="noborder" onclick="document.getElementById('returnForm').submit();"><img class="smallIcon" src="images/back.png" alt="index"/></a>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form id="returnForm" action="welcome.do" method="POST" >
                                <input type="hidden" name="connectionCode" value="${connectedUser.connectionCode}" />
                                <a class="noborder" onclick="document.getElementById('returnForm').submit();"><img class="smallIcon" src="images/back.png" alt="index"/></a>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </footer>

    </body>