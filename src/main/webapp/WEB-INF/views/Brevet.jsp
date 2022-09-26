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
                const typeBrevet = document.myForm.typeBrevet.value;
                const titre = document.myForm.titre.value;
                const dateEnr = document.myForm.dateEnr.value;
                const dateDep = document.myForm.dateDep.value;
                const dateAcc = document.myForm.dateAcc.value;
                const dateLic = document.myForm.dateLic.value;
                const inventeurs = document.myForm.inventeurs.value;
                const coproprietaires = document.myForm.v.value;
                const numProp = document.myForm.numProp.value;
                const dateProp = document.myForm.dateProp.value;
                const numPub = document.myForm.numPub.value;
                const datePub = document.myForm.datePub.value;
                const status = document.myForm.status.value;
                const extensionpct = document.myForm.extensionpct.value;
                const numExtPct = document.myForm.numExtPct.value;
                const dateExtPct = document.myForm.dateExtPct.value;
                const extensionInter = document.myForm.extensionInter.value;
                const numExtInter = document.myForm.numExtInter.value;
                const dateExtInter = document.myForm.dateExtInter.value;
                const refContact = document.myForm.refContact.value;
                const nomEntreprise = document.myForm.nomEntreprise.value;
                

                row = [Chercheur, typeBrevet, titre, dateEnr, dateDep, dateAcc, 
                    dateLic, inventeurs, coproprietaires, numProp, dateProp, 
                numPub, datePub, status, extensionpct, numExtPct, dateExtPct, 
                extensionInter, numExtInter, dateExtInter, refContact, nomEntreprise]

                // Download CSV file
                csv.push(row.join(";"));


                // Download CSV file
                downloadCSV(csv.join("\n"), filename);


            }
        </script>
        
        <div class="contenu">
            <div class="activContainer">
                <form name="myForm" class="edu" onSubmit="exportData('brevet.csv')">
                    <label>Chercheur</label>
                    <input name="Chercheur" id="nom" placeholder="Nom Chercheur" />

                    <label>Type du brevet</label>
                    <input name="typeBrevet" id="typeBrevet" placeholder="Choisir le type du brevet" />

                    <label>Titre</label>
                    <input name="titre" type="text" />

                    <label>Date d'enregistrement</label>
                    <input name="dateEnr" type="date" />

                    <label>date de dépôt</label>
                    <input name="dateDep" type="date" />

                    <label>Date d'acceptation</label>
                    <input name="dateAcc" type="date" />

                    <label>Date de licence</label>
                    <input name="dateLic" type="date" />

                    <label>Inventeurs</label>
                    <textarea name="inventeurs"></textarea>

                    <label>Copropriétaires</label>
                    <textarea name="coproprietaires"></textarea>

                    <label>Numéro de propriété</label>
                    <input name="numProp" type="text" />

                    <label>Date de propriété</label>
                    <input name="dateProp" type="date" />

                    <label>Numéro de publication</label>
                    <input name="numPub" type="text" />

                    <label>Date de publication</label>
                    <input name="datePub" type="date" />

                    <label>Status</label>
                    <input name="status" type="text" placeholder="Obtenu/Non obtenu" />
<!--                        <option value="true">Obtenu</option>
                        <option value="false">Non obtenu</option>
                    </select>-->

                    <label>Extension PCT</label>
                    <input name="extensionpct" type="text" placehodler="Obtenu/Non obtenu" />
<!--                        <option value="true">Obtenu</option>
                        <option value="false">Non obtenu</option>
                    </select>-->

                    <label>Numéro d'extension PCT</label>
                    <input name="numExtPct" type="text" />

                    <label>Date d'extension PCT</label>
                    <input name="dateExtPct" type="date" />

                    <label>Extension internationale</label>
                    <input name="extensionInter" type="text" placeholder="Obtenu/Non obtenu" />
<!--                        <option value="true">Obtenu</option>
                        <option value="false">Non obtenu</option>
                    </select>-->

                    <label>Numéro d'extension internationale</label>
                    <input name="numExtInter" type="text" />

                    <label>Date d'extension internationale</label>
                    <input name="dateExtInter" type="date" />

                    <label>Référence de contrat de transfert</label>
                    <input name="refContact" type="text" />

                    <label>Nom d'entreprise impliquée</label>
                    <input name="nomEntreprise" type="text" />
                    
                    <div class="cc4">
                        <div class="item5">
                            <bouton class="btn1" type="submit" onClick="exportData('brevet.csv')"/>valider</bouton>

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