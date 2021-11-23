<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Intranet CRTI</title>
        <meta charset="UTF-8"/> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Local -->
        <link rel="stylesheet" type="text/css" href="css/main.css" />

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
        <ul class="menuBar">
            <li><img id="logo" src="images/logo.png" alt="logo"/></li>
        </ul>

        <div class="connexionInfos">
            <form action="login.do" method="POST">
                <p>Connexion</p>
                <input type="login" name="user" placeholder="Username" /><br/>
                <input type="password" name="passwd" placeholder="Password"/><br/>
                <button id="Valider" class="btn btn-block btn-success btn-sm"><span class="glyphicon glyphicon-ok"></span>Valider</button><br/>
            </form>
        </div>

        <h1 class="headTitle">Intranet CRTI</h1>

        <div class="mainInfos">
            <p>Bienvenue sur l'espace interne des chercheurs de l'université de Nantes</p>
        </div>

        <div class="mainInfos">
            <p>Informations relatives à l'intranet à modifier ?</p>
        </div>

        <div class="about">
            <a href="about.do" class="noborder"><img class="smallIcon" src="images/About.png" alt="about"/></a>
        </div>

    </body>