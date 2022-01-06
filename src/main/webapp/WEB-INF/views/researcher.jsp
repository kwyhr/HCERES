<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Researcher Informations</title>
        <meta charset="UTF-10"/> 
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

        <h1 class="headTitle">Création / Modification chercheur</h1> 
            <c:choose>
                <c:when test="${empty researcher}"><c:set var="currentContract" value="" /></c:when>
                <c:otherwise><c:set var="currentContract" value="${researcher.currentContract}" /></c:otherwise>
            </c:choose>

        <form class="chercheurForm" action="newChercheur.do" method="POST">
            <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <label for="nameResearcher" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Nom</label> 
                <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
                    <input type="text" class="form-control" name="nameResearcher" placeholder="Nom" value="<c:if test='${! empty researcher}'>${researcher.researcherName}</c:if>"/>
                    </div> 
                </div>

                <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <label for="surnameResearcher" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Prénom</label> 
                    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
                        <input type="text" class="form-control"  name="surnameResearcher" placeholder="Prénom" value="<c:if test='${! empty researcher}'>${researcher.researcherSurname}</c:if>"/>
                    </div> 
                </div>

                <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <label for="emailAddress" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">E-mail</label> 
                    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
                        <input type="text" class="form-control"  name="emailAddress" value="<c:if test='${! empty researcher}'>${researcher.researcherEmail}</c:if>"/>
                    </div> 
                </div>

                <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <label for="author" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Numéro ORCID</label> 
                    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 "><input type="text" class="form-control"  name="idOrcidResearcher" placeholder="ORCID"  value="<c:if test='${! empty researcher}'>${researcher.researcherOrcid}</c:if>"/>
                    </div> 
                </div>

                <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <label for="nationality" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Nationalité</label> 
                    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
                    <c:if test="${! empty researcher}">
                        <c:set var="nbNat" value="0" />
                        <c:forEach var="nationality" items="${researcher.nationalityCollection}">
                            <c:if test="${nbNat!=0}">, </c:if>
                            ${nationality.nationalityName}
                            <c:set var="nbNat" value="1" />
                        </c:forEach>
                        <c:if test="${nbNat!=0}"><br/></c:if>
                    </c:if>
                    <select name="nationality" multiple size="5" class="fullsize">
                        <c:forEach var="nationality" items="${listNationalities}">
                            <c:choose>
                                <c:when test="${empty researcher}"><option value="${nationality.nationalityId}">${nationality.nationalityName}</option></c:when>
                                <c:otherwise><c:set var="nbNat" value="0" />
                                    <c:forEach var="nationality2" items="${researcher.nationalityCollection}">
                                        <c:if test="${nationality.nationalityId == nationality2.nationalityId}">
                                            <c:set var="nbNat" value="1" />
                                        </c:if>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${nbNat==1}"><option value="${nationality.nationalityId}" selected="selected">${nationality.nationalityName}</option></c:when>
                                        <c:otherwise><option value="${nationality.nationalityId}">${nationality.nationalityName}</option></c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div> 
            </div>

            <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <label for="idEmployer" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Nom de l'employeur</label> 
                <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
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
                </div>
            </div>

            <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <label for="Statut" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Statut</label>
                <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
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
                </div> 
            </div>

            <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <label for="contractType" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Type de contrat</label>
                <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
                    <select name="contractType">
                        <option value="CDD" selected="selected">CDD</option> 
                        <option value="CDI" >CDI</option> 
                    </select> 
                </div> 
            </div>

            <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <label for="laboratory" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Laboratoire</label>
                <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
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
                </div> 
            </div>

            <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <label for="team" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Equipe</label>
                <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
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
                </div> 
            </div>

            <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <label for="function" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Fonction</label> 
                <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 "><input type="text" name="function"/>
                </div> 
            </div>

            <c:if test="${(connectedUser.connectionStatus == 1) or ((! empty connectedUser.researcherId) and (! empty researcher) and (connectedUser.researcherId.researcherId == researcher.researcherId))}">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><hr/></div>
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h3>Informations pour la connexion</h3>
                </div>

                <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <label for="loginResearcher" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Login</label> 
                    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
                        <input type="text" class="form-control" name="loginResearcher" placeholder="login" value="<c:if test='${! empty researcher}'>${researcher.researcherLogin}</c:if>"/>
                        </div> 
                    </div>

                    <label for="passwordResearcher" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Password</label> 
                    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
                        <input type="text" class="form-control" name="passwordResearcher" placeholder="password" value=""/>
                    </div> 
                </div>
        </c:if>

        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><hr/></div>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <h3>Informations pour les doctorants</h3>
        </div>

        <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <label for="phdStart" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Date de démarrage</label> 
            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 "><input type="text" class="form-control"  name="phdStart"/>
            </div> 
        </div>

        <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <label for="phdDefense" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Date soutenance (si connue)</label> 
            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 "><input type="text" class="form-control"  name="phdDefense"/>
            </div> 
        </div>

        <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <label for="phdType" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Type</label> 
            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
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
            </div> 
        </div>

        <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 required">Encadrants</label> 
            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 ">
            </div>
        </div>

        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><br/></div>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <h3>Activités</h3>
        </div>


        <c:forEach var="typeActivity" items="${listTypeActivities}">
            <c:set var="curActivity" value="${listActivities.get(typeActivity.idTypeActivity)}" />
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">${typeActivity.nameType}</div>
            <c:forEach var="activity" items="${curActivity}">
                <c:set var="curInfos" value="${activity.infos}" />
                <c:forEach var="info" items="${curInfos.keySet()}">
                    <c:if test="${info != 'type'}">
                        <div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">&nbsp;</div>
                            <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">${info}</div>
                            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">${curInfos.get(info)}</div>
                        </div>
                    </c:if>
                </c:forEach>
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><hr/></div>
                </c:forEach>
            </c:forEach>


        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><br/></div>

        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <button class="btn btn-success">Valider</button>
        </div> 

        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><br/></div>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><br/></div>

        <input type="hidden" name="idResearcher" value="<c:choose><c:when test="${! empty researcher}">${researcher.researcherId}</c:when><c:otherwise>-1</c:otherwise></c:choose>" />
        <input type="hidden" name="connectionCode" value="${connectedUser.connectionCode}" />
    </form>

    <%@ include file="footer.jspf" %>

</body>
</html>