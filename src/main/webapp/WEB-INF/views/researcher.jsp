<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Researcher Informations</title>
        <meta charset="UTF-8"/> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Local -->
        <link rel="stylesheet" type="text/css" href="css/main.css" />

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

        <h1 class="headTitle">Création / Modification chercheur</h1> 

        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><br/></div>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <form action="newChercheur.do" method="POST">
                <table align="center"> 
                    <tr>
                        <td>Nom</td> 
                        <td><input type="text" name="nameResearcher" placeholder="Nom" value="<c:if test='${! empty researcher}'>${researcher.researcherName}</c:if>"/></td> 
                        </tr> 

                        <tr>
                            <td>Prénom</td> 
                            <td><input type="text" name="surnameResearcher" placeholder="Prénom" value="<c:if test='${! empty researcher}'>${researcher.researcherSurname}</c:if>"/></td> 
                        </tr> 

                        <tr>
                            <td>E-mail</td> 
                            <td><input type="text" name="emailAddress" value="<c:if test='${! empty researcher}'>${researcher.researcherEmail}</c:if>"/></td> 
                        </tr>

                        <tr>
                            <td>Numéro ORCID</td> 
                            <td><input type="text" name="idOrcidResearcher" placeholder="ORCID"  value="<c:if test='${! empty researcher}'>${researcher.researcherOrcid}</c:if>"/></td> 
                        </tr> 

                        <tr>
                            <td>Nom de l'employeur (*)</td> 
                            <td>
                            <c:choose>
                                <c:when test="${empty researcher}"><c:set var="currentContract" value="" /></c:when>
                                <c:otherwise><c:set var="currentContract" value="${researcher.currentContract}" /></c:otherwise>
                            </c:choose>

                            <select name="idEmployer" id="idEmployer">
                                <option value="-1">Inconnu</option>
                                <c:forEach var="employer" items="${listEmployer}">
                                    <c:choose>
                                        <c:when test="${empty currentContract}"><option value="${employer.idEmployer}">${employer.nameEmployer}</option></c:when>
                                        <c:when test="${employer.idEmployer == currentContract.idContract}"><option value="${employer.idEmployer}" selected="selected">${employer.nameEmployer}</option></c:when>
                                        <c:otherwise><option value="${employer.idEmployer}">${employer.nameEmployer}</option></c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>Statut</td>
                        <td>
                            <select name="Statut" id="statut">
                                <option value="-1">Inconnu</option>
                                <c:forEach var="status" items="${listStatus}">
                                    <c:choose>
                                        <c:when test="${empty currentContract}"><option value="${status.idStatus}">${status.nameStatus}</option></c:when>
                                        <c:when test="${status.idStatus == currentContract.idStatus}"><option value="${status.idStatus}" selected="selected">${status.nameStatus}</option></c:when>
                                        <c:otherwise><option value="${status.idStatus}">${status.nameStatus}</option></c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td> 
                    </tr>

                    <tr>
                        <td>Type de contrat</td>
                        <td>
                            <select name="contractType">
                                <option value="CDD" selected="selected">CDD</option> 
                                <option value="CDI" >CDI</option> 
                            </select> 
                        </td> 
                    </tr>

                    <tr>
                        <td>Laboratoire</td>
                        <td>
                            <c:choose>
                                <c:when test="${empty researcher}"><c:set var="currentLab" value="" /></c:when>
                                <c:otherwise><c:set var="currentLab" value="${researcher.currentLaboratory}" /></c:otherwise>
                            </c:choose>

                            <select name="laboratory" id="laboratory">
                                <option value="-1">Inconnu</option>
                                <c:forEach var="laboratory" items="${listLaboratories}">
                                    <c:choose>
                                        <c:when test="${empty currentLab}"><option value="${laboratory.laboratoryId}">${laboratory.laboratoryName}</option></c:when>
                                        <c:when test="${laboratory.laboratoryId == currentLab.laboratoryId}"><option value="${laboratory.laboratoryId}" selected="selected">${laboratory.laboratoryName}</option></c:when>
                                        <c:otherwise><option value="${laboratory.laboratoryId}">${laboratory.laboratoryName}</option></c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td> 
                    </tr>

                    <tr>
                        <td>Equipe</td>
                        <td>
                            <c:choose>
                                <c:when test="${empty researcher}"><c:set var="currentTeam" value="" /></c:when>
                                <c:otherwise><c:set var="currentTeam" value="${researcher.currentBelongsTeam}" /></c:otherwise>
                            </c:choose>

                            <select name="team" id="team">
                                <option value="-1">Inconnu</option>
                                <c:forEach var="team" items="${listTeams}">
                                    <c:choose>
                                        <c:when test="${empty currentTeam}"><option value="${team.teamId}">${team.teamName}</option></c:when>
                                        <c:when test="${empty currentTeam.teamId}"><option value="${team.teamId}">${team.teamName}</option></c:when>
                                        <c:when test="${team.teamId == currentTeam.teamId.teamId}"><option value="${team.teamId}" selected="selected">${team.teamName}</option></c:when>
                                        <c:otherwise><option value="${team.teamId}">${team.teamName}</option></c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td> 
                    </tr>

                    <tr>
                        <td>Fonction</td> 
                        <td><input type="text" name="function"/></td> 
                    </tr>

                    <tr id="phdData">
                        <td colspan="2"><hr/></td>
                    </tr>

                    <tr>
                        <td colspan="2">Informations pour les doctorants</td>
                    </tr>

                    <tr>
                        <td>Date de démarrage</td> 
                        <td><input type="text" name="phdStart"/></td> 
                    </tr>

                    <tr>
                        <td>Date soutenance (si connue)</td> 
                        <td><input type="text" name="phdDefense"/></td> 
                    </tr>

                    <tr>
                        <td>Type</td> 
                        <td>
                            <select name="phdType" id="phdType">
                                <option value="-1">Inconnu</option>
                                <c:forEach var="phdType" items="${listPhdType}">
                                    <c:choose>
                                        <c:when test="${empty phdstudent}"><option value="${phdType.phdTypeId}">${phdType.phdTypeName}</option></c:when>
                                        <c:when test="${empty phdstudent.phdTypeId}"><option value="${phdType.phdTypeId}">${phdType.phdTypeName}</option></c:when>
                                        <c:when test="${phdType.phdTypeId == phdstudent.phdTypeId.phdTypeId}"><option value="${phdType.phdTypeId}" selected="selected">${phdType.phdTypeName}</option></c:when>
                                        <c:otherwise><option value="${phdType.phdTypeId}">${phdType.phdTypeName}</option></c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td> 
                    </tr>

                    <tr>
                        <td>Encadrants</td> 
                        <td></td>
                    </tr>

                    <!--
                    <tr>
                        <td>Encordrez vous un doctorant?</td> 
                        <td><input type="radio" name="encadreDoct" value="Oui"/>Oui
                            <input type="radio" name="encadreDoct" value="Non" />Non 
                        </td> 
                    </tr> 
                    
                    <tr>
                        <td> Si oui, indique de qui il s'agit</td>
                        <td>
                        <select name="Quel_doctorant">
                                <option value="Nom_doctorant_1" selected="selected">Nom_doctorant_1</option> 
                                <option value="Nom_doctorant_2">Nom_doctorant_1</option> 
                                <option value="Nom_doctorant_3">Nom_doctorant_3</option> 
                        </select> 
                        </td>     
                    </tr> 
                    -->

                    <tr>
                        <td> </td>
                        <td align="right"><input type="submit" value="Valider"/></td> 
                    </tr> 
                </table> 

                <input type="hidden" name="idResearcher" value="<c:choose><c:when test="${! empty researcher}">${researcher.researcherId}</c:when><c:otherwise>-1</c:otherwise></c:choose>" />
                    </form>
                </div>
        <%@ include file="footer.jspf" %>

    </body>
</html>