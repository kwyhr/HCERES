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

        <h1 class="headTitle">Liste des chercheurs</h1> 

        <main id="pagecontent" class="row" >

            <form method="POST" id="mainform" action="handleResearcher.do">
                <input type="hidden" name="connectionCode" value="${connectedUser.connectionCode}" />
                <input type="hidden" name="selectedID" id="selectedID" value="" />
                <input type="hidden" name="action" id="action" value="" />
                
                <div id="fountainG">
                    <div id="fountainG_1" class="fountainG"></div>
                    <div id="fountainG_2" class="fountainG"></div>
                    <div id="fountainG_3" class="fountainG"></div>
                    <div id="fountainG_4" class="fountainG"></div>
                    <div id="fountainG_5" class="fountainG"></div>
                    <div id="fountainG_6" class="fountainG"></div>
                    <div id="fountainG_7" class="fountainG"></div>
                    <div id="fountainG_8" class="fountainG"></div>
                </div>

                <table class="sortable" id="researchersList" style="visibility:hidden;">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Last Name</th>
                            <th>First Name</th>
                            <th>Email</th>
                            <th>ORCID</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody class="bodyTable">
                        <c:forEach var="item" items="${researchersList}" varStatus="count">
                            <tr>
                                <td>${count.index + 1}</td>
                                <td>${item.researcherSurname}</td>
                                <td>${item.researcherName}</td>
                                <td>${item.researcherEmail}</td>
                                <td>${item.researcherOrcid}</td>
                                <td>
                                    <button class="btn btn-xs"
                                            onclick="setFormParameters('edit', ${item.researcherId}); return true;">
                                        <img src="images/edit.png" height="20" alt="Edit"/></button>
                                    <button class="btn btn-xs"
                                            onclick="setFormParameters('delete', ${item.researcherId}); return true;">
                                        <img src="images/delete.png" height="20" alt="Edit"/></button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <th></th>
                            <th id="slastname">Last Name</th>
                            <th id="sfirstname">First Name</th>
                            <th id="semail">Email</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </tfoot>
                </table>

                <script>
                    var tableName = "researchersList";
                    $(document).ready(function () {
                        // Setup - add a text input to each footer cell
                        $('#' + tableName + ' tfoot th').each(function () {
                            var theId = $(this).attr("id");
                            if ((theId !== null) && (typeof theId !== 'undefined') && (theId !== "")) {
                                var title = $(this).text();
                                $(this).html('<input type="text" name="search_' + theId + '" placeholder="' + title + '" value="" />');
                            }
                        });

                        addDataTableButtonCopy();
                        addDataTableButtonCsv();
                        addDataTableButtonPrint();
                        addDataTableButtonExcel();
                        addDataTableButtonSelectAll();
                        addDataTableButtonDeselectAll();
                        addDataTableButtonNew("researchersList")
                        var table = buildTable(tableName);

                        // Apply the search
                        table.columns().every(function () {
                            var that = this;
                            $('input', this.footer()).on('keyup change', function () {
                                if (that.search() !== this.value) {
                                    that.search(this.value).draw();
                                }
                            });
                        });
                    });
                </script>
            </form>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><br/></div>
        </main>

        <%@ include file="footer.jspf" %>

    </body>
</html>

