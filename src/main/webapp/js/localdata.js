// DATATABLE Tools
var myButtons = new Array();

function showDataTable(tableName) {
    var theTable = document.getElementById(tableName);
    if (theTable !== null) {
        let spinner = document.getElementById("fountainG");
        if (spinner !== null) {
            spinner.parentElement.removeChild(spinner);
        }
        theTable.style.visibility = "visible";
        theTable.style.width = "100%";
    }
}

function addDataTableButtonCopy() {
    myButtons.push({
        extend: 'copy',
        exportOptions: {rows: {selected: true}}
    });
}

function addDataTableButtonCsv() {
    myButtons.push({
        extend: 'csv',
        exportOptions: {rows: {selected: true}}
    });
}

function addDataTableButtonPrint() {
    myButtons.push({
        extend: 'print',
        exportOptions: {rows: {selected: true}}
    });
}

function addDataTableButtonExcel() {
    myButtons.push({
        extend: 'excelHtml5',
        exportOptions: {rows: {selected: true}},
        customize: function (xlsx) {
            var sheet = xlsx.xl.worksheets['sheet1.xml'];
            $('row c[r^="C"]', sheet).attr('s', '2');
        }
    });
}

function addDataTableButtonSelectAll() {
    myButtons.push('selectAll');
}

function addDataTableButtonDeselectAll() {
    myButtons.push('selectNone');
}

function addDataTableButtonImport(tableImport) {
    myButtons.push({
        text: 'Import',
        action: function (e, dt, node, conf) {
            launchnewscreenparamater(null, tableImport, -1);
        }
    });
}

function addDataTableButtonNew(tableEdit) {
    myButtons.push({
        text: 'NEW',
        action: function (e, dt, node, conf) {
            launchnewscreenparamater(null, tableEdit, -1);
        }
    });
}

function buildTable(tableName) {
    // Structure table
    let table = $('#' + tableName).DataTable({
        "fnDrawCallback": function (oSettings) {
            showDataTable(tableName);
        },
        rowReorder: {
            selector: 'td:nth-child(1)'
        },
        "responsive": true,
        "lengthChange": true,
        "lengthMenu": [[10, 50, 100, -1], [10, 50, 100, "All"]],
        "pageLength": 10,
/*        "language": {
            "sProcessing": "Traitement en cours...",
//            "sSearch": "Rechercher&nbsp;:",
//            "sLengthMenu": "Afficher _MENU_ &eacute;l&eacute;ments",
//            "sInfo": "Affichage de l'&eacute;l&eacute;ment _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
//            "sInfoEmpty": "Affichage de l'&eacute;l&eacute;ment 0 &agrave; 0 sur 0 &eacute;l&eacute;ment",
//            "sInfoFiltered": "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
//            "sInfoPostFix": ""
            "sLoadingRecords": "Chargement en cours...",
            "sZeroRecords": "Aucun &eacute;l&eacute;ment &agrave; afficher",
            "sEmptyTable": "Aucune donn&eacute;e disponible",
            "oPaginate": {
                "sFirst": "Premier",
                "sPrevious": "Pr&eacute;c&eacute;dent",
                "sNext": "Suivant",
                "sLast": "Dernier"
            },
            "oAria": {
                "sSortAscending": ": activer pour trier la colonne par ordre croissant",
                "sSortDescending": ": activer pour trier la colonne par ordre d&eacute;croissant"
            }
        },*/
        dom: 'Bfrtipl',
        buttons: myButtons,
        select: true
    });

    return table;
}

