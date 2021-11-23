/**
 * set json info
 * @param {type} key
 * @param {type} value
 * @returns {undefined}
 */
function jsonAddInfo(key, value) {
    var myEscapedJSONString = ("" + value).replace(/\\n/g, "\\n")
            .replace(/\\'/g, "\\'")
            .replace(/\\"/g, '\\"')
            .replace(/\\&/g, "\\&")
            .replace(/\\r/g, "\\r")
            .replace(/\\t/g, "\\t")
            .replace(/\\b/g, "\\b")
            .replace(/\\f/g, "\\f");
    return '"' + key + '" : "' + myEscapedJSONString + '"';
}

/**
 * Prepare form to be applied
 * @param {type} action
 * @param {type} elementId
 * @returns {undefined}
 */
function setFormParameters(action, elementId) {
    var selectedIDRef = document.getElementById("selectedID");
    var actionRef = document.getElementById("action");
    if (selectedIDRef !== null) {
        selectedIDRef.value = elementId;
    }
    if (actionRef !== null) {
        actionRef.value = action;
    }
}

/**
 * Enable save and revert buttons
 * @returns {undefined}
 */
function enableSaveButton() {
    // Get buttons
    var button1 = document.getElementById("Save");
    var button2 = document.getElementById("Revert");
    var button3 = document.getElementById("Remove");
    var button4 = document.getElementById("Import");

    let canProcess = true;
    if (button4 !== null) {
        canProcess = checkImport();
    }

    // switch buttons
    if (canProcess) {
        if (button1 !== null) {
            button1.classList.add('btn-success');
            button1.classList.remove('disabled');
        }
        if (button2 !== null) {
            button2.classList.add('btn-warning');
            button2.classList.remove('disabled');
        }
        if (button3 !== null) {
            button3.classList.add('btn-danger');
            button3.classList.remove('disabled');
        }
        if (button4 !== null) {
            button4.classList.add('btn-success');
            button4.classList.remove('disabled');
        }
    }
}

/**
 * Disable save and revert buttons
 * @returns {undefined}
 */
function disableSaveButton() {
    // Get buttons
    var button1 = document.getElementById("Save");
    var button2 = document.getElementById("Revert");
    var button3 = document.getElementById("Remove");
    var button4 = document.getElementById("Import");

    // switch buttons
    if (button1 !== null) {
        button1.classList.remove('btn-success');
        button1.classList.add('disabled');
    }
    if (button2 !== null) {
        button2.classList.remove('btn-warning');
        button2.classList.add('disabled');
    }
    if (button3 !== null) {
        button3.classList.add('btn-danger');
        button3.classList.remove('disabled');
    }
    if (button4 !== null) {
        button4.classList.add('btn-success');
        button4.classList.remove('disabled');
    }
}

/**
 * Specific import file validation
 * @returns {Boolean}
 */
function checkImport() {
    var label = document.getElementById("label");
    var importFile = document.getElementById("importFile");

    if ((label === null) || (importFile === null))
        return true;
    else
        return ((label.value !== "") && (importFile.value !== ""));
}

/**
 * Generic save element
 * @param {type} idField
 * @param {fct} altProcess
 * @returns {undefined}
 */
function saveFields(idField, altProcess = null) {
    var mainform = document.getElementById("mainform");
    var idElement = document.getElementById(idField);
    var values = setValues(mainform);
    values.action = "save";

    $.ajax({
        url: "ajax.do",
        data: values,
        method: "POST",
        async: false,
        success: function (result) {
            if (result.id > 0) {
                idElement.value = result.id;
                if (altProcess !== null) {
                    altProcess(result);
                }
                disableSaveButton();
            }
        },
        error: function (resultat, statut, erreur) {
            console.log("error" + resultat + statut + erreur);
        }
    });
}

/**
 * Save group - get fields and save them
 * @returns {undefined}
 */
function saveFieldsGroup() {
    var idField = "groupEdit";
    var mainform = document.getElementById("mainform");
    var values = setValues(mainform);
    values.action = "save";
    // Remove users and members select
    values.users = [];
    values.members = [];
    // Add full members list
    var membersRef = document.getElementById("members");
    var tagName = "OPTION";
    var element = getNextTag(membersRef.firstChild, tagName);
    while (element !== null) {
        values.members.push(element.value);
        element = getNextTag(element.nextSibling, tagName);
    }

    $.ajax({
        url: "ajax.do",
        data: values,
        method: "POST",
        async: false,
        success: function (result) {
            if (result.id > 0) {
                var idElement = document.getElementById("groupId");
                idElement.value = result.id;
                disableSaveButton();
            }
        },
        error: function (resultat, statut, erreur) {
            console.log("error" + resultat + statut + erreur);
        }
    });
}


/**
 * Save group - get fields and save them
 * @returns {undefined}
 */
function saveFieldsTest() {
    var idField = "testEdit";
    var mainform = document.getElementById("mainform");
    var values = setValues(mainform);
    values.action = "save";
    values.groups = [];
    var groupsRef = document.getElementById("rGroups");
    var tagName = "OPTION";
    var element = getNextTag(groupsRef.firstChild, tagName);
    while (element !== null) {
        values.groups.push(element.value);
        element = getNextTag(element.nextSibling, tagName);
    }

    $.ajax({
        url: "ajax.do",
        data: values,
        method: "POST",
        async: false,
        success: function (result) {
            if (result.id > 0) {
                var idElement = document.getElementById("testId");
                idElement.value = result.id;
                disableSaveButton();
            }
        },
        error: function (resultat, statut, erreur) {
            console.log("error" + resultat + statut + erreur);
        }
    });
}

/**
 * Remove element
 * @param {type} idField
 * @param {type} menu
 * @returns {undefined}
 */
function removeElement(idField, menu) {
    var mainform = document.getElementById("mainform");
    var mainscreen = document.getElementById("screenmain");
    var codeform = document.getElementById("code");
    var idElement = document.getElementById(idField);

    var jsonString = "{";
    jsonString += jsonAddInfo("app", "Saturne");
    jsonString += ',' + jsonAddInfo("code", codeform.value);
    jsonString += ',' + jsonAddInfo("mainscreen", mainscreen.value);
    jsonString += ',' + jsonAddInfo("value", idElement.value);
    jsonString += "}";

    var values = JSON.parse(jsonString);
    values.action = "remove";

    $.ajax({
        url: "ajax.do",
        data: values,
        method: "POST",
        async: false,
        success: function (result) {
            launchnewmenu(menu);
        },
        error: function (resultat, statut, erreur) {
            console.log("error" + resultat + statut + erreur);
        }
    });
}

/**
 * Get elements in a form
 * @param {type} reference
 * @returns {Array|getFormElements.liste}
 */
function getFormElements(reference) {
    var liste = new Array();
    if ((reference !== null) && (reference.nodeType === Node.ELEMENT_NODE)) {
        // reference is node
        if (reference.tagName === "INPUT") {
            liste.push(reference);
        } else if (reference.tagName === "SELECT") {
            liste.push(reference);
        } else if (reference.tagName === "TEXTAREA") {
            liste.push(reference);
        } else {
            // do not contain intersting element, par childs
            var element = reference.firstChild;
            while (element !== null) {
                var liste2 = getFormElements(element);
                liste2.forEach(function (item, index, array) {
                    liste.push(item);
                });
                element = element.nextSibling;
            }
        }
    }
    return liste;
}

/**
 * Get fields values in a form and prepare them as a JSON object
 * @param {type} reference
 * @returns {Array|Object}
 */
function setValues(reference) {
    var jsonString = "{";
    jsonString += jsonAddInfo("app", "Saturne");
    if (reference !== null) {
        var liste = getFormElements(reference);
        liste.forEach(function (item, index, array) {
            if (item.tagName === "INPUT") {
                if (item.type.toLowerCase() === "radio") {
                    if (item.checked) {
                        jsonString += ',' + jsonAddInfo(item.name, item.value);
                    }
                } else if (item.type.toLowerCase() === "checkbox") {
                    if (item.checked) {
                        jsonString += ',' + jsonAddInfo(item.name, item.value);
                    } else {
                        jsonString += ',' + jsonAddInfo(item.name, 0);
                    }

                } else {
                    jsonString += ',' + jsonAddInfo(item.name, item.value);
                }
            } else if (item.tagName === "SELECT") {
                if (item.multiple) {
                    var options = item.selectedOptions;
                    for (let j = 0; j < options.length; j++) {
                        var optionValue = options[j].value;
                        jsonString += ',' + jsonAddInfo(item.name + "[" + j + "]", optionValue);
                    }
                } else {
                    jsonString += ',' + jsonAddInfo(item.name, item.value);
                }
            } else if (item.tagName === "TEXTAREA") {
                jsonString += ',' + jsonAddInfo(item.name, item.value);
            } else {
                jsonString += ',' + jsonAddInfo(item.name, "");
            }
        });
    }
    jsonString = jsonString + "}";
    var returned = JSON.parse(jsonString);
    return returned;
}

/**
 * Get parent tag
 * @param {type} aTag
 * @param {type} tagName
 * @returns {unresolved}
 */
function getParentTag(aTag, tagName) {
    while ((aTag !== null) && ((aTag.nodeType !== 1) || (aTag.tagName !== tagName))) {
        aTag = aTag.parentNode;
    }
    return aTag;
}

/**
 * Get next tag
 * @param {type} aTag
 * @param {type} tagName
 * @returns {unresolved}
 */
function getNextTag(aTag, tagName) {
    while ((aTag !== null) && ((aTag.nodeType !== 1) || (aTag.tagName !== tagName))) {
        aTag = aTag.nextSibling;
    }
    return aTag;
}

/**
 * Get prev tag
 * @param {type} aTag
 * @param {type} tagName
 * @returns {unresolved}
 */
function getPrevTag(aTag, tagName) {
    while ((aTag !== null) && ((aTag.nodeType !== 1) || (aTag.tagName !== tagName))) {
        aTag = aTag.previousSibling;
    }
    return aTag;
}

function createTag(tagName, beforeNode) {
    var element = document.createElement(tagName.toUpperCase());
    var parentNode = beforeNode.parentNode;

    var insertedNode = parentNode.insertBefore(element, beforeNode);
    return insertedNode;
}

function createHidden(name, beforeNode) {
    var element = document.createElement("INPUT");
    elementsetAttribute("type", "hidden");
    elementsetAttribute("name", name);
    elementsetAttribute("id", name);
    elementsetAttribute("value", "");

    var parentNode = beforeNode.parentNode;

    var insertedNode = parentNode.insertBefore(element, beforeNode);
    return insertedNode;

}

/**
 * remove tag children
 * @param {type} aTag
 * @returns {undefined}
 */
function removeTagContent(aTag) {
    if (aTag !== null) {
        while ((aTag.firstChild !== null)) {
            aTag.removeChild(aTag.firstChild);
        }
    }
}

/**
 * Find specific option valie in a select
 * @param {type} selectRef
 * @param {type} optionId
 * @returns {.aTag.nextSibling.nextSibling|getOptionInSelect.current}
 */
function getOptionInSelect(selectRef, optionId) {
    var returnedRef = null;
    if (selectRef !== null) {
        var tagName = "OPTION";
        let current = getNextTag(selectRef.firstChild, tagName);
        while ((current !== null) && (returnedRef === null)) {
            if (current.value == optionId) {
                returnedRef = current;
            } else {
                current = getNextTag(current.nextSibling, tagName);
            }
        }
    }
    return returnedRef;
}

/**
 * Switch elements from one list to the other one
 * @param {type} orig
 * @param {type} dest
 * @param {type} liste
 * @returns {undefined}
 */
function switchElementsInLists(orig, dest, liste) {
    // Get elements
    var listeNew = [];
    for (let i = 0; i < liste.length; i++) {
        let element = getOptionInSelect(orig, liste[i].value);
        if (element !== null) {
            listeNew.push(element);
        }
    }
    listeNew.sort(function (a, b) {
        if (a.label < b.label)
            return -1;
        if (a.label > b.label)
            return 1;
        return 0;
    });

    // Switch elements from orig to dest
    var tagName = "OPTION";
    var nextDest = getNextTag(dest.firstChild, tagName);
    for (let i = 0; i < listeNew.length; i++) {
        let element = listeNew[i];
        while ((nextDest !== null) && (nextDest.label < element.label)) {
            nextDest = getNextTag(nextDest.nextSibling, tagName);
        }
        if (orig !== null) {
            orig.removeChild(element);
        }
        dest.insertBefore(element, nextDest);
    }
}

/**
 * Switch elements from a list to another one
 * @param {type} orig
 * @param {type} dest
 * @returns {undefined}
 */
function addElementToList(orig, dest) {
    var origList = document.getElementById(orig);
    var destList = document.getElementById(dest);
    var selected = origList.selectedOptions;
    switchElementsInLists(origList, destList, selected);
    enableSaveButton();
}

/**
 * Empty members list
 * @returns {undefined}
 */
function emptyFieldsGroup() {
    var members = document.getElementById("members");
    var users = document.getElementById("users");

    var selected = [];
    var tagName = "OPTION";
    let current = getNextTag(members.firstChild, tagName);
    while (current !== null) {
        selected.push(current);
        current = getNextTag(current.nextSibling, tagName);
    }
    switchElementsInLists(members, users, selected);
    enableSaveButton();
}

/**
 * Import group from file
 * @returns {undefined}
 */
function ImportGroup() {
    var mainform = document.getElementById("mainform");
    var menumain = document.getElementById("menumain");
    var screenmain = document.getElementById("screenmain");
    if ((mainform !== null) && (menumain !== null) && (screenmain !== null)) {
        // Switch enctype and launch action
        mainform.action = "LoadPageScreen.do";
        mainform.enctype = "multipart/form-data";
        mainform.submit();
    }
}

/**
 * 
 * @returns {undefined}Add new keyword
 */
function addKeyword() {
    var codeform = document.getElementById("code");
    var mainscreen = document.getElementById("screenmain");

    var keywordList = document.getElementById("keywords");
    var keywordRef = document.getElementById("aKeyword");

    var jsonString = "{";
    jsonString += jsonAddInfo("app", "Saturne");
    jsonString += ',' + jsonAddInfo("code", codeform.value);
    jsonString += ',' + jsonAddInfo("mainscreen", mainscreen.value);
    jsonString += ',' + jsonAddInfo("value", keywordRef.value);
    jsonString += "}";

    var values = JSON.parse(jsonString);
    values.action = "addKeyword";

    $.ajax({
        url: "ajax.do",
        data: values,
        method: "POST",
        async: false,
        success: function (result) {
            var tagName = "OPTION";
            let newOption = document.createElement(tagName);
            newOption.label = keywordRef.value;
            newOption.value = result.id;

            var nextDest = getNextTag(keywordList.firstChild, tagName);
            while ((nextDest !== null) && (nextDest.label < keywordRef.value)) {
                nextDest = getNextTag(nextDest.nextSibling, tagName);
            }
            keywordList.insertBefore(newOption, nextDest);
            keywordRef.value = "";
        },
        error: function (resultat, statut, erreur) {
            console.log("error" + resultat + statut + erreur);
        }
    });
}

/**
 * switch elements according to question type (unique, multiple, other)
 * @returns {undefined}
 */
function changeResponses() {
    var responsesRef = document.getElementById("responses");
    var typeQuestionRef = document.getElementById("typequestion");
    var typeQuestion = typeQuestionRef.value;

    switch (typeQuestion) {
        case "1" :
            // Make it visible
            responsesRef.classList.remove("displayNone");
            responsesRef.classList.add("displayBlock");
            // Switch checkbox to radio
            var inputList = document.getElementsByTagName("INPUT");
            for (let i = 0; i < inputList.length; i++) {
                let ref = inputList[i];
                if (ref.type === "checkbox") {
                    ref.type = "radio";
                    ref.name = "repV";
                }
            }
            break;
        case "2" :
            // Make it visible
            responsesRef.classList.remove("displayNone");
            responsesRef.classList.add("displayBlock");
            // Switch radio to checkbox
            var inputList = document.getElementsByTagName("INPUT");
            for (let i = 0; i < inputList.length; i++) {
                let ref = inputList[i];
                if (ref.type === "radio") {
                    ref.type = "checkbox";
                    let value = ref.value;
                    ref.name = "repV[" + value + "]";
                }
            }
            break;
        default :
            // Make it invisible
            responsesRef.classList.remove("displayBlock");
            responsesRef.classList.add("displayNone");
            break;
    }
}

/**
 * Remove possible response
 * @param {type} ref
 * @returns {undefined}
 */
function removeResponse(ref) {
    var tr = getParentTag(ref, "TR");
    tr.parentNode.removeChild(tr);
}

/**
 * Add new response
 * Can be done ONLY IF user can save
 * @returns {undefined}
 */
function addResponse() {
    var typequestionRef = document.getElementById("typequestion");
    var newResponseRef = document.getElementById("newResponse");
    var newRepVRef = document.getElementById("newRepV");
    var lineAddRef = document.getElementById("lineAdd");
    var typequestion = typequestionRef.value;

    // get elements to add
    var newResponse = newResponseRef.value;
    var newRepV = newRepVRef.checked;

    var table = getParentTag(lineAddRef, "TABLE");
    var tbody = getNextTag(table.firstChild, "TBODY");

    // Clone line and add it to the table
    var lineAdd = lineAddRef.cloneNode(true);
    lineAdd.removeAttribute("id");
    tbody.insertBefore(lineAdd, lineAddRef);
    lineAdd.style.display = "table-row";

    // Get first TD in lineAdd, get index
    var td = getNextTag(lineAddRef.firstChild, "TD");
    var inputHidden = getNextTag(td.firstChild, "INPUT");
    var indexValue = inputHidden.value;
    inputHidden.value = indexValue - 1;

    // Add elements and remove ADDs ones

    // First : ID and text
    td = getNextTag(lineAdd.firstChild, "TD");
    inputHidden = getNextTag(td.firstChild, "INPUT");
    inputHidden.setAttribute("name", "responsepId[" + indexValue + "]");
    inputHidden.value = indexValue;

    var contentRef = getNextTag(td.firstChild, "TEXTAREA");
    contentRef.setAttribute("name", "responseText[" + indexValue + "]");
    contentRef.value = newResponse;
    newResponseRef.value = "";

    // Next : checkbox / TRUE / FALSE
    td = getNextTag(td.nextSibling, "TD");
    var inputCorrectRef = getNextTag(td.firstChild, "INPUT");
    if (typequestion === "1") {
        inputCorrectRef.setAttribute("name", "repV");
    } else {
        inputCorrectRef.setAttribute("name", "repV[" + indexValue + "]");
    }
    inputCorrectRef.value = indexValue;
    inputCorrectRef.checked = newRepV;
    newRepVRef.checked = false;

    enableSaveButton();
}

/**
 * Sear for questions with the rights keywords
 * @returns {undefined}
 */
function searchQuestions() {
    var codeform = document.getElementById("code");
    var mainscreen = document.getElementById("screenmain");

    var questionList = document.getElementById("questions");
    var currentList = document.getElementById("qQuestions");
    var keywordList = document.getElementById("rKeywords");
    var options = keywordList.selectedOptions;

    var jsonString = "{";
    jsonString += jsonAddInfo("app", "Saturne");
    jsonString += ',' + jsonAddInfo("code", codeform.value);
    jsonString += ',' + jsonAddInfo("mainscreen", mainscreen.value);
    for (let j = 0; j < options.length; j++) {
        var optionValue = options[j].value;
        jsonString += ',' + jsonAddInfo("searchkw" + "[" + j + "]", optionValue);
    }
    for (let j = 0; j < currentList.length; j++) {
        var optionValue = currentList[j].value;
        jsonString += ',' + jsonAddInfo("curkw" + "[" + j + "]", optionValue);
    }
    jsonString += "}";

    var values = JSON.parse(jsonString);
    values.action = "searchQuestions";

    $.ajax({
        url: "ajax.do",
        data: values,
        method: "POST",
        async: false,
        success: function (result) {
            // First remove current questions
            removeTagContent(questionList);

            // Add new questions
            var tagName = "OPTION";
            let newQuestions = result.questions;
            for (let j = 0; j < newQuestions.length; j++) {
                let newOption = document.createElement(tagName);
                newOption.label = newQuestions[j].value;
                newOption.value = newQuestions[j].id;
                questionList.appendChild(newOption);
            }
        },
        error: function (resultat, statut, erreur) {
            console.log("error" + resultat + statut + erreur);
        }
    });
}

/**
 * Save responses for a question
 * @param {type} result
 * @returns {undefined}
 */
function saveResponses(result) {
    if (result !== null) {
        var replacedIds = result.replacedIds;
        var answersRed = document.getElementById("answers");
        var bodyRef = getNextTag(answersRed.firstChild, "TBODY");
        var typequestionRef = document.getElementById("typequestion");
        var typequestion = typequestionRef.value;

        replacedIds.forEach(replacedId => switchResponseIds(bodyRef, replacedId, typequestion));
    }
}

function switchResponseIds(bodyRef, replacedId, typequestion) {
    if (replacedId !== null) {
        var origin = replacedId.origin;
        var newId = replacedId.newId;

        // Look for the line
        var found = false;
        var startRef = getNextTag(bodyRef.firstChild, "TR");
        while ((startRef !== null) && (!found)) {
            let td = getNextTag(startRef.firstChild, "TD");
            let inputHidden = getNextTag(td.firstChild, "INPUT");
            if (inputHidden.value == origin) {
                found = true;
            } else {
                startRef = getNextTag(startRef.nextSibling, "TR");
            }
        }
        if (found) {
            let td = getNextTag(startRef.firstChild, "TD");

            let inputHidden = getNextTag(td.firstChild, "INPUT");
            inputHidden.setAttribute("name", "responsepId[" + newId + "]");
            inputHidden.value = newId;
            let textRef = getNextTag(td.firstChild, "TEXTAREA");
            textRef.setAttribute("name", "responsepText[" + newId + "]");

            td = getNextTag(td.nextSibling, "TD");
            let checkBox = getNextTag(td.firstChild, "INPUT");
            checkBox.value = newId;
            if (typequestion == 1) {
                checkBox.setAttribute("name", "repV");
            } else {
                checkBox.setAttribute("name", "repV[" + newId + "]");
            }
        }
    }
}

function closeTest() {
}

function processSelectLineTest(quizTRLine) {
    if (quizTRLine !== null) {
        let td = getNextTag(quizTRLine.firstChild, "TD");
        let inputHidden = getNextTag(td.firstChild, "INPUT");

        let idValue = inputHidden.value;
        td = getNextTag(td.nextSibling, "TD");
        let texte = td.firstChild.textContent;
        td = getNextTag(td.nextSibling, "TD");
        td = getNextTag(td.nextSibling, "TD");
        let duration = "00:15";
        if ((td.firstChild !== null) && (td.firstChild.textContent !== null)) {
            duration = td.firstChild.textContent;
        }

        let quizLabelRef = document.getElementById("quizLabel");
        let quizIdRef = document.getElementById("quizId");
        let durationRef = document.getElementById("testDuration");

        quizLabelRef.value = texte;
        quizIdRef.value = idValue;
        durationRef.value = duration;
    }
}

function manageResearcherStatus() {
    var statusRef = document.getElementById("statut");
    if (statusRef !== null) {
        if (statusRef.value === "23") {
            showhidePHDData(true);
        } else {
            showhidePHDData(false);
        }
    }
}

function showhidePHDData(showhide) {
    var phdDataRef = document.getElementById("phdData");
    if (phdDataRef !== null) {
        var element  = getNextTag(phdDataRef.nextSibling  , "TR");
        while (element !== null) {
            if ((showhide) && (! element.classList.contains("notVisible"))) {
                element.classList.add("notVisible");
            } else if ((! showhide) && (element.classList.contains("notVisible"))) {
                element.classList.remove("notVisible");
            }
            element  = getNextTag(element.nextSibling  , "TR");
        }
    }
}