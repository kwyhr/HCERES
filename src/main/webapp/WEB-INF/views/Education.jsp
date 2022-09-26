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
                const name = document.myForm.nom.value;
                const cours = document.myForm.cours.value;
                const dateCompletition = document.myForm.dateCompletition.value;
                const formation = document.myForm.formation.value;
                const level = document.myForm.level.value;
                const description = document.myForm.description.value;

                row = [name, cours, dateCompletition, formation, level, description]

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
                    <input name="nom" id="nom" placeholder="Nom Chercheur" />

                    <label>Cours</label>
                    <input name="cours" type="text" placeholder="Cours"/>

                    <label>Date de completition</label>
                    <input name="dateCompletition" type="date" />

                    <label>Formation</label>
                    <input name="formation" type="text" />

                    <label>Niveau</label>
                    <input name="level" id="level" placeholder="Choisir un niveau" />

                    <label>Description</label>
                    <textarea name="description"></textarea>
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
    </body>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>