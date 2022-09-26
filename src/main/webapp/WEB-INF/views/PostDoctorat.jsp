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
        <div class="header">
            <%@ include file="header.jspf" %>
        </div>
        <script>
            function downloadCSV(csv, filename) {
                var csvFile;
                var downloadLink;

                // CSV file
                csvFile = new Blob([csv], {type: "text/csv"});

                // Download link
                downloadLink = document.createElement("a");

                // File name
                downloadLink.download = filename;

                // Create a link to the file
                downloadLink.href = window.URL.createObjectURL(csvFile);

                // Hide download link
                downloadLink.style.display = "none";

                // Add the link to DOM
                document.body.appendChild(downloadLink);

                // Click download link
                downloadLink.click();
            }
            function exportData(filename) {


                var csv = [];
                var row = [];
                const Chercheur = document.myForm.Chercheur.value;
                const nom = document.myForm.nom.value;
                const superviseur = document.myForm.superviseur.value;
                const dateArr = document.myForm.dateArr.value;
                const dateDep = document.myForm.dateDep.value;
                const duree = document.myForm.duree.value;
                const nationalite = document.myForm.nationalite.value;
                const labOrigin = document.myForm.labOrigin.value;

                row = [Chercheur, nom, superviseur, dateArr, dateDep, duree, nationalite, labOrigin]

                // Download CSV file
                csv.push(row.join(";"));


                // Download CSV file
                downloadCSV(csv.join("\n"), filename);


            }
        </script>
        <div class="contenu">
            <div class="activContainer">
                <form name="myForm" class="edu" onSubmit="exportData('education.csv')">
                    <label>Chercheur</label>
                    <input name="Chercheur" id="Chercheur" placeholder="Nom Chercheur" />

                    <label>Nom</label>
                    <input name="nom" type="text" />

                    <label>Superviseur</label>
                    <input name="superviseur" type="text" />

                    <label>Date d'arrivé</label>
                    <input name="dateArr" type="date" />

                    <label>Date de départ</label>
                    <input name="dateDep" type="date" />

                    <label>Durée</label>
                    <input name="duree" type="number" />

                    <label>Nationalité</label>
                    <input name="nationalite" type="text" />

                    <label>Laboratoire d'origine</label>
                    <input name="labOrigin" type="text" />
                    
                    <div class="cc4">
                        <div class="item5">
                            <bouton class="btn1" type="submit" onClick="exportData('activite.csv')"/>valider</bouton>

                        </div>
                    </div>
                </form>
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