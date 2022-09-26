<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Researchers</title>
        <meta charset="UTF-8"/> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Local -->
        <link rel="stylesheet" type="text/css" href="css/styleGrpOUSSAMA.css" />
        <link
            href="https://fonts.googleapis.com/css2?family=Inconsolata:wght@400;600&family=Roboto:wght@100;300;400;500;700&display=swap"
            rel="stylesheet"
            />
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
        <div class="header">
            <%@ include file="header.jspf" %>
        </div>
        <div class="contenu">
            <div class="navbar" style="height: 40px"></div>
            <div class="container">
                <div class="topPart">
                    <h1 class="title">Bienvuenue dans la section d'ajout d'activités</h1>
                    <p class="description">
                        Choisir parmis les activités suivantes. Si vous ne trouvez pas le type
                        correspondant contactez le support.
                    </p>
                </div>

                <div class="activitesPart">
                    <ul>
                        <li>
                            <span> <div>1</div> </span>
                            <form id="Education" action="EducationActivite.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('Education').submit();">
                                        Education
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>2</div> </span>
                            <!--<span><a href="./postdoc.html"> Post doctorat</a></span>-->
                            <form id="PostDoctorat" action="PostDoctorat.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('PostDoctorat').submit();">
                                        Post doctorat
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>3</div> </span>
                            <!--<span><a href="./prix.html"> Prix </a></span>-->
                            <form id="Prix" action="Prix.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('Prix').submit();">
                                        Prix
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>4</div> </span>
                            <!--<span><a href="./patent.html"> Brevet </a></span>-->
                            <form id="Brevet" action="Brevet.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('Brevet').submit();">
                                        Brevet
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>5</div> </span>
                            <!--<span><a href="./production.html"> Production </a></span>-->
                            <form id="Production" action="Production.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('Production').submit();">
                                        Production
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>6</div> </span>
                            <!--<span><a href="./platform.html"> Platform </a></span>-->
                            <form id="Platform1" action="Platform1.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('Platform1').submit();">
                                        Platform
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>7</div> </span>
                            <!--<span><a href="./edition.html"> Edition </a></span>-->
                            <form id="Edition" action="Edition.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('Edition').submit();">
                                        Edition
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>8</div> </span>
                            <!--<span><a href="./review.html"> Revue </a></span>-->
                            <form id="Revue" action="Revue.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('Revue').submit();">
                                        Revue
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>9</div> </span>
                            <!--<span><a href="./publication.html"> Publication </a></span>-->
                            <form id="Publication1" action="Publication1.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('Publication1').submit();">
                                        Publication
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>10</div> </span>
                            <!--<span><a href="./book.html"> Livre </a></span>-->
                            <form id="Livre" action="Livre.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('Livre').submit();">
                                        Livre
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>11</div> </span>
                            <!--<span><a href="./seminaire.html"> Séminaire </a></span>-->
                            <form id="Séminaire" action="Séminaire.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('Séminaire').submit();">
                                        Séminaire
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>12</div> </span>
<!--                            <span
                                ><a href="./communication.html"> Communication orale </a></span
                            >-->
                            <form id="Communication" action="Communication.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('Communication').submit();">
                                        Communication orale
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>13</div> </span>
<!--                            <span
                                ><a href="./contratIndus.html">
                                    Signature d'une contrat industrielle
                                </a></span
                            >-->
                            <form id="contratIndus" action="contratIndus.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('contratIndus').submit();">
                                        Signature d'une contrat industrielle
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>14</div> </span>
<!--                            <span
                                ><a href="./collabInter.html">
                                    Collaboration internationale
                                </a></span
                            >-->
                            <form id="collabInter" action="collabInter.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('collabInter').submit();">
                                        Collaboration internationale
                                    </a>
                                </span>
                            </form>
                        </li>
                        <li>
                            <span> <div>15</div> </span>
                            <!--<span><a href="./expertise.html"> Expertise scientifique </a></span>-->
                            <form id="expertise1" action="expertise1.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('expertise1').submit();">
                                        Expertise scientifique
                                    </a>
                                </span>
                            </form>
                        </li>

                        <li>
                            <span> <div>16</div> </span>
                            <!--<span><a href="./essaiClinique.html"> Essai clinique </a></span>-->
                            <form id="essaiClinique" action="essaiClinique.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('essaiClinique').submit();">
                                        Essai clinique
                                    </a>
                                </span>
                            </form>
                        </li>

                        <li>
                            <span> <div>17</div> </span>
<!--                            <span
                                ><a href="./mobiliteEntrante.html"> Mobilité entrante </a></span
                            >-->
                            <form id="mobiliteEntrante" action="mobiliteEntrante.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('mobiliteEntrante').submit();">
                                        Mobilité entrante
                                    </a>
                                </span>
                            </form>
                        </li>

                        <li>
                            <span> <div>18</div> </span>
<!--                            <span
                                ><a href="./MobiliteSortante.html"> Mobilité sortante </a></span
                            >-->
                            <form id="MobiliteSortante" action="MobiliteSortante.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('MobiliteSortante').submit();">
                                        Mobilité sortante
                                    </a>
                                </span>
                            </form>
                        </li>

                        <li>
                            <span> <div>19</div> </span>
<!--                            <span
                                ><a href="./creationEntreprise.html">
                                    Création d'entreprise
                                </a></span
                            >-->
                            <form id="creationEntreprise" action="creationEntreprise.do" method="GET" >
                                <span>
                                    <a class="lien" onclick="document.getElementById('creationEntreprise').submit();">
                                        Création d'entreprise
                                    </a>
                                </span>
                            </form>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="footer">
            <%@ include file="footer.jspf" %>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
